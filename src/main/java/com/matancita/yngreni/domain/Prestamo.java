package com.matancita.yngreni.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "prestamo")
@Data
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_prestamo")
    private Long idPrestamo;

    private LocalDateTime fecha;

    private double monto;

    @Column(name = "tipo_prestamo")
    private String tipoPrestamo;

    private LocalDateTime vencimiento;

    private double interes;

    private int cuotas;

    private int anulado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;



}
