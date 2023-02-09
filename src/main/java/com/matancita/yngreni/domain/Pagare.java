package com.matancita.yngreni.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "pagare")
@Data
public class Pagare implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pagare")
    private Long idPagare;

    @Column(name = "no_pagare")
    private int noPagare;

    private double capital;

    private double interes;

    private double total;

    private LocalDateTime vencimiento;

    @ManyToOne
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo")
    private Prestamo prestamo;

    @OneToMany
    @JoinColumn(name = "id_pagare")
    private List<RecibosGen> recibosGen;

}
