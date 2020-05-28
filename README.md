# ARSEENOW - Estoque de produtos

Sistema feito utilizando Java com auxílio da IDE NetBeans para criação de interface gráfica com Swing inspirado no sistema de cadastro de clinica psicológica feito previamente. Para rodar o sistema será necessário criar a base de dados a partir do dump que se encontra no projeto no seguinte caminho: “./test/persistência/SQL_SCRIPTS/dump.sql”. Ao criar a base de dados relacional com seu SGBD já é possível iniciar a aplicação.
Ao iniciar o sistema possui uma interface para login de administradores do estoque de produtos, cujo o usuário default é “ademir” e a senha é “123”.

### Figura 1 – Login

<p align="center">
  <img src="https://github.com/CDC-Anhanguera/ARSEENOW/blob/master/src/recursos/features/login.PNG">
</p>

Após Efetuar Login no sistema a janela principal (fmPrincipal) é chamada onde são listados todos os produtos cadastrados no banco de dados. Que por padrão viram alguns produtos de exemplo cadastrados caso tenha utilizado o dump.

### Figura 1 – Janela Principal: Listagem de produtos

<p align="center">
  <img src="https://github.com/CDC-Anhanguera/ARSEENOW/blob/master/src/recursos/features/listagem%20de%20produtos.PNG">
</p>

Dentro da Janela principal é possível fazer uma busca por nome de um produto onde a lista será atualizada com os produtos que contenham no nome os caracteres que foram digitados na busca.

### Figura 1 – Busca de produtos

<p align="center">
  <img src="https://github.com/CDC-Anhanguera/ARSEENOW/blob/master/src/recursos/features/busca%20de%20produtos.PNG">
</p>

Ao clicar com botão direto do mouse em algum produto é possível alterar ou excluir o produto selecionado.

### Figura 1 – Alterar e Excluir produtos.

<p align="center">
  <img src="https://github.com/CDC-Anhanguera/ARSEENOW/blob/master/src/recursos/features/editar-excluir.png">
</p>
 
É possível cadastrar novos produtos clicando no menu de cadastros e clicando em produtos ou apertando CTRL+P.

### Figura 1 – Cadastrar produtos.

<p align="center">
  <img src="https://github.com/CDC-Anhanguera/ARSEENOW/blob/master/src/recursos/features/cadastro-produtos.PNG">
</p>
