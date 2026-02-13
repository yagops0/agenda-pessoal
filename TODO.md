# AGENDA PESSOAL
Este projeto serve para aprofundar estudos na linguagem Java. Ele estará em crescimento para cada tópico que eu for estudando na linguagem Java o conceito estudado será implementado no projeto até que ele se torne uma API para uso.
O projeto será uma agenda pessoal para marcar objetivos do dia como por exemplo: Ler o livro, Estudar 1 hora, Correr, etc.
### Como ele será feito?
De começo haverá apenas um menu interativo básico para o CRUD das tarefas/objetivos do dia


## FASE 1 - SINTAXE BÁSICA E CONTROLE DE FLUXO
Este fase será a implementação básica do projeto, no momento sem classes
### O que fazer?
- [x] Uma lista para armazenar as tarefas
- [x] CRUD simples de tarefas
- [x] Um menu interativo utilizando loops e estrutura condicionais
- [x] Utilizar tratamento de erros básico para caso haja um input inválido ou coisa do tipo

## FASE 2 - POO APLICADA CORRETAMENTE

Essa fase será implementação do paradigma de POO para uma melhor legibilidade do código e desacoplamento de código da classe Main
### O que fazer?
- [ ] Criar classe tarefa
- [ ] Separar as responsabilidades por pacotes
  - [ ] entities - será o pacote responsável pela camada de modelo
  - [ ] service - o pacote para as regras de negócios
  - [ ] ui/view - será onde os menus serão criados
- [ ] Encapsulamento

### Regras de negócios
- Tarefas não podem ser salvas/atualizadas estando com descrição
- O usuário precisa confirmar que deseja deletar ou atualizar uma tarefa