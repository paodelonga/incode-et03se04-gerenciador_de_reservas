package br.dev.paodelonga.gerenciador_de_reservas.Servico;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hospede;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hotel;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Quarto;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Reserva;
import br.dev.paodelonga.gerenciador_de_reservas.Repositorio.RepositorioHospede;
import br.dev.paodelonga.gerenciador_de_reservas.Repositorio.RepositorioHotel;
import br.dev.paodelonga.gerenciador_de_reservas.Repositorio.RepositorioQuarto;
import br.dev.paodelonga.gerenciador_de_reservas.Repositorio.RepositorioReserva;
import br.dev.paodelonga.gerenciador_de_reservas.Tipo.QuartoTipo;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Servico {
    private RepositorioHospede repositorioHospede;
    private RepositorioHotel repositorioHotel;
    private RepositorioQuarto repositorioQuarto;
    private RepositorioReserva repositorioReserva;

    public Servico() {
        repositorioHospede = new RepositorioHospede();
        repositorioHotel = new RepositorioHotel();
        repositorioQuarto = new RepositorioQuarto();
        repositorioReserva = new RepositorioReserva();

        iniciar();
    }

    // Reserva
    public LinkedList<Reserva> obterListaDeReservas() {
        return repositorioReserva.getListaReservas();
    }

    public Reserva obterReserva(Reserva reserva) {
        return repositorioReserva.getReserva(reserva);
    }

    public Reserva obterReservaPorIDemHotel(String identificador, String nome_hotel) {
        return repositorioReserva.getReserva(
            new Reserva(new Hotel(nome_hotel), identificador)
        );
    }

    public Reserva adicionarReserva(Reserva reserva) {
        return repositorioReserva.addReserva(reserva);
    }

    public Reserva removerReservaPorIDEmHotel(String identificador, String nome_hotel) {
        return repositorioReserva.removeReserva(
            new Reserva(new Hotel(nome_hotel), identificador)
        );
    }

    public Reserva removerReserva(Reserva reserva) {
        return repositorioReserva.removeReserva(reserva);
    }

    // Quarto
    public LinkedList<Quarto> obterListaDeQuartos() {
        return repositorioQuarto.getListaQuartos();
    }

    public Quarto obterQuarto(Quarto quarto) {
        return repositorioQuarto.getQuarto(quarto);
    }

    public Quarto obterQuartoPorNumeroEmHotel(Integer numero, String nome_hotel) {
        return repositorioQuarto.getQuarto(
            new Quarto(
                new Hotel(nome_hotel),
                numero
            )
        );
    }

    public Quarto adicionarQuarto(Quarto quarto) {
        return repositorioQuarto.addQuarto(quarto);
    }

    public Quarto removerQuartoPorNumeroEmHotel(Integer numero, String nome_hotel) {
        return repositorioQuarto.removeQuarto(
            new Quarto(
                new Hotel(nome_hotel),
                numero
            )
        );
    }

    public Quarto removerQuarto(Quarto quarto) {
        return repositorioQuarto.removeQuarto(quarto);
    }

    // Hospede
    public LinkedList<Hospede> obterListaDeHospedes() {
        return repositorioHospede.getListaHospedes();
    }

    public Hospede obterHospede(Hospede hospede) {
        return repositorioHospede.getHospede(hospede);
    }

    public Hospede obterHospedePorDocumentoEmHotel(String documento, String nome_hotel) {
        return repositorioHospede.getHospede(
            new Hospede(
                new Hotel(nome_hotel),
                documento
            )
        );
    }

    public Hospede adicionarHospede(Hospede hospede) {
        return repositorioHospede.addHospede(hospede);
    }

    public Hospede removerHospedePorDocumentoEmHotel(String documento, String nome_hotel) {
        return repositorioHospede.removeHospede(
            new Hospede(
                new Hotel(nome_hotel),
                documento
            )
        );
    }

    public Hospede removerHospede(Hospede hospede) {
        return repositorioHospede.removeHospede(hospede);
    }

    // Hotel
    public LinkedList<Hotel> obterListaDeHosteis() {
        return repositorioHotel.getListaHoteis();
    }

    public Hotel obterHotel(Hotel hotel) {
        return repositorioHotel.getHotel(hotel);
    }

    public Hotel obterHotelPorNome(String nome_hotel) {
        return repositorioHotel.getHotel(
            new Hotel(nome_hotel)
        );
    }

    public Hotel adicionarHotel(Hotel hotel) {
        return repositorioHotel.addHotel(hotel);
    }

    public Hotel removerHotelPorNome(String nome_hotel) {
        return repositorioHotel.removeHotel(
            new Hotel(nome_hotel)
        );
    }

    public Hotel removerHotel(Hotel hotel) {
        return repositorioHotel.removeHotel(hotel);
    }

    public Hotel alterarNomeDeHotel(Hotel hotel, String novo_nome) {
        return obterHotel(hotel).setNome(novo_nome);
    }

    public LinkedList<QuartoTipo> obterListaDeTiposDeQuartoEmHotel(String nome_hotel) {
        return obterHotelPorNome(nome_hotel).getTiposQuarto();
    }

    public List<QuartoTipo> obterQuartosDisponiveisEmHotel(String nome_hotel) {
        LinkedList<QuartoTipo> lista_de_quartos = obterListaDeTiposDeQuartoEmHotel(nome_hotel);

        return lista_de_quartos
            .stream()
            .filter(
                quartoTipo -> quartoTipo.getQuantidade() > 0
            )
            .toList();
    }

    public QuartoTipo obterTipoDeQuartoEmHotel(String nome_hotel, QuartoTipo quarto_tipo) {
        return obterHotelPorNome(nome_hotel).getQuartoTipo(quarto_tipo);
    }

    public QuartoTipo obterTipoDeQuartoPorNomeEmHotel(String nome_hotel, String nome_quarto) {
        return obterHotelPorNome(nome_hotel).getQuartoTipo(new QuartoTipo(nome_quarto));
    }

    public QuartoTipo adicionarTipoDeQuartoEmHotel(String nome_hotel, QuartoTipo quarto_tipo) {
        return obterHotelPorNome(nome_hotel).addQuartoTipo(quarto_tipo);
    }

    public QuartoTipo removerTipoDeQuartoEmHotel(String nome_hotel, QuartoTipo quarto_tipo) {
        return obterHotelPorNome(nome_hotel).removeQuartoTipo(quarto_tipo);
    }

    public QuartoTipo removerTipoDeQuartoPorNomeEmHotel(String nome_hotel, String nome_quarto) {
        return obterHotelPorNome(nome_hotel).removeQuartoTipo(new QuartoTipo(nome_quarto));
    }

    //
    public Hotel cadastrarHotel(Hotel hotel) {
        return repositorioHotel.addHotel(hotel);
    }

    public void alugarQuarto(Reserva reserva) {
    }

    public void consultarReserva(Reserva reserva) {
    }

    public void cancelarReserva(Reserva reserva) {
    }

    public void pagarReserva(Reserva reserva) {
    }

    public void fazerCheckin(Reserva reserva) {
    }

    public void fazerCheckout(Reserva reserva) {
    }

    public void listarReservas() {
    }

    public void iniciar() {
        cadastrarHotel(new Hotel("Teste"));

        adicionarTipoDeQuartoEmHotel("teste", new QuartoTipo(
                "Luxous",
                BigDecimal.valueOf(240.00),
                1
            )
        );

        adicionarTipoDeQuartoEmHotel("teste", new QuartoTipo(
                "Simplex",
                BigDecimal.valueOf(120),
                4
            )
        );
    }
}
