<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Investimentos</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/styleInvestimentos.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./resources/css/styleNav.css">
</head>

<body>
<%@include file="header_investimento.jsp"%>
    <div class="conteudo">
        <div class="simulador-container">
            <h2>Simulador Fintech de Investimentos</h2>
            <form id="simulador-form">
                <label for="investimento">Investimento Inicial (R$)</label>
                <input type="number" id="investimento" placeholder="Ex: 1000" required>

                <label for="taxa-juros">Taxa de Juros (% ao mês)</label>
                <input type="number" id="taxa-juros" placeholder="Ex: 1.5" required>

                <label for="periodo">Período (meses)</label>
                <input type="number" id="periodo" placeholder="Ex: 12" required>

                <button type="button" onclick="calcularInvestimento()">Calcular</button>
            </form>
            <div id="resultado" class="resultado">
                <p>Retorno Esperado: <span id="valor-final"></span></p>
            </div>
        </div>
    </div>

    <script src="./resources/js/bootstrap.bundle.min.js" defer></script>
    <script src="./resources/js/investimentos.js"></script>
</body>
</html>