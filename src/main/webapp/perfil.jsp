<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/styleNav.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./resources/css/stylePerfil.css">
</head>
<body>
<%@include file="header_perfil.jsp"%>
    <div class="conteudo">
        <div class="profile-container">
            <h2 class="profile-title">Perfil de Usuário</h2>
            <div class="profile-info">
                <label>Email:</label>
                <p>${sessionScope.email}</p>
                
                <label>Data de Abertura da Conta:</label>
                <p><fmt:formatDate value="${sessionScope.dataCriacao}" pattern="dd/MM/yyyy" /> </p>
            </div>
            <div class="profile-actions">
                <form action="<c:url value='/perfil?acao=sairConta'/>" method="POST">
                    <input type="hidden" name="excluir" />
                    <button type="submit" class="delete-btn">
                        LogOut
                    </button>
                </form>
            </div>

        </div>
    </div>

    <script src="./resources/js/bootstrap.bundle.min.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="./resources/js/perfil.js" defer></script>
</body>
</html>
