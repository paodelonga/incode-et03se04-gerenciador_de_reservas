package br.dev.paodelonga.gerenciador_de_reservas.Aplicacao;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hospede;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hotel;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Quarto;
import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Reserva;
import br.dev.paodelonga.gerenciador_de_reservas.Servico.Servico;
import br.dev.paodelonga.gerenciador_de_reservas.Tipo.QuartoTipo;
import br.dev.paodelonga.gerenciador_de_reservas.Utilidade.Leitura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class Menu {
    private Servico servico;

    public Menu(Servico servico) {
        this.servico = servico;
        iniciar();
    }

    private void exibirSeparador() {
        System.out.print("\n");
        for (byte x = 0; x < 50; x++) {
            System.out.print("=");
        }
        System.out.println("\n");
    }

    private void exibirEspacamento() {
        System.out.println("");
    }

    private void alugarQuarto(String nome_hotel) {
        LocalDate dataCheckIn;
        LocalDate dataCheckOut;
        QuartoTipo quartoTipo;
        int numeroQuarto;


        while (true) {
            try {
                dataCheckIn = LocalDate.parse(
                    Leitura.lerString("[<] Insira a data de Check-In (1970/12/31): "),
                    DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("[!] Data em formato invalido\n");
            }
        }

        while (true) {
            try {
                dataCheckOut = LocalDate.parse(
                    Leitura.lerString("[<] Insira a data de Check-Out (1970/12/31): "),
                    DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("[!] Data em formato invalido\n");
            }
        }
        exibirEspacamento();

        System.out.println("[>] Estes são os quartos disponíveis para este período.");

        List<QuartoTipo> listaQuartosDisponiveis = servico.obterQuartosDisponiveisEmHotel(nome_hotel);
        listaQuartosDisponiveis.forEach(
            quarto -> {
                System.out.printf("[%s] Nome: %s | Valor: R$ %.2f%n",
                    listaQuartosDisponiveis.indexOf(quarto),
                    quarto.getNome(),
                    quarto.getValor()
                );
            }
        );

        exibirEspacamento();

        while (true) {
            numeroQuarto = Leitura.lerInteiro("[<] Escolha o quarto pelo número: ");

            if (servico.obterQuartosDisponiveisEmHotel(nome_hotel).get(numeroQuarto) != null) {
                quartoTipo = servico.obterQuartosDisponiveisEmHotel(nome_hotel).get(numeroQuarto);
                break;
            }

            System.out.println("[!] O número escolhido não existe");
        }

        String nomeHospede = Leitura.lerString("[<] Insira o nome do hospede");
        String documentoHospede = Leitura.lerString("[<] Insira o documento do hospede (CPF/CNPJ)");

        Quarto quartoReserva = new Quarto(
            servico.obterHotelPorNome(nome_hotel),
            (
                servico.obterTipoDeQuartoEmHotel(
                        nome_hotel,
                        quartoTipo
                    )
                    .getQuantidade() - 1
            ),
            nomeQuarto
        );

        Hospede hospedeReserva = new Hospede(
            servico.obterHotelPorNome(nome_hotel),
            nomeHospede,
            documentoHospede
        );

        Reserva reserva = new Reserva(
            servico.obterHotelPorNome(nome_hotel),
            UUID.randomUUID().toString().split("-")[1],
            quartoReserva, hospedeReserva
        );

        System.out.printf("""
                [>] [Reserva]
                [>] Identificador: %s
                [>] Data CheckIn: %s
                [>] Data CheckOut: %s
                
                [>] [Quarto]
                [>] Nome: %s
                [>] Valor: %s
                
                [>] [Hospede]
                [>] Nome: %s
                [>] Documento: %s
                """,
            reserva.getIdentificador(), dataCheckIn, dataCheckOut,
            quartoReserva.getTipo(),
            servico.obterTipoDeQuartoPorNomeEmHotel(
                nome_hotel,
                nomeQuarto
            ).getValor(),
            hospedeReserva.getNome(), hospedeReserva.getDocumento()
        );

    }

    private void consultarReserva(String nome_hotel) {
    }

    private void cancelarReserva(String nome_hotel) {
    }

    private void pagarReserva(String nome_hotel) {
    }

    private void fazerCheckin(String nome_hotel) {
    }

    private void fazerCheckout(String nome_hotel) {
    }

    private void listarReservas(String nome_hotel) {
    }

    private void exibirOperacoesPrincipais(String nome_hotel) {
        exibirSeparador();

        System.out.printf("""
                SISTEMA HOTELEIRO DE RESERVAS
                Autenticado como: %s
                Data atual: %s
                
                SISTEMA HOTELEIRO DE RESERVAS
                [1] Alugar quarto
                [2] Consultar reserva
                [3] Cancelar reserva
                [4] Pagar reserva
                [5] Fazer CheckIn
                [6] Fazer CheckOut
                [7] Listar reservas
                [8] Desconectar%n
                """,
            servico.obterHotelPorNome(nome_hotel).getNome(),
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm"))
        );
    }

    private void exibirOperacoesIniciais() {
        exibirSeparador();

        System.out.printf("""
                SISTEMA HOTELEIRO DE RESERVAS
                Data atual: %s
                
                [1] Acessar sistema
                [2] Cadastrar hotel
                [3] Sair%n
                """,
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd, HH:mm"))
        );
    }

    private void acessarSistema() {
        exibirSeparador();

        String nomeHotel;

        if (servico.obterListaDeHosteis().isEmpty()) {
            System.out.println("[!] Não hoteis cadastrados no sistema.");
            return;
        }

        System.out.println("[0] Voltar\n");
        while (true) {
            nomeHotel = Leitura.lerString("[<] Digite o nome do hotel: ");

            if (nomeHotel.equals("0")) {
                return;
            }

            if (servico.obterHotelPorNome(nomeHotel) != null) {
                break;
            }

            System.out.println("[!] Hotel não cadastrado.\n");
        }

        exibirOperacoesPrincipais(nomeHotel);
        while (true) {
            switch (Leitura.lerInteiro("[<] Digite o número da operação: ")) {
                case 1:
                    alugarQuarto(nomeHotel);
                    break;
                case 2:
                    consultarReserva(nomeHotel);
                    break;
                case 3:
                    cancelarReserva(nomeHotel);
                    break;
                case 4:
                    pagarReserva(nomeHotel);
                    break;
                case 5:
                    fazerCheckin(nomeHotel);
                    break;
                case 6:
                    fazerCheckout(nomeHotel);
                    break;
                case 7:
                    listarReservas(nomeHotel);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("[!] Uma operação inexistente foi selecionada.\n");
            }
        }
    }

    private void cadastrarHotel() {
        exibirSeparador();

        String nomeHotel;
        List<String> listaQuartos;
        Hotel hotel;

        System.out.println("[0] Voltar\n");
        while (true) {
            nomeHotel = Leitura.lerString("[<] Digite o nome do hotel: ");

            if (nomeHotel.equals("0")) {
                return;
            }

            if (servico.obterHotelPorNome(nomeHotel) == null) {
                hotel = new Hotel(nomeHotel);
                break;
            }

            System.out.println("[!] Um hotel com o mesmo já foi cadastrado.\n");
        }

        exibirEspacamento();

        System.out.println("""
            [>] Agora vamos criar a tabela de quartos
            [>] Escreva a lista de quartos separadamente por virgula.
            """
        );

        listaQuartos = Arrays.asList(
            Leitura.lerString(
                    "[<] Lista de quartos (Ex: Simplex, Duplo, Luxo Casal): "
                )
                .split("\\s*,\\s*")
        );


        System.out.println("[>] Agora vamos inserir os valores e quantidades de cada quarto.\n");

        for (String nome_quarto : listaQuartos) {
            System.out.printf("[%s]%n", nome_quarto);
            BigDecimal entradaValor = BigDecimal.valueOf(Leitura.lerFloat("[<] Valor: "));
            int entradaQuantidade = Leitura.lerInteiro("[<] Quantidade: ");

            if (!(entradaValor.intValue() == 0 || entradaQuantidade == 0)) {
                hotel.addQuartoTipo(
                    new QuartoTipo(
                        nome_quarto,
                        entradaValor,
                        entradaQuantidade
                    )
                );
            }
            exibirEspacamento();
        }

        if (hotel.getTiposQuarto().isEmpty()) {
            System.out.printf("[!] Falha ao cadastrar o hotel %s%n", nomeHotel);
            System.out.println("[!] Nenhum quarto foi adicionado ao hotel.");
        } else {
            servico.cadastrarHotel(hotel);
            System.out.printf("[>] Hotel %s cadastrado com sucesso.%n", nomeHotel);
        }
    }

    public void iniciar() {
        exibirOperacoesIniciais();
        while (true) {
            switch (Leitura.lerInteiro("[<] Digite o número da operação: ")) {
                case 1:
                    acessarSistema();
                    exibirOperacoesIniciais();
                    break;
                case 2:
                    cadastrarHotel();
                    exibirOperacoesIniciais();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("[!] Uma operação inexistente foi selecionada.\n");
                    break;
            }
        }
    }
}
