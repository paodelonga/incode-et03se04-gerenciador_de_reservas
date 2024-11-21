package br.dev.paodelonga.gerenciador_de_reservas.Aplicacao;

import br.dev.paodelonga.gerenciador_de_reservas.Entidade.Hotel;
import br.dev.paodelonga.gerenciador_de_reservas.Servico.Servico;
import br.dev.paodelonga.gerenciador_de_reservas.Tipo.QuartoTipo;
import br.dev.paodelonga.gerenciador_de_reservas.Utilidade.Leitura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        /*
        [<] Insira a data de Check-In (1970/12/01)
        [<] Insira a data de Check-Out (1970/12/01)

        [>] Estes são os quartos disponiveis para este periodo

        [>] [1]
        [>] Nome: Simplex
        [>] Valor: R$ 512.00

        [>] [2]
        [>] Nome: Luxuous
        [>] Valor: R$ 512.00

        [>] [3]
        [>] Nome: Duplex
        [>] Valor: R$ 512.00
        */

        while (true) {
            try {
                LocalDate dataCheckIn = LocalDate.parse(
                    Leitura.lerString("[<] Insira a data de Check-In (1970/12/31)"),
                    DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido\n");
            }
        }


        while (true) {
            try {
                LocalDate dataCheckOut = LocalDate.parse(
                    Leitura.lerString("[<] Insira a data de Check-Out (1970/12/31)"),
                    DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido\n");
            }
        }
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

        if (servico.obterListaDeHosteis().isEmpty()) {
            System.out.println("[!] Não hoteis cadastrados no sistema.");
            return;
        }

        String nome_hotel = Leitura.lerString("[<] Digite o nome do hotel: ");

        if (servico.obterHotelPorNome(nome_hotel) == null) {
            System.out.println("[!] Hotel não cadastrado.");
            return;
        }

        exibirOperacoesPrincipais(nome_hotel);
        while (true) {
            switch (Leitura.lerInteiro("[<] Digite o número da operação: ")) {
                case 1:
                    alugarQuarto(nome_hotel);
                    break;
                case 2:
                    consultarReserva(nome_hotel);
                    break;
                case 3:
                    cancelarReserva(nome_hotel);
                    break;
                case 4:
                    pagarReserva(nome_hotel);
                    break;
                case 5:
                    fazerCheckin(nome_hotel);
                    break;
                case 6:
                    fazerCheckout(nome_hotel);
                    break;
                case 7:
                    listarReservas(nome_hotel);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("[!] Uma operação inexistente foi selecionada.\n");
            }
        }
    }

    private void cadastrarHotel() {
        String nome_hotel;

        exibirSeparador();

        while (true) {
            nome_hotel = Leitura.lerString("[<] Digite o nome do hotel: ");

            if (servico.obterHotelPorNome(nome_hotel) == null) {
                servico.adicionarHotel(new Hotel(nome_hotel));
                break;
            } else {
                System.out.printf("[!] Um hotel de nome %s já existe%n%n", nome_hotel);
            }
        }
        exibirEspacamento();
        System.out.println("""
            [>] Agora vamos criar a tabela de quartos
            [>] Escreva a lista de quartos separando por virgula
            """
        );

        String[] lista_de_quartos = Leitura.lerString(
            "[<] Lista de quartos (item, dois, tres quarto): "
        ).split(", ");

        System.out.println("""
            [>] Agora vamos inserir os valores e quantidades para cada quarto.
            [>] Para ignorar o quarto preencha qualquer campo com 0
            """
        );

        for (String nome_quarto : lista_de_quartos) {
            System.out.printf("[%s]%n", nome_quarto);
            BigDecimal entrada_valor = BigDecimal.valueOf(Leitura.lerFloat("[<] Valor: "));
            Integer entrada_quantidade = Leitura.lerInteiro("[<] Quantidade: ");

            if (!(entrada_valor.equals(BigDecimal.ZERO) || entrada_quantidade.equals(0))) {
                servico.adicionarTipoDeQuartoEmHotel(
                    nome_hotel,
                    new QuartoTipo(
                        nome_quarto,
                        entrada_valor,
                        entrada_quantidade
                    )
                );
            }
            exibirEspacamento();
        }

        if (servico.obterListaDeTiposDeQuartoEmHotel(nome_hotel).isEmpty()) {
            System.out.printf("[!] Falha ao cadastrar o hotel %s%n", nome_hotel);
            System.out.println("[!] Nenhum quarto foi adicionado ao hotel.\n");
        } else {
            System.out.printf("[>] Hotel %s cadastrado com sucesso.%n", nome_hotel);
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
