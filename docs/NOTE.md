

---

TRIPLO, SUPERIOR, LUXO, SUITE;

---

1. Acessar sistema
Pege dados do hotel
- nome
Libera acesso as operações

2. Cadastrar hotel
Pega dados do hotel
- nome
- quantidade e valores de quartos

---

1. Alugar quarto
Pega dados reserva
- Data Check-In
- Data Check-Out

Exibe quartos disponiveis
- exibe tipo, numero, valor

Escolha quarto
- numero, tipo, valor

Pega dados hospede
- Nome
- Documento

Pega confirmacao
Confirma
- quarto: numero, tipo
- reserva: identificador, checkin, checkout, valor
- hospede: tipo, documento

2. Consultar reserva
Pega dados reserva
- identificador

Exibe dados
- reserva: identificador, checkin, checkout, valor, estado
- quarto: numero, tipo
- hospede: tipo, documento

3. Cancelar reserva
Pega dados reserva
- identificador

Exibir dados
Exibe dados
- reserva: identificador, checkin, checkout, valor, estado
- quarto: numero, tipo
- hospede: tipo, documento

Pega confirmação
Confirma
- quarto: numero, tipo
- reserva: identificador, checkin, checkout, valor, estado
- hospede: tipo, documento

4. Pagar reserva
Pega dados reserva
- identificador

Exibir dados
Exibe dados
- reserva: identificador, checkin, checkout, valor, estado
- quarto: numero, tipo
- hospede: tipo, documento

Pega forma pagamento
- pix, cartao, boleto

Pega confirmação
Confirma
- quarto: numero, tipo
- reserva: identificador, checkin, checkout, valor, estado
- hospede: tipo, documento

5. Fazer Check-In
Pega dados reserva
- identificador

Exibir dados reserva
Exibe dados
- reserva: identificador, checkin, checkout, valor, estado
- quarto: numero, tipo
- hospede: tipo, documento

Pega confirmação
Confirma
- quarto: numero, tipo
- reserva: identificador, checkin, checkout, valor, estado
- hospede: tipo, documento

6. Fazer Check-Out
   Pega dados reserva
- identificador

Exibir dados reserva
Exibe dados
- reserva: identificador, checkin, checkout, valor, estado
- quarto: numero, tipo
- hospede: tipo, documento

Pega confirmação
Confirma
- quarto: numero, tipo
- reserva: identificador, checkin, checkout, valor, estado
- hospede: tipo, documento

7. Listar reservas
Exibe reservas
Exibe dados reserva
- reserva: identificador, checkin, checkout, valor, estado
- reserva: identificador, checkin, checkout, valor, estado
- hospede: tipo, documento

---

```
SISTEMA HOTELEIRO DE RESERVAS
Data atual: 2024/11/13, 19:30

[1] Acessar sistema
[2] Cadastrar hotel

[<] Digite o número da operação 
```

```
[1] Acessar sistema
// Exibe operações
```

```
[2] Cadastrar hotel

[<] Digite o nome do hotel 
[<] Insira uma senha de acesso 

Pegar o nome dos tipos de quartos daquele hotel
Ex: Simplex, Luxo, Duplex
e pra cada quarto passado pegar o valor e quantidade inicial dele

[>] Agora vamos criar a tabela de quartos
[>] Escreva a lista de quartos separando por virgula

[<] Lista de quartos (item,dois,tres quarto) 

[>] Agora vamos inserir os valores e quantidades para cada quarto
[>] Para ignorar o quarto preencha qualquer campo com 0

[item]
   [<] Insira o valor 
   [<] Insira a quantidade inicial   

[dois]
   [<] Insira o valor 
   [<] Insira a quantidade inicial   

[tres quarto]
   [<] Insira o valor 
   [<] Insira a quantidade inicial   

[>] Hotel "Nome" cadastrado com sucesso.
```

---

```
         Hotel Lumen
Data atual: 2024/11/13 - 19:30

SISTEMA HOTELEIRO DE RESERVAS
[1] Alugar quarto
[2] Consultar reserva
[3] Cancelar reserva
[4] Pagar reserva
[5] Fazer CheckIn
[6] Fazer CheckOut
[7] Listar reservas

[<] Digite o número da operação 
```

```
[1] Alugar quarto

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

```

```
[2] Consultar reserva
```

```
[3] Cancelar reserva
```

```
[4] Pagar reserva
```

```
[5] Fazer CheckIn
```

```
[6] Fazer CheckOut
```

```
[7] Listar reservas
```

---



