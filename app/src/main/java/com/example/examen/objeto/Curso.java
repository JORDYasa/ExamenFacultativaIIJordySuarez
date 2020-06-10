package com.example.examen.objeto;

public class Curso {

    private int image;
    private String nombrec;
    private String descripcionc;
    private String costoc;
    private String horasc;
    private String requisitosc;

    public Curso() { //Constructor vacio
    }

    //Contructor inicializado con atributos
    public Curso(String nombrec, String descripcionc, String costoc, String horasc, String requisitosc) {

        this.nombrec = nombrec;
        this.descripcionc = descripcionc;
        this.costoc = costoc;
        this.horasc = horasc;
        this.requisitosc = requisitosc;
    }


    //getter y setter para cada atributo
    public int getImage() { return image; }

    public void setImage(int image) { this.image = image; }

    public String getNombrec() { return nombrec; }

    public void setNombrec(String nombrec) { this.nombrec = nombrec; }

    public String getDescripcionc() { return descripcionc; }

    public void setDescripcionc(String descripcionc) { this.descripcionc = descripcionc; }

    public String getCostoc() { return costoc; }

    public void setCostoc(String costoc) { this.costoc = costoc; }

    public String getHorasc() { return horasc; }

    public void setHorasc(String horasc) { this.horasc = horasc; }

    public String getRequisitosc() { return requisitosc; }

    public void setRequisitosc(String requisitosc) { this.requisitosc = requisitosc; }

}
