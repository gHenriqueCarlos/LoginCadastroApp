## MAPA Programação II - Unicesumar 

Projeto para completar a atividade MAPA da máteria Programação II da Universidade Unicesumar, cursando Análise e Desenvolvimento de Sistemas.

## Questão completa

Caro estudante!

Temos por certo que os desafios sempre contribuem na aquisição de conhecimentos e competências desejadas. Sendo assim, faz-se necessário relacionar o que se aprende com situações reais que podem ser encontradas no cotidiano.

Nesta atividade, você é convidado a realizar uma atividade para verificar como a disciplina em questão pode contribuir na sua experiência e formação profissional. Por este motivo, nesta atividade MAPA, você é instigado a solucionar um problema voltado para sua área de formação.

Atente-se para as informações e realize um ótimo trabalho!

Você como desenvolvedor FullStack em uma empresa, foi designado a criar um sistema de login utilizando a linguagem Java. Este sistema deve contar com uma tela de login e senha com botão entrar, entretanto deve existir também uma opção de "Cadastrar Novo Usuário" para os casos em que um usuário novo esteja acessando o sistema.

Este sistema deve possuir a tela usando Java SWING e conexão com banco de dados de sua preferência usando JDBC como tipo de conexão.

Exemplo da Tela de Login
![image](https://github.com/gHenriqueCarlos/LoginCadastroApp/assets/45677964/3fe031f5-cbe7-4f9b-88ac-e2b6f91948fa)

Exemplo da Tela de Cadastrar Novo Usuário
![image](https://github.com/gHenriqueCarlos/LoginCadastroApp/assets/45677964/2323bd9d-9be8-45df-b683-5b2a2858244e)

O programa inicia na tela de login, e o botão redireciona para a tela de cadastro

Requisitos da tela:
Tela de Login: 

    - Ao inserir o login deve executar o seguinte comando no banco:
        SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?
    - Se não retornar nada, quer dizer que o usuário e senha são inválidos e então mostre uma mensagem de "Acesso Negado" na tela.
    - Caso retorne, mostre na tela "Acesso Autorizado"
    
Cadatrar Novo Usuário:
    - Inserir os campos de usuário no banco de dados
    - Pode usar o SQL 
        insert into usuario(nome, login, senha, email) values (?,?,?,?)
    - Ao inserir, mostre uma mensagem "Cadastro efetuado com sucesso" e feche a tela.
    
Use o banco MySQL para a atividade, segue o script para montar a base e a tabela necessária.

CREATE SCHEMA `mapa` ;

CREATE TABLE `mapa`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
