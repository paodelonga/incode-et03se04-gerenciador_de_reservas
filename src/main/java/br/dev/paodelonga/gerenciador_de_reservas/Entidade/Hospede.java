package br.dev.paodelonga.gerenciador_de_reservas.Entidade;

import java.util.Objects;

public class Hospede {
    private String nome;
    private String documento;
    private Integer idQuarto;
    private String idReserva;
    private String idHotel;

    public Hospede(Hotel hotel, String documento) {
        this.documento = documento;
        this.idHotel = hotel.getNome();
    }

    public Hospede(Hotel hotel, String nome, String documento) {
        this.nome = nome;
        this.documento = documento;

        this.idHotel = hotel.getNome();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public Hospede setDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    // Setters
    public Hospede setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Hospede setIdQuarto(Integer id_quarto) {
        idQuarto = id_quarto;
        return this;
    }

    public Hospede setIdReserva(String id_reserva) {
        idReserva = id_reserva;
        return this;
    }

    public Hospede setIdHotel(String id_hotel) {
        idHotel = id_hotel;
        return this;
    }

    // Internals
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Hospede other)) return false;
        return Objects.equals(idHotel, other.getIdHotel()) && Objects.equals(documento, other.getDocumento());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idHotel == null) ? 0 : idHotel.hashCode()) + ((documento == null) ? 0 : documento.hashCode());
        return result;
    }
}
