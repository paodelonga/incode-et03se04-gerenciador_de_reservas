package br.dev.paodelonga.gerenciador_de_reservas.Repositorio;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Reserva;

import java.util.LinkedList;

public class RepositorioReserva {
    private LinkedList<Reserva> listaReservas;

    public RepositorioReserva() {
        this.listaReservas = new LinkedList<Reserva>();
    }

    // Getters
    public LinkedList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public Reserva getReserva(Reserva reserva) {
        return (listaReservas.contains(reserva)) ? listaReservas.get(
            listaReservas.indexOf(reserva)
        ) : null;
    }

    // Setters
    public LinkedList<Reserva> setListaReservas(LinkedList<Reserva> lista_reservas) {
        listaReservas = lista_reservas;
        return listaReservas;
    }

    // Adders
    public Reserva addReserva(Reserva reserva) {
        if (!listaReservas.contains(reserva)) {
            listaReservas.add(reserva);
        }
        return listaReservas.get(listaReservas.indexOf(reserva));
    }

    public Reserva removeReserva(Reserva reserva) {
        return (listaReservas.contains(reserva)) ? listaReservas.remove(
            listaReservas.indexOf(reserva)
        ) : null;
    }
}
