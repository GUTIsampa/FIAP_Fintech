<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="pt-BR">
<head>
    <title>Página de Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }
        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .cadastro-message {
            margin-top: 10px;

        }

        h2 {
            text-align: center;
        }
        input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>

    <% if (request.getAttribute("Erro") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("Erro") %>
    </div>
    <% } %>


<<<<<<< HEAD
    <form action="loginServlet" method="post">
        <input type="email" placeholder="Email" name="email" id="email" required>
        <input type="password" placeholder="Senha" name="senha" id="senha" required>
        <button type="submit">Entrar</button>
=======
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
<a href="cadastros?acao=alterar">Alterar</a>
>>>>>>> parent of ad8fc6d (Update index.jsp)

        <% if (request.getAttribute("Cadastrar") != null) { %>
        <div class="cadastro-message">
            <%= request.getAttribute("Cadastrar") %>
        </div>
        <% } %>
    </form>
</div>
</body>
</html>