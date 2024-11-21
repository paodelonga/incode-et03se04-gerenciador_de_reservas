package br.dev.paodelonga.gerenciador_de_reservas.Repositorio;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hospede;

import java.util.LinkedList;

public class RepositorioHospede {
    private LinkedList<Hospede> listaHospedes;

    public RepositorioHospede() {
        this.listaHospedes = new LinkedList<Hospede>();
    }

    // Getters
    public LinkedList<Hospede> getListaHospedes() {
        return listaHospedes;
    }

    public Hospede getHospede(Hospede hospede) {
        return (listaHospedes.contains(hospede)) ? listaHospedes.get(
            listaHospedes.indexOf(hospede)
        ) : null;
    }

    // Setters
    public LinkedList<Hospede> setListaHospedes(LinkedList<Hospede> lista_hospedes) {
        listaHospedes = lista_hospedes;
        return listaHospedes;
    }

    // Adders
    public Hospede addHospede(Hospede hospede) {
        if (!listaHospedes.contains(hospede)) {
            listaHospedes.add(hospede);
        }
        return listaHospedes.get(listaHospedes.indexOf(hospede));
    }

    // Removers
    public Hospede removeHospede(Hospede hospede) {
        return (listaHospedes.contains(hospede)) ? listaHospedes.remove(
            listaHospedes.indexOf(hospede)
        ) : null;
    }
}
