package com.example.demo;

public class Dipendente {
    private int id;
    private String cognome;
    private String mansione;
    private double stipendio;

    public Dipendente() {}

    public Dipendente(int id, String cognome, String mansione, double stipendio) {
        this.id = id;
        this.cognome = cognome;
        this.mansione = mansione;
        this.stipendio = stipendio;
    }

    // Metodi getter e setter per i campi della classe Dipendente

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMansione() {
        return mansione;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    @Override
    public String toString() {
        return "Dipendente [id=" + id + ", cognome=" + cognome + ", mansione=" + mansione + ", stipendio=" + stipendio
                + "]";
    }
}
