package br.dev.paodelonga.gerenciador_de_reservas.Servico;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hospede;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hotel;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Quarto;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Reserva;
import br.dev.paodelonga.gerenciador_de_reservas.Tipo.QuartoNome;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Map;

public class Servico {
    Hotel hotel;

    public Servico(Integer quantidade_maxima_reserva) {
        Hotel hotel = new Hotel("Lumen", quantidade_maxima_reserva);
    }

    // Coistas internas (eu quero usar mvc :crying :crying
    public void alterarNomeHotel(String nome) {}

    // Adders
    public Reserva adicionarReserva(Reserva reserva) {}
    public Quarto adicionarQuarto(Quarto quarto) {}
    public Hospede adicionarHospede(Hospede hospede) {}
    public boolean adicionarQuartoTabela(QuartoNome nome, BigDecimal valor, Integer quantidade) {}

    // Obters
    public String obterNomeHotel() {}
    public Reserva obterReserva(Reserva reserva) {}
    public Quarto obterQuarto(Quarto quarto) {}
    public Hospede obterHospede(Hospede hospede) {}
    public Map<BigDecimal, Integer> obterQuartoTabela(QuartoNome nome) {}

    // Listers
    public LinkedList<Reserva> obterListaReservas() {}
    public LinkedList<Quarto> obterListaQuartos() {}
    public LinkedList<Hospede> obterListaHospedes() {}
    // E agora voce se pergunta: ah, por que não temos um `obterListaQuartosTabela`?
    // é que... gafanhato, fudeu!

    // Removers
    public Reserva removerReserva(Reserva reserva) {}
    public Quarto removerQuarto(Quarto quarto) {}
    public Hospede removerHospede(Hospede hospede) {}
    public QuartoNome removerQuartoTabela(QuartoNome nome) {}

    // Coisitas externas
    // Só pra deixar claro, esse aqui é o cara que faz a reserva no "front"
    public Quarto alugarQuarto(Hospede hospede, Quarto quarto) {
    }

    public Reserva consultarReserva(Reserva reserva) {
    }

    public Reserva cancelarReserva(Reserva reserva) {
    }

    public Reserva pagarReserva(Reserva reserva) {
    }

    public Reserva fazerCheckIn(Reserva reserva) {
    }

    public Reserva fazerCheckOut(Reserva reserva) {
    }

    public LinkedList<Reserva> listarReservas() {
    }
}
