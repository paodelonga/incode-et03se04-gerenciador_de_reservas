package br.dev.paodelonga.gerenciador_de_reservas.Entidade;

import br.dev.paodelonga.gerenciador_de_reservas.Tipo.QuartoNome;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class Hotel {
    private String nome;
    private Integer quantidadeReservaMaxima;
    private LinkedList<Reserva> listaReservas;
    private LinkedList<Quarto> listaQuartos;
    private LinkedList<Hospede> listaHospedes;
    private LinkedList<Reserva> historicoReservas;
    private LinkedList<Hospede> historicoHospedes;
    private EnumMap<QuartoNome, Integer> tabelaQuartos;
    private EnumMap<QuartoNome, BigDecimal> tabelaValores;

    public Hotel(String nome, Integer quantidade_reserva_maxima) {
        this.nome = nome;
        this.quantidadeReservaMaxima = quantidade_reserva_maxima;

        this.listaReservas = new LinkedList<Reserva>();
        this.listaQuartos = new LinkedList<Quarto>();
        this.listaHospedes = new LinkedList<Hospede>();
        this.historicoReservas = new LinkedList<Reserva>();
        this.historicoHospedes = new LinkedList<Hospede>();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public Integer getQuantidadeReservaMaxima() {
        return quantidadeReservaMaxima;
    }

    public LinkedList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public LinkedList<Quarto> getListaQuartos() {
        return listaQuartos;
    }

    public LinkedList<Hospede> getListaHospedes() {
        return listaHospedes;
    }

    public LinkedList<Reserva> getHistoricoReservas() {
        return historicoReservas;
    }

    public LinkedList<Hospede> getHistoricoHospedes() {
        return historicoHospedes;
    }

    public EnumMap<QuartoNome, Integer> getTabelaQuartos() {
        return tabelaQuartos;
    }

    public EnumMap<QuartoNome, BigDecimal> getTabelaValores() {
        return tabelaValores;
    }

    // Setters
    public Hotel setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Hotel setQuantidadeReservaMaxima(Integer quantidade_reserva_maxima) {
        quantidadeReservaMaxima = quantidade_reserva_maxima;
        return this;
    }

    public Hotel setListaReservas(LinkedList<Reserva> lista_reservas) {
        listaReservas = lista_reservas;
        return this;
    }

    public Hotel setListaQuartos(LinkedList<Quarto> lista_quartos) {
        listaQuartos = lista_quartos;
        return this;
    }

    public Hotel setListaHospedes(LinkedList<Hospede> lista_hospedes) {
        listaHospedes = lista_hospedes;
        return this;
    }

    public Hotel setHistoricoReservas(LinkedList<Reserva> historico_reservas) {
        historicoReservas = historico_reservas;
        return this;
    }

    public Hotel setHistoricoHospedes(LinkedList<Hospede> historico_hospedes) {
        historicoHospedes = historico_hospedes;
        return this;
    }

    public Hotel setTabelaQuartos(EnumMap<QuartoNome, Integer> tabela_quartos) {
        tabelaQuartos = tabela_quartos;
        return this;
    }

    public Hotel setTabelaValores(EnumMap<QuartoNome, BigDecimal> tabela_valores) {
        tabelaValores = tabela_valores;
        return this;
    }

    // Adders
    public Reserva adicionaReserva(Reserva reserva) {
        if (listaReservas.size() < quantidadeReservaMaxima) {
            if (!(listaReservas.contains(reserva)) && historicoReservas.contains(reserva)) {
                historicoReservas.add(reserva);
                listaReservas.add(reserva);
                return listaReservas.get(listaReservas.indexOf(reserva));
            }
        }
        return null;
    }

    public Quarto adicionaQuarto(Quarto quarto) {
        if (listaQuartos.size() < quantidadeReservaMaxima) {
            if(!listaQuartos.contains(quarto)) {
                listaQuartos.add(quarto);
                return listaQuartos.get(listaQuartos.indexOf(quarto));
            }
        }
        return null;
    }

    public Hospede adicionaHospede(Hospede hospede) {
        if (listaHospedes.size() < quantidadeReservaMaxima) {
            if (!(listaHospedes.contains(hospede) && historicoHospedes.contains(hospede))) {
                historicoHospedes.add(hospede);
                listaHospedes.add(hospede);

                return listaHospedes.get(listaHospedes.indexOf(hospede));
            }
        }
        return null;
    }

    public Map<BigDecimal, Integer> adicionaQuartoTabela(QuartoNome nome, BigDecimal valor, Integer quantidade_inicial) {
        if(!(tabelaQuartos.containsKey(nome) && tabelaValores.containsKey(nome))) {
            Map<BigDecimal, Integer> adicionado = Map.of(
                tabelaValores.get(nome), tabelaQuartos.get(nome)
            );

            tabelaValores.put(nome, valor);
            tabelaQuartos.put(nome, quantidade_inicial);

            return adicionado;
        }
        return null;
    }

    // Obters
    public Reserva obterReserva(Reserva reserva) {
        return listaReservas.get(listaReservas.indexOf(reserva));
    }

    public Quarto obterQuarto(Quarto quarto) {
        return listaQuartos.get(listaQuartos.indexOf(quarto));
    }

    public Hospede obterHospede(Hospede hospede) {
        return listaHospedes.get(listaHospedes.indexOf(hospede));
    }

    public Map<BigDecimal, Integer> obterQuartoTabela(QuartoNome nome) {
        if(tabelaQuartos.containsKey(nome) && tabelaValores.containsKey(nome)) {
            return Map.of(tabelaValores.get(nome), tabelaQuartos.get(nome));
        }
        return null;
    }

    // Removers
    public Reserva removeReserva(Reserva reserva) {
        Reserva removida = listaReservas.get(listaReservas.indexOf(reserva));
        listaReservas.remove(removida);
        return removida;
    }

    public Quarto removeQuarto(Quarto quarto) {
        Quarto removido = listaQuartos.get(listaQuartos.indexOf(quarto));
        listaQuartos.remove(removido);
        return removido;
    }

    public Hospede removeHospede(Hospede hospede) {
        Hospede removido = listaHospedes.get(listaHospedes.indexOf(hospede));
        listaHospedes.remove(hospede);
        return removido;
    }

    public Map<BigDecimal, Integer> removeQuartoTabela(QuartoNome nome) {
        if (tabelaQuartos.containsKey(nome) && tabelaValores.containsKey(nome)) {
            Map<BigDecimal, Integer> removido = Map.of(
                tabelaValores.get(nome), tabelaQuartos.get(nome)
            );

            tabelaValores.remove(nome);
            tabelaQuartos.remove(nome);

            return removido;
        }
        return null;
    }

    // Internals
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Hotel other)) return false;
        return Objects.equals(nome, other.getNome());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }
}
