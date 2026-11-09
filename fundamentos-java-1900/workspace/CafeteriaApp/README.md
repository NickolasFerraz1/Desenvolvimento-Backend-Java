# CafeteriaApp ☕

Sistema de pedidos de uma cafeteria, executado no terminal. Foi desenvolvido durante as aulas de **Fundamentos de Desenvolvimento Java** (Infnet), acompanhando o código do professor.

## Funcionalidades

- **Novo pedido**: informa o nome do cliente, escolhe produtos pelo código e define a quantidade de cada um. Termina com `0`.
- **Exibir cardápio**
- **Resumo de vendas**: total de pedidos, quantidade vendida de cada produto e valor total vendido.
- **Sobre o sistema**: versão do Java, sistema operacional e diretório atual.

### Cardápio

| Código | Produto       | Preço    |
|:------:|---------------|---------:|
| 1      | Café          | R$ 5,00  |
| 2      | Cappuccino    | R$ 8,00  |
| 3      | Pão de queijo | R$ 6,00  |
| 4      | Sanduíche     | R$ 12,00 |

## Conceitos praticados

- Entrada de dados com `Scanner`
- Estruturas de repetição (`do/while`, `while`)
- `switch/case` para menu e para seleção de produtos
- Validação de entrada (código de produto e quantidade)
- Acumuladores e contadores (totais por produto, total de pedidos e de vendas)
- Métodos estáticos para organizar o código (`exibirMenu`, `exibirCardapio`, `obterQuantidade`)

## Estrutura

```
CafeteriaApp/
├── src/br/edu/infnet/app/Cafeteria.java   # código-fonte
├── bin/                                   # classes compiladas
└── README.md
```

## Como executar

Requer o **JDK** instalado (`java -version` para conferir). A partir da pasta `CafeteriaApp`:

```bash
javac -d bin src/br/edu/infnet/app/Cafeteria.java
java -cp bin br.edu.infnet.app.Cafeteria
```

Também é possível executar direto pelo VS Code, com a extensão *Extension Pack for Java*.

## Observação

Este é o meu workspace pessoal, feito junto com o professor durante a aula. O repositório dele fica separado, como gabarito. Prefiro acompanhar escrevendo o código a copiar a versão pronta.
