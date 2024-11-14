package br.dev.paodelonga.gerenciador_de_reservas.Servico;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hospede;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hotel;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Quarto;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Reserva;
import br.dev.paodelonga.gerenciador_de_reservas.Tipo.QuartoNome;

import java.math.BigDecimal;

public class Servico {
    Hotel hotel;

    public Servico(Integer quantidade_maxima_reserva) {
        Hotel hotel = new Hotel("Lumen", quantidade_maxima_reserva);
    }

    // Coistas internas (eu quero usar mvc :crying :crying
    public void alterarNomeHotel(String nome) {}

    // Adders
    public void adicionarReserva(Reserva reserva) {}
    public void adicionarQuarto(Quarto quarto) {}
    public void adicionarHospede(Hospede hospede) {}
    public void adicionarQuartoTabela(QuartoNome nome, BigDecimal valor, Integer quantidade) {}

    // Obters
    public void obterNomeHotel() {}
    public void obterReserva(Reserva reserva) {}
    public void obterQuarto(Quarto quarto) {}
    public void obterHospede(Hospede hospede) {}
    public void obterQuartoTabela(QuartoNome nome) {}

    // Listers
    public void obterListaReservas() {}
    public void obterListaQuartos() {}
    public void obterListaHospedes() {}
    public void obterListaQuartosTabela() {}

    // Removers
    public void removerReserva(Reserva reserva) {}
    public void removerQuarto(Quarto quarto) {}
    public void removerHospede(Hospede hospede) {}
    public void removerQuartoTabela(QuartoNome nome) {}

    // Coisitas externas
    public void alugarQuarto(Hospede hospede, Quarto quarto) {
    }

    public void consultarReserva(Reserva reserva) {
    }

    public void cancelarReserva(Reserva reserva) {
    }

    public void pagarReserva(Reserva reserva) {
    }

    public void fazerCheckIn(Reserva reserva) {
    }

    public void fazerCheckOut(Reserva reserva) {
    }

    public void listarReservas() {
    }
}
