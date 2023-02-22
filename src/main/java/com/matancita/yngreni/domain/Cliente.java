package com.matancita.yngreni.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="cliente")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long idCliente;

    private String nombre;

    private String apellido;

    private String cedula;

    private String direccion;

    @Column(name = "fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    @Column(name="lugar_trabajo")
    private String lugarTrabajo;

    @Column(name="tel_trabajo")
    private String telTrabajo;

    private String celular;

    @Column(name="tel_residencia")
    private String telResidencia;

    private String email;

    private String ocupacion;

    private String recomendado;

    private String observaciones;

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    private int estatus;

    @ManyToOne
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    private Ruta ruta;

    @OneToMany
    @JoinColumn(name = "id_cliente")
    private List<Prestamo> prestamos;

}
