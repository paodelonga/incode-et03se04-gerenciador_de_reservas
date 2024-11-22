---

1. Acessar sistema
Pege dados do hotel
- nome
Libera acesso as operações
Exibe operações

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
- exibe tipo, valor

Escolha quarto
- escolha por nome

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
[3] Sair

[<] Digite o número da operação: 
```

```
[1] Acessar sistema
[>] Digite o nome do hotel: 
```

```
[2] Cadastrar hotel
[<] Digite o nome do hotel: 

[>] Agora vamos criar a tabela de quartos.
[>] Escreva a lista de quartos separados por virgula.

[<] Lista de quartos (Ex: Simplex, Duplo, Luxo Casal):  

[>] Agora vamos inserir os valores e quantidades de cada quarto.

[Quarto: Simplex]
   [<] Insira o valor: 
   [<] Insira a quantidade inicial:    

[Quarto: Duplo]
   [<] Insira o valor: 
   [<] Insira a quantidade inicial:    

[Quarto: Luxo Casal]
   [<] Insira o valor: 
   [<] Insira a quantidade inicial:    

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

[<] Digite o número da operação: 
```

```
[1] Alugar quarto
[<] Insira a data de Check-In (1970/12/31): 
[<] Insira a data de Check-Out (1970/12/31):

[>] Estes são os quartos disponiveis para este periodo
[1] Nome: Simplex | Valor: R$ 512.00
[2] Nome: Duplo | Valor: R$ 512.00
[3] Nome: Luxo Casal | Valor: R$ 512.00

[<] Escolha o quarto pelo número: 
[<] Insira o nome do hospede: 
[<] Insira o CPF do hospede:

[>] Confirmando dados da reserva
   [Reserva]
   Token: abc123
   Valor: R$ 1024.00
   Check-In: 1970/12/31
   Check-Out: 1970/12/31
   
   [Hospede]
   Nome: João Silva
   Documento: 12345678901
   
   [Quarto]
   Nome: Simplex
   Numero: 123

[<] Deseja confirmar a reserva? (S/N): 
[>] Reserva confirmada com sucesso.
```

```
[2] Consultar reserva
[<] Insira o token da reserva: 
[>] Detalhes da reserva abc123:
   [Reserva]
   Token: abc123
   Valor: R$ 1024.00
   Check-In: 1970/12/31
   Check-Out: 1970/12/31
   Estado: Andamento
   
   [Hospede]
   Nome: João Silva
   Documento: 12345678901
   
   [Quarto]
   Nome: Simplex
   Numero: 123
```

```
[3] Cancelar reserva
[<] Insira o token da reserva: 
[>] Detalhes da reserva abc123:
   [Reserva]
   Token: abc123
   Valor: R$ 1024.00
   Check-In: 1970/12/31
   Check-Out: 1970/12/31
   Estado: Andamento
   
   [Hospede]
   Nome: João Silva
   Documento: 12345678901
   
   [Quarto]
   Nome: Simplex
   Numero: 123

[<] Confirmar o cancelamento? (S/N): 
[>] Reserva cancelada com sucesso.
```

```
[4] Pagar reserva
[<] Insira o token da reserva: 
[>] Detalhes da reserva abc123:
   [Reserva]
   Token: abc123
   Valor: R$ 1024.00
   Check-In: 1970/12/31
   Check-Out: 1970/12/31
   Estado: Andamento
   
   [Hospede]
   Nome: João Silva
   Documento: 12345678901
   
   [Quarto]
   Nome: Simplex
   Numero: 123

[<] Confirmar o pagamento? (S/N): 
[>] Reserva paga com sucesso.
```

```
[5] Fazer CheckIn
[<] Insira o token da reserva: 
[>] Detalhes da reserva abc123:
   [Reserva]
   Token: abc123
   Valor: R$ 1024.00
   Check-In: 1970/12/31
   Check-Out: 1970/12/31
   Estado: Andamento
   
   [Hospede]
   Nome: João Silva
   Documento: 12345678901
   
   [Quarto]
   Nome: Simplex
   Numero: 123

[<] Confirmar o Check-In? (S/N): 
[>] Check-In realizado com sucesso.
```

```
[6] Fazer CheckOut
[<] Insira o token da reserva: 
[>] Detalhes da reserva abc123:
   [Reserva]
   Token: abc123
   Valor: R$ 1024.00
   Check-In: 1970/12/31
   Check-Out: 1970/12/31
   Estado: Andamento
   
   [Hospede]
   Nome: João Silva
   Documento: 12345678901
   
   [Quarto]
   Nome: Simplex
   Numero: 123

[<] Confirmar o Check-Out? (S/N): 
[>] Check-Out realizado com sucesso.
```

```
[7] Listar reservas
[1]
   Token: abc123
   Valor: R$ 1024.00
   Check-In: 1970/12/31
   Check-Out: 1970/12/31
   Estado: Andamento

[2]
   Token: abc123
   Valor: R$ 1024.00
   Check-In: 1970/12/31
   Check-Out: 1970/12/31
   Estado: Andamento
```

---



