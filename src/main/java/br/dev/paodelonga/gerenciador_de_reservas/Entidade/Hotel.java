package br.dev.paodelonga.gerenciador_de_reservas.Entidade;

import br.dev.paodelonga.gerenciador_de_reservas.Tipo.QuartoTipo;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Objects;

public class Hotel {
    private String nome;
    private LocalDateTime dataCadastro;
    private LinkedList<QuartoTipo> tiposQuarto;

    public Hotel(String nome) {
        this.nome = nome;
        this.tiposQuarto = new LinkedList<>();
        this.dataCadastro = LocalDateTime.now();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LinkedList<QuartoTipo> getTiposQuarto() {
        return tiposQuarto;
    }

    public QuartoTipo getQuartoTipo(QuartoTipo quarto_tipo) {
        return (tiposQuarto.contains(quarto_tipo)) ? tiposQuarto.get(
            tiposQuarto.indexOf(quarto_tipo)
        ) : null;
    }

    // Setters
    public Hotel setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Hotel setDataCadastro(LocalDateTime data_cadastro) {
        dataCadastro = data_cadastro;
        return this;
    }

    public Hotel setTiposQuarto(LinkedList<QuartoTipo> tiposQuarto) {
        this.tiposQuarto = tiposQuarto;
        return this;
    }

    // Adders
    public QuartoTipo addQuartoTipo(QuartoTipo quarto_tipo) {
        if(!tiposQuarto.contains(quarto_tipo)) {
            tiposQuarto.add(quarto_tipo);
        }
        return tiposQuarto.get(tiposQuarto.indexOf(quarto_tipo));
    }

    // Removers
    public QuartoTipo removeQuartoTipo(QuartoTipo quarto_tipo) {
        return (tiposQuarto.contains(quarto_tipo)) ? tiposQuarto.remove(
            tiposQuarto.indexOf(quarto_tipo)
        ) : null;
    }

    // Internals
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Hotel other)) return false;
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
