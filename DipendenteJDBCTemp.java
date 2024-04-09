package com.example.demo;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class DipendenteJDBCTemp {
    
	
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }

    public int insertDipendente(String cognome, String mansione, double stipendio) {
        String query = "INSERT INTO Dipendente (cognome, mansione, stipendio) VALUES (?, ?, ?)";
        return jdbcTemplateObject.update(query, cognome, mansione, stipendio);
    }

    public int updateCognome(String cognomeNuovo, String cognome) {
        String query = "UPDATE Dipendente SET cognome = ? WHERE cognome = ?";
        return jdbcTemplateObject.update(query, cognome);
    }

    public int updateMansione(String mansione, String cognome) {
        String query = "UPDATE Dipendente SET mansione = ? WHERE cognome = ?";
        return jdbcTemplateObject.update(query, mansione);
    }

    public int updateStipendio(double stipendio, String cognome) {
        String query = "UPDATE Dipendente SET stipendio = ? WHERE cognome = ?";
        return jdbcTemplateObject.update(query, stipendio, cognome);
    }

    public int deleteDipendente(int id) {
        String query = "DELETE FROM Dipendente WHERE id = ?";
        return jdbcTemplateObject.update(query, id);
    }
    public int deleteDipendente(String  cognome) {
        String query = "DELETE FROM Dipendente WHERE cognome = ?";
        return jdbcTemplateObject.update(query, cognome);
    }
    public class DipendenteResultSetExtractor implements ResultSetExtractor<ArrayList<Dipendente>> {
        @Override
        public ArrayList<Dipendente> extractData(ResultSet rs) throws SQLException, DataAccessException {
            ArrayList<Dipendente> dipendenti = new ArrayList<>();
            while (rs.next()) {
                Dipendente dipendente = new Dipendente();
                dipendente.setId(rs.getInt("id"));
                dipendente.setCognome(rs.getString("cognome"));
                dipendente.setMansione(rs.getString("mansione"));
                dipendente.setStipendio(rs.getDouble("stipendio"));
                dipendenti.add(dipendente);
            }
            return dipendenti;
        }
    }
 // Metodo per selezionare tutti i dipendenti dalla tabella e restituirli in un ArrayList
    public ArrayList<Dipendente> selectDipendenti() {
    	 String query = "SELECT * FROM Dipendente";
    	 ArrayList<Dipendente> dipendenti = jdbcTemplateObject.query(query, new DipendenteResultSetExtractor());

    	 
    	    return dipendenti;
    	    

    }
    // Metodo per eseguire query DDL
    public void executeDDLQuery(String query) {
        jdbcTemplateObject.execute(query);
    }
}
