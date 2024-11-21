package br.dev.paodelonga.gerenciador_de_reservas.Entidade;

import br.dev.paodelonga.gerenciador_de_reservas.Tipo.ReservaEstado;

import java.math.BigDecimal;
import java.util.Objects;

public class Reserva {
    private String identificador;
    private Quarto quarto;
    private Hospede hospede;
    private BigDecimal valor;
    private ReservaEstado estadoReserva;
    private String idHotel;

    public Reserva(Hotel hotel, String identificador) {
        this.identificador = identificador;
        this.idHotel = hotel.getNome();
    }

    public Reserva(Hotel hotel, String identificador, Quarto quarto, Hospede hospede) {
        this.identificador = identificador;
        this.quarto = quarto;
        this.hospede = hospede;

        this.idHotel = hotel.getNome();

        this.quarto.setIdHospede(this.hospede.getDocumento());
        this.quarto.setIdReserva(this.identificador);

        this.hospede.setIdQuarto(this.quarto.getNumero());
        this.hospede.setIdReserva(this.identificador);

        this.estadoReserva = ReservaEstado.ESPERA;
    }

    // Getters
    public String getIdentificador() {
        return identificador;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public ReservaEstado getEstadoReserva() {
        return estadoReserva;
    }

    public String getIdHotel() {
        return idHotel;
    }

    // Setters
    public Reserva setIdentificador(String identificador) {
        this.identificador = identificador;
        return this;
    }

    public Reserva setQuarto(Quarto quarto) {
        this.quarto = quarto;
        return this;
    }

    public Reserva setHospede(Hospede hospede) {
        this.hospede = hospede;
        return this;
    }

    public Reserva setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Reserva setEstadoReserva(ReservaEstado estado_reserva) {
        estadoReserva = estado_reserva;
        return this;
    }

    public Reserva setIdHotel(String id_hotel) {
        idHotel = id_hotel;
        return this;
    }

    // Internals
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Reserva other)) return false;
        return Objects.equals(idHotel, other.getIdHotel()) && Objects.equals(identificador, other.getIdentificador());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idHotel == null) ? 0 : idHotel.hashCode()) + ((identificador == null) ? 0 : identificador.hashCode());
        return result;
    }
}
