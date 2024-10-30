<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fintech</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/styleFintech.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body class="corpo">
<div>
    <div class="d-flex justify-content-end ajuda">
        <a href="tel:XXXX-XXXX-XXXX" class="titulo sac1">
            <i class="fa-solid fa-headphones"></i> SAC
        </a>
    </div>
</div>

<div class="container text-center bv">
    <h2 class="titulo bemvindo">Bem Vindo ao</h2>
    <img class="logofin img-fluid" src="./resources/images/Logo.png" alt="Logo Fintech">
    <h2 class="titulo bemvindo">Fintech</h2>
</div>

<div class="container mt-1">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card login">
                <div class="card-body">
                    <h5 class="card-title text-center titulo">Login</h5>

                    <!-- Exibir mensagem de erro, se houver -->
                    <c:if test="${not empty erro}">
                        <div class="alert alert-danger text-center" role="alert">
                                ${erro}
                        </div>
                    </c:if>

                    <form action="<c:url value='/loginServlet'/>" method="post">
                        <div class="form-group">
                            <label for="email" class="inserir titulo"> <i class="fa-solid fa-user"></i> Email</label>
                            <input type="text" class="form-control caixa" id="email" name="email" placeholder="Digite seu email" required>
                        </div>
                        <div class="form-group">
                            <label for="senha" class="inserir titulo"> <i class="fa-solid fa-lock icones2"></i> Senha</label>
                            <input type="password" class="form-control caixa2" id="senha" name="senha" placeholder="Digite sua senha" required>
                        </div>
                        <div class="text-center divbotao1">
                            <button type="submit" class="btn btn-block botao"> <i class="fa-solid fa-right-to-bracket"></i> Entrar</button>
                        </div>
                        <div class="text-center divbotao">
                            <h6 class="ainda">Ainda não tem conta?</h6>
                        </div>
                        <!--Exibir mensagem de cadastro, se houver-->
                        <c:if test="${not empty cadastrar}">
                            <div class="alert alert-info text-center" role="alert">
                                    ${cadastrar}
                            </div>
                        </c:if>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<div class="d-flex justify-content-end redes">
    <a href="<c:url value='https://instagram.com'/>" class="titulo sac1 icones3">
        <i class="fa-brands fa-square-instagram fa-lg"></i>
    </a>
    <a href="<c:url value='https://facebook.com'/>" class="titulo sac1 icones3">
        <i class="fa-brands fa-square-facebook fa-lg"></i>
    </a>
    <a href="<c:url value='https://twitter.com'/>" class="titulo sac1 icones3">
        <i class="fa-brands fa-square-x-twitter fa-lg"></i>
    </a>
</div>
</body>
</html>