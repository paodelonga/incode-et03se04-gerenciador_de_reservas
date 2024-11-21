package br.dev.paodelonga.gerenciador_de_reservas.Repositorio;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Quarto;

import java.util.LinkedList;

public class RepositorioQuarto {
    private LinkedList<Quarto> listaQuartos;

    public RepositorioQuarto() {
        this.listaQuartos = new LinkedList<Quarto>();
    }

    // Getters
    public LinkedList<Quarto> getListaQuartos() {
        return listaQuartos;
    }

    public Quarto getQuarto(Quarto quarto) {
        return (listaQuartos.contains(quarto)) ? listaQuartos.get(
            listaQuartos.indexOf(quarto)
        ) : null;
    }

    // Setters
    public LinkedList<Quarto> setListaQuartos(LinkedList<Quarto> lista_quartos) {
        listaQuartos = lista_quartos;
        return listaQuartos;
    }

    // Adders
    public Quarto addQuarto(Quarto quarto) {
        if (!listaQuartos.contains(quarto)) {
            listaQuartos.add(quarto);
        }
        return listaQuartos.get(listaQuartos.indexOf(quarto));
    }

    // Removers
    public Quarto removeQuarto(Quarto quarto) {
        return (listaQuartos.contains(quarto)) ? listaQuartos.remove(
            listaQuartos.indexOf(quarto)
        ) : null;
    }
}
