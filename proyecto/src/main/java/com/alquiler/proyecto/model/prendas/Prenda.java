package com.alquiler.proyecto.model.prendas;

import com.alquiler.proyecto.model.interfaces.IEstadoPrenda;
import com.alquiler.proyecto.model.prendaStates.EstadoDisponible;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendaStates.EstadoPrendaFactory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Transient;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PostLoad;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_prenda")
@NoArgsConstructor
public abstract class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String referencia;

    private double valorAlquiler;

    @Enumerated(EnumType.STRING)
    private EstadoPrenda estado;

    @Transient
    @JsonIgnore
    private IEstadoPrenda estadoActual;

    public Prenda(String referencia, double valorAlquiler) {
        this.referencia = referencia;
        this.valorAlquiler = valorAlquiler;
    }

    public void inicializarEstado() {
        this.estadoActual = EstadoPrendaFactory.crear(estado);
    }

    public void setEstado(EstadoPrenda estado) {
        this.estado = estado;
        this.estadoActual = EstadoPrendaFactory.crear(estado);
    }

    public void alquilar() {
        estadoActual.alquilar(this);
    }

    public void entregar() {
        estadoActual.entregar(this);
    }

    public void enviarALavado() {
        estadoActual.enviarALavado(this);
    }

    public void finalizarLavado() {
        estadoActual.finalizarLavado(this);
    }

    @PostLoad
    public void postLoad() {
        this.inicializarEstado();
    }
}
