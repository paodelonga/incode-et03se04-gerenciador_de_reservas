package br.dev.paodelonga.gerenciador_de_reservas;

import br.dev.paodelonga.gerenciador_de_reservas.Aplicacao.Menu;
import br.dev.paodelonga.gerenciador_de_reservas.Servico.Servico;

public class GerenciadorDeReservas {
    public static void main(String[] args) {
        Servico servico = new Servico();
        Menu menu = new Menu(servico);
    }
}
