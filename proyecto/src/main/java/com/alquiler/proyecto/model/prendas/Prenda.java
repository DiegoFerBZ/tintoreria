package com.alquiler.proyecto.model.prendas;

import java.util.ArrayList;
import java.util.List;

import com.alquiler.proyecto.model.interfaces.IEstadoPrenda;
import com.alquiler.proyecto.model.observer.AuditoriaObserver;
import com.alquiler.proyecto.model.observer.LavadoQueueObserver;
import com.alquiler.proyecto.model.observer.interfaces.PrendaEstadoObserver;
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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @Transient
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<PrendaEstadoObserver> observers = new ArrayList<>();

    public Prenda(String referencia, double valorAlquiler) {
        this.referencia = referencia;
        this.valorAlquiler = valorAlquiler;
        initObservers();
    }

    public void addObserver(PrendaEstadoObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(PrendaEstadoObserver observer) {
        this.observers.remove(observer);
    }

    private void initObservers() {
        this.observers.add(new AuditoriaObserver());
        this.observers.add(new LavadoQueueObserver());
    }

    private void notifyObservers(EstadoPrenda estadoAnterior, EstadoPrenda estadoNuevo) {
        observers.forEach(obs -> obs.onEstadoCambiado(this, estadoAnterior, estadoNuevo));
    }

    public void inicializarEstado() {
        this.estadoActual = EstadoPrendaFactory.crear(estado);
    }

    public void setEstado(EstadoPrenda estado) {
        EstadoPrenda estadoAnterior = this.estado;
        this.estadoActual = EstadoPrendaFactory.crear(estado);
        this.estado = estado;
        if (estadoAnterior != null) {
            notifyObservers(estadoAnterior, estado);
        }
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
        initObservers();
    }
}
