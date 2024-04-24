package com.example.oblig3data1700;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillettRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreBillett(Billetter enBillett) {
        String sql = "INSERT INTO Billetter(film, antall, fnavn, enavn, tlf, epost) VALUES(?, ?, ?, ?, ?, ?)";
    db.update(sql, enBillett.getFilm(), enBillett.getAntall(), enBillett.getFnavn(), enBillett.getEnavn(), enBillett.getTlf(), enBillett.getEpost());
    }

    public List<Billetter> hentAlle(){
        String sql = "SELECT * FROM Billetter ORDER BY 'ENAVN' DESC" ;
        List<Billetter> alleBilletter =
                db.query(sql, new BeanPropertyRowMapper<>(Billetter.class));

        return alleBilletter;
    }


    //Sletter alt i tabellen Billetter samtidig
    public void slettAlle(){
        String sql = "DELETE FROM Billetter";
        db.update(sql);
    }

    public void slettEn(Long id) {
        String sql = "DELETE FROM Billetter WHERE id=?;";
        db.update(sql, id);
    }
}
