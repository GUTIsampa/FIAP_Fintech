<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carteira Digital</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/styleNav.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./resources/css/styleCartao.css">
</head>
<body>
<%@include file="header_cartao.jsp"%>

    <div class="conteudo">
        <div class="welcome-message">
            <h1 class="bemvindo">Bem vindo ${usuario}</h1>
            <h3 class="bemvindoMobile"> Bem vindo ${usuario}</h3>
        </div>

        <c:if test="${not empty cartao}">
        <div class="alert alert-info text-center" role="alert">
                ${cartao}
        </div>
        </c:if>

        <div class="areaCartao container-fluid">
            <div class="AddCard container-fluid">
                <button class="btn btn-center botaoPadrao botaoAdd" style="color: white" data-bs-toggle="modal" data-bs-target="#addCardModal"><i class="fa-solid fa-plus"></i> Cartão</button>

                <!-- Modal -->
                <div class="modal fade" id="addCardModal" tabindex="-1" aria-labelledby="addCardModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title textoModal" id="addCardModalLabel">Cadastrar Cartão</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">

                                <form id="cardForm" action="<c:url value='/cartao?acao=cadastrarCartao'/>" method="post">
                                    <div class="mb-3">
                                        <label for="cardHolder" class="form-label textoModal">Nome do Titular</label>
                                        <input type="text" class="form-control" id="cardHolder" name="nomeCartao" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="cardNumber" class="form-label textoModal">Número do Cartão</label>
                                        <input type="text" class="form-control" id="cardNumber" name="numeroCartao" maxlength="16" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="cardCvv" class="form-label textoModal">CVV</label>
                                        <input type="text" class="form-control" id="cardCvv" name="codCartao" maxlength="3" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="expiryDate" class="form-label textoModal">Data de Vencimento</label>
                                        <input type="date" class="form-control" id="expiryDate" name="dataVencimento" placeholder="MM/AA" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="cardBrand" class="form-label textoModal">Bandeira</label>
                                        <select class="form-select" id="cardBrand" name="bandeiraCartao" required>
                                            <option value="" disabled selected>Selecione a bandeira</option>
                                            <option value="visa">Visa</option>
                                            <option value="mastercard">MasterCard</option>
                                            <option value="amex">American Express</option>
                                            <option value="discover">Discover</option>
                                            <option value="elo">Elo</option>
                                        </select>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn botaoFechar" data-bs-dismiss="modal">Fechar</button>
                                <button type="submit" form="cardForm" class="btn botaoCadastrar">Cadastrar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
        <!-- Controle de fatura -->
        <div class="container mt-5 fatura">
            <h2 class="titulofatura">Controle de Fatura</h2>
            <h3 class="titulofaturaMobile">Controle de Fatura</h3>
            <table class="table corpoTab">
                <thead>
                    <tr>
                        <th class="coluna">Nome</th>
                        <th class="coluna">Bandeira</th>
                        <th class="coluna">Fatura mês anterior R$</th>
                    </tr>
                </thead>
                <tbody id="tabelaFaturas">
                <c:if test="${empty cartoes}">
                    <tr id="mensagemVazia">
                        <td colspan="4" class="mensagem-vazia coluna">
                            <h2 class="semVal">Sem valores por enquanto...</h2>
                            <img src="./resources/images/porquinhoQuebrado.png" alt="Cofrinho Quebrado" class="cofrinhoQuebrado">
                            <c:out value="${cartoes}" />
                        </td>
                    </tr>
                </c:if>
                <c:if test="${not empty cartoes}">
                    <c:forEach var="fatura" items="${cartoes}">
                        <tr>
                            <td class="coluna">${fatura.nomeTitular}</td>
                            <td class="coluna">${fatura.bandeira}</td>
                            <td class="coluna">${fatura.totalGastos}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>

    <script src="./resources/js/bootstrap.bundle.min.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="./resources/js/cartao.js" defer></script>

</body>
</html>
