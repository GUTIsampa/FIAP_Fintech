<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
</head>
<body>
<h2>Formulário de Cadastro</h2>
<form action="cadastros?acao=cadastrar" method="POST">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required><br><br>

    <label for="email">E-mail:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha" required><br><br>

    <label for="dataNascimento">Data de Nascimento:</label>
    <input type="date" id="dataNascimento" name="dataNascimento" required><br><br>

    <input type="submit" value="Cadastrar">
</form>
<br/><br/>
<a href="cadastros?acao=listar"> listar</a>
<br/><br/>
<h1>Formulário de busca</h1>
<form action="cadastros?acao=buscaPorId" method="post">
    <label for="id">ID:</label>
    <input type="text" id="idBusca" name="id" required>
    <br><br>
    <input type="submit" value="Enviar">
</form>
<br/><br/>
<h1>Formulário de excluir</h1>
<form action="cadastros?acao=excluirPorId" method="post">
    <label for="id">ID:</label>
    <input type="text" id="idExcluir" name="id" required>
    <br><br>
    <input type="submit" value="Enviar">
</form>
<a href="cadastros?acao=alterar">Alteraar</a>

</body>
</html>
