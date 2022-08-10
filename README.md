# Back Budget

## O que é?
Back Budget é uma aplicação para controle de orçamento familiar. 
A aplicação permite que uma pessoa cadastre suas receitas e despesas do mês, bem como gerar um relatório mensal.

## DOD
- API com rotas implementadas seguindo as boas práticas do modelo REST;
- Validações feitas conforme as regras de negócio;
- Implementação de base de dados para persistência das informações;
- Serviço de autenticação/autorização para restringir acesso às informações.

## Tecnologias
- Kotlin + Spring Boot;
- MongoDB.

## Funcionalidades
#### RECURSO 1 - Receita (Income)
- Cadastro de receita       (   POST       - "/income"          )
- Listagem de receita       (   GET        - "/incomes"         )
- Detalhamento de receita   (   GET        - "/incomes/{id}"    )
- Atualização de receita    (   PUT/PATCH  - TBD                )
- Exclusão de receita       (   DELETE     - TBD                )

#### RECURSO 2 - Despesa (Expense)
- Cadastro de despesa       (   POST       - "/expense"         )
- Listagem de despesas      (   GET        - "/expenses"        )
- Detalhamento de despesa   (   GET        - "/expenses/{id}"   )
- Atualização de despesa    (   PUT/PATCH  - TBD                )
- Exclusão de despesa       (   DELETE     - TBD                )

## Desenho de solução
- TBD