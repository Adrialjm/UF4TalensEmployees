package com.AdriaJose.departament.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departament")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departament_id")
    private int departament_Id;

    @Column(name = "titol")
    private String titol;

    @Column(name = "descripcio")
    private String descripcio;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "departament", cascade = CascadeType.ALL)
    private List<Treballador> treballadors = new ArrayList<>();

    public Departament() {}

    public Departament(String titol, String descripcio, String url) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.url = url;
    }

    public int getDepartamentId() {
        return departament_Id;
    }

    public void setDepartamentId(int departament_Id) {
        this.departament_Id = departament_Id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Treballador> getTreballador() {
        return treballadors;
    }

    public void setTreballadors(List<Treballador> treballadors) {
        this.treballadors = treballadors;
    }
}
