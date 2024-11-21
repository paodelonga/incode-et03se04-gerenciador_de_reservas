package br.dev.paodelonga.gerenciador_de_reservas.Repositorio;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hotel;

import java.util.LinkedList;

public class RepositorioHotel {
    private LinkedList<Hotel> listaHoteis;

    public RepositorioHotel() {
        this.listaHoteis = new LinkedList<Hotel>();
    }

    // Getters
    public LinkedList<Hotel> getListaHoteis() {
        return listaHoteis;
    }

    public Hotel getHotel(Hotel hotel) {
        return (listaHoteis.contains(hotel)) ? listaHoteis.get(
            listaHoteis.indexOf(hotel)
        ) : null;
    }

    // Setters
    public LinkedList<Hotel> setListaHoteis(LinkedList<Hotel> lista_hoteis) {
        listaHoteis = lista_hoteis;
        return listaHoteis;
    }

    // Adders
    public Hotel addHotel(Hotel hotel) {
        if (!listaHoteis.contains(hotel)) {
            listaHoteis.add(hotel);
        }
        return listaHoteis.get(listaHoteis.indexOf(hotel));
    }

    // Removers
    public Hotel removeHotel(Hotel hotel) {
        return (listaHoteis.contains(hotel)) ? listaHoteis.remove(
            listaHoteis.indexOf(hotel)
        ) : null;
    }

}
