package com.AdriaJose.departament.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "treballador")
public class Treballador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treballador_id")
    private int treballadorId;

    @Column(name = "nom")
    private String treballadorNom;

    @Column(name = "cognom")
    private String treballadorCognom;

    @Column(name = "genere")
    private String genere;

    @Column(name = "data_naixement")
    private Date dataNaixement;

    @Column(name = "data_contractacio")
    private Date dataContractacio;

    @Column(name = "salari")
    private double salari;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    private Departament departament;

    public Treballador() {}

    public Treballador(String nom, String cognom, String genere, Date dataNaixement, Date dataContractacio, double salari, Departament departament) {
        this.treballadorNom = nom;
        this.treballadorCognom = cognom;
        this.genere = genere;
        this.dataNaixement = dataNaixement;
        this.dataContractacio = dataContractacio;
        this.salari = salari;
        this.departament = departament;
    }

    public int getTreballadorId() {
        return treballadorId;
    }

    public void setTreballadorId(int treballadorId) {
        this.treballadorId = treballadorId;
    }

    public String getTreballadorNom() {
        return treballadorNom;
    }

    public void setTreballadorNom(String nom) {
        this.treballadorNom = nom;
    }

    public String getTreballadorCognom() {
        return treballadorCognom;
    }

    public void setTreballadorCognom(String cognom) {
        this.treballadorCognom = cognom;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Date getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(Date dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public Date getDataContractacio() {
        return dataContractacio;
    }

    public void setDataContractacio(Date dataContractacio) {
        this.dataContractacio = dataContractacio;
    }

    public double getSalari() {
        return salari;
    }

    public void setSalari(double salari) {
        this.salari = salari;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }
}
