package br.dev.paodelonga.gerenciador_de_reservas.Entidade;

import java.util.Objects;

public class Quarto  {
    private Integer numero;
    private String tipo;
    private String idHospede;
    private String idReserva;
    private String idHotel;

    public Quarto(Hotel hotel, Integer numero) {
        this.numero = numero;
        this.idHotel = hotel.getNome();
    }

    public Quarto(Hotel hotel, Integer numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;

        this.idHotel = hotel.getNome();
    }

    // Getters
    public Integer getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getIdHospede() {
        return idHospede;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public String getIdHotel() {
        return idHotel;
    }

    // Setters
    public Quarto setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public Quarto setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public Quarto setIdHospede(String id_hospede) {
        idHospede = id_hospede;
        return this;
    }

    public Quarto setIdReserva(String id_reserva) {
        idReserva = id_reserva;
        return this;
    }

    public Quarto setIdHotel(String id_hotel) {
        idHotel = id_hotel;
        return this;
    }

    // Internals
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Quarto other)) return false;
        return Objects.equals(idHotel, other.getIdHotel()) && Objects.equals(numero, other.getNumero());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idHotel == null) ? 0 : idHotel.hashCode()) + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }
}
