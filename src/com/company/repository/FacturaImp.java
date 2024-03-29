package com.company.repository;

import com.company.model.Cliente;
import com.company.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository <Factura>{

    List <Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void save(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {

        for (Factura fact : listaFacturas) {
            System.out.println(fact.toString());

        }

    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {

        boolean bandera = false;
        for (Factura f : listaFacturas) {
            if (f.getCodigo().equals(codigoBuscado)) {
                System.out.println("----Factura encontrada, sus datos son: ----");
                System.out.println(f.toString());
                return Optional.of(f);
            }
        }

        if (bandera == false) {
            System.out.println("Factura no encontrada");
        }

        return Optional.empty();

    }

    @Override
    public void eliminar(Long codigoBorrado) {

        Optional<Factura> fact = this.buscar(codigoBorrado);

        if (fact.isPresent()) {
            System.out.println("Factura borrada correctamente");
            listaFacturas.remove(fact.get());
        }
        else {

            System.out.println("No se encontró la factura a borrar");
        }

    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}
