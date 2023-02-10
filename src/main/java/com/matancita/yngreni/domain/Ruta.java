package com.matancita.yngreni.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name= "ruta")
@Data
//Con esta anotacion evito la recursion infinita al listar con el metodo get
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idRuta")
public class Ruta implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ruta")
    private Long idRuta;

    private String nombre;


    private String dia;


    @ManyToOne
    @JoinColumn(name = "id_zona", referencedColumnName = "id_zona")
    private Zona zona;


    @ManyToOne
    @JoinColumn(name = "id_cobrador", referencedColumnName = "id_cobrador")
    @JsonBackReference
    private Cobrador cobrador;

    @OneToMany
    @JoinColumn(name = "id_ruta")
    private List<Cliente> clientes;

}
