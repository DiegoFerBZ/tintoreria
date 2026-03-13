package com.alquiler.proyecto.model.prendas.factory;

import com.alquiler.proyecto.dtos.request.CrearPrendaDTO;
import com.alquiler.proyecto.model.prendaStates.EstadoPrenda;
import com.alquiler.proyecto.model.prendas.Disfraz;
import com.alquiler.proyecto.model.prendas.Prenda;
import com.alquiler.proyecto.model.prendas.TrajeCaballero;
import com.alquiler.proyecto.model.prendas.VestidoDama;

public class PrendaFactory {

    public static Prenda crear(CrearPrendaDTO dto) {

        return switch (dto.tipo()) {

            case VESTIDO_DAMA -> {
                VestidoDama v = new VestidoDama(
                        dto.referencia(),
                        dto.valorAlquiler()
                );

                v.setPedreria(dto.pedreria());
                v.setAltura(dto.altura());
                v.setCantPiezas(dto.cantPiezas());
                v.setEstado(EstadoPrenda.DISPONIBLE);

                yield v;
            }

            case TRAJE_CABALLERO -> {
                TrajeCaballero t = new TrajeCaballero(
                        dto.referencia(),
                        dto.valorAlquiler()
                );

                t.setAderezo(dto.aderezo());
                t.setTipo(dto.tipoTraje());
                t.setEstado(EstadoPrenda.DISPONIBLE);

                yield t;
            }

            case DISFRAZ -> {
                Disfraz d = new Disfraz(
                        dto.referencia(),
                        dto.valorAlquiler()
                );

                d.setNombre(dto.nombre());
                d.setEstado(EstadoPrenda.DISPONIBLE);

                yield d;
            }
        };
    }
}
