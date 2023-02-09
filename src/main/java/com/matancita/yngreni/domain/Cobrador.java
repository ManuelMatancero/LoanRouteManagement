package com.matancita.yngreni.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="cobrador")
public class Cobrador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cobrador")
    private Long idCobrador;

    private String nombre;

    private String  apellido;

    private String cedula;

    private String direccion;

    private String  telefono;

    @Column(name="fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "id_cobrador")
    private List<Ruta> rutas;
}
