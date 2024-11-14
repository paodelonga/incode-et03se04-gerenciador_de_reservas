package br.dev.paodelonga.gerenciador_de_reservas.Entidade;

import br.dev.paodelonga.gerenciador_de_reservas.Tipo.QuartoNome;

import java.util.Objects;

public class Quarto  {
    private Integer numero;
    private QuartoNome nome;
    private String idHospede;
    private Integer idReserva;

    public Quarto(Integer numero, QuartoNome nome) {
        this.numero = numero;
        this.nome = nome;
    }

    // Getters
    public Integer getNumero() {
        return numero;
    }

    public QuartoNome getNome() {
        return nome;
    }

    public String getIdHospede() {
        return idHospede;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    // Setters
    public Quarto setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public Quarto setNome(QuartoNome nome) {
        this.nome = nome;
        return this;
    }

    public Quarto setIdHospede(String id_hospede) {
        idHospede = id_hospede;
        return this;
    }

    public Quarto setIdReserva(Integer id_reserva) {
        idReserva = id_reserva;
        return this;
    }

    // Internals
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Quarto other)) return false;
        return Objects.equals(numero, other.getNumero());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }
}
