//Kjøres når vi klikker registrer-button og kjører registrer() hvis error = 0
function inputValidering() {

    // Kode for error melding, legger til 1 og viser feilmelding i stedet for å pushe til array
    let error = 0;

    const antallPattern = /^[1-9][0-9]*$/; // Kontrollerer om positive tall
    const navnPattern = /^[a-zA-Z]+$/; // Kontrollerer om bare bokstaver
    const tlfPattern = /^\d{8,}$/; // Minst åtte siffere
    const epostPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // Kontrollerer om gyldig email

    let x = document.getElementById("film").value;
    // Hvis film 0 er valgt, vis feilmelding
    if (x === "0") {
        document.getElementById("film-e").innerHTML = "Velg en film!";
        error += 1;
    } else {
        document.getElementById("film-e").innerHTML = "";
    }

    if (!antallPattern.test(document.getElementById("antall").value)) {
        document.getElementById("antall-e").innerHTML = "Velg antall billetter!";
        error += 1;
    } else {
        document.getElementById("antall-e").innerHTML = "";
    }

    if (!navnPattern.test(document.getElementById("fnavn").value)) {
        document.getElementById("fnavn-e").innerHTML = "Fyll inn fornavn!";
        error += 1;
    } else {
        document.getElementById("fnavn-e").innerHTML = "";
    }

    if (!navnPattern.test(document.getElementById("enavn").value)) {
        document.getElementById("enavn-e").innerHTML = "Fyll inn etternavn!";
        error += 1;
    } else {
        document.getElementById("enavn-e").innerHTML = "";
    }

    if (!tlfPattern.test(document.getElementById("tlf").value)) {
        document.getElementById("tlf-e").innerHTML = "Skriv inn et mobilnummer med 8 siffre!";
        error += 1;
    } else {
        document.getElementById("tlf-e").innerHTML = "";
    }

    if (!epostPattern.test(document.getElementById("epost").value)) {
        document.getElementById("epost-e").innerHTML = "Fyll inn gyldig epost!";
        error += 1;
    } else {
        document.getElementById("epost-e").innerHTML = "";
    }

    if(error === 0) {
        register();
        console.log("Input er godkjent");
        clearInput();
    }
}

//bilett er objektet som inneholder flere variabler (i lilla)
function register() {
    let billett = {
        film: $("#film").val(),
        antall: $("#antall").val(),
        fnavn: $("#fnavn").val(),
        enavn: $("#enavn").val(),
        tlf: $("#tlf").val(),
        epost: $("#epost").val(),
    }
    // annetArray.push(billett);
    //pusher billett-objketet inn i annetArray

    // Objektet bilett blir sendt til backend
    //"/lagre" er for url, når jeg er på riktig url blir billett sendt
    //så etter at billett er sendt, kjører hentAlle() funksjonen
    $.post("/lagre", billett, function() {
        hentAlle();
    });
}

//Resetter feltene ved å sette det til en tom streng
function clearInput() {
    $("#film").val("0");
    $("#antall").val("");
    $("#fnavn").val("");
    $("#enavn").val("");
    $("#tlf").val("");
    $("#epost").val("");
}

//hentAlle henter info tilbake fra server fra get i java
//så kjører funsjonen formaterData med verdien billetter som vi fikk av getMappinga
function hentAlle() {
    $.get("/hentAlle", function(billetter) {
        formaterData(billetter)
    });
}
//billetter er arrayet
function formaterData(billetter) {
    //Lager en ny tabell for å vise bilettinformasjon
    let ut = "<table><tr>" +
        "<th>Film</th> <th>Antall</th>" +
        "<th>Navn</th> <th>Etternavn</th>" +
        "<th>Telefon</th> <th>Email</th>" +
        "</tr>";
    for (let billett of billetter) {
        ut += "<tr>";
        ut +=
            "<td>" + billett.film + "</td>" +
            "<td>" + billett.antall + "</td>" +
            "<td>" + billett.fnavn + "</td>" +
            "<td>" + billett.enavn + "</td>" +
            "<td>" + billett.tlf + "</td>" +
            "<td>" + billett.epost + "</td>" +
            "<td>"+ billett.id + "</td>" +
            "<td>" + "<button onclick='slettBareEn(" + billett.id + ")'> Slett bare en billett</button>" + "</td>" +
            "<td>" + "<button onclick='endreBillett(" + billett.id + ")'> Endre billett</button>" + "</td>";
        ut += "</tr>";
        console.log(billett);
    }
    $("#alleBilletter").html(ut);
}

function slettBilett() {
    let slett = "";
    document.getElementById("alleBilletter").innerHTML = slett;
    $.ajax({
            url: "/slettAlle",
            method: "delete",
            success: function () {
                console.log("Alle billettene er slettet")
                hentAlle();
            }
    });
}


function slettBareEn(id) {
    let url = "/slettEn?id="+id;
    $.ajax({
        url: url,
        method: "delete",
        success: function () {
            console.log("en billett er slettet")
            hentAlle();
        }
    });
}


function endreBillett(id) {
    //let url = "/endre?id="+id;
    console.log(id);
    const billett = {
        id: id,
        film: $("#endrefilm").val(),
        antall: $("#endreantall").val(),
        fnavn: $("#endrefnavn").val(),
        enavn: $("#endreenavn").val(),
        tlf: $("#endretlf").val(),
        epost: $("#endreepost").val()

        };
    /*$.ajax({
        url: url,
        type: "post",
        async: false,
        data: JSON.stringify(billett),
        contentType: "application/JSON",
        dataType: "text",
        success: function (result, status, xhr) {
            console.log("en billett er endret: "+result);
            hentAlle();
        },
        error: function(xhr){
            alert("An error occured: "+xhr.status+" "+xhr.statusText);
        }
    });*/
        $.post("/endre", billett, function(){
            hentAlle();
        });

}

