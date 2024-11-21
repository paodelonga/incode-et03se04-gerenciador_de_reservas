package br.dev.paodelonga.gerenciador_de_reservas.Tipo;

import java.math.BigDecimal;
import java.util.Objects;

public class QuartoTipo {
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;

    public QuartoTipo(String nome) {
        this.nome = nome;
    }

    public QuartoTipo(String nome, BigDecimal valor, Integer quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public QuartoTipo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public QuartoTipo setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public QuartoTipo setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    // Internals
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof QuartoTipo other)) return false;
        return Objects.equals(nome.toLowerCase(), other.getNome().toLowerCase());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + nome.toLowerCase().hashCode();
        return result;
    }

}
