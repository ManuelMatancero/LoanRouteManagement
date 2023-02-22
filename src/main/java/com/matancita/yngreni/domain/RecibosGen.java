package com.matancita.yngreni.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "recibos_gen")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idRecibosGen")
public class RecibosGen implements Serializable {

    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recibos_gen")
    private Long idRecibosGen;

    private LocalDateTime fecha;

    private double valor;

    @ManyToOne
    @JoinColumn(name = "id_pagare", referencedColumnName = "id_pagare")
    private Pagare pagare;
}
