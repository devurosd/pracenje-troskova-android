package com.example.pracenjetroskova;

public class Trosak {

    private String naziv;
    private double iznos;

    private int datumDan;
    private int datumMesec;
    private int datumGodina;

    public Trosak(String naziv , double iznos, int datumDan, int datumMesec, int datumGodina){
        this.naziv = naziv;
        this.iznos = iznos;
        this.datumDan = datumDan;
        this.datumMesec = datumMesec + 1;
        this.datumGodina = datumGodina;
    }

    public String getNaziv(){
        return naziv;
    }

    public double getIznos(){
        return iznos;
    }

    public int getDatumDan(){
        return datumDan;
    }

    public int getDatumMesec(){
        return datumMesec;
    }

    public int getDatumGodina(){
        return datumGodina;
    }
    @Override
    public String toString(){
        String ispis = String.format("Iznos (rsd): %30.2f\nNaziv: %s\nDatum: %d.%d.%d.",
                                    iznos, naziv, datumDan, datumMesec, datumGodina);
        return ispis;
    }

}
