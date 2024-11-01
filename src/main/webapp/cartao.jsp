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
    <header>
        <div class="desktop">
            <nav class="navbar">
                <img class="logofin img-fluid" src="./resources/images/Logo2.png" alt="Logo Fintech">
                <div class="active">
                    <a class="nav-link" data-page="cartao"><i class="fa-regular fa-credit-card icones"></i> Cartão</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="" data-page="metas"><i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="perfil.jsp" data-page="perfil"><i class="fa-solid fa-user icones"></i> Perfil</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="">Sair</a>
                </div>
            </nav>
        </div>

        <div class="mobile">
            <a class="btn menuSandu" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample">
                <i class="fa-solid fa-bars"></i>
            </a>
            <img class="img-fluid logoMobile" src="./resources/images/Logo2.png" alt="Logo Fintech">
            <div class="offcanvas offcanvas-start navMobile" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
                <div class="offcanvas-header">
                    <img class="logofin img-fluid" src="./resources/images/Logo2.png" alt="Logo Fintech">
                    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <div>
                        <div class="active itemMobile">
                            <a class="nav-link" aria-current="page" href="cartao.jsp" data-page="cartao"><i class="fa-regular fa-credit-card icones"></i> Cartão</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="" data-page="metas"><i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="perfil.jsp" data-page="perfil"><i class="fa-solid fa-user icones"></i> Perfil</a>
                        </div>
                        <div class="nav-item">
                            <a class="nav-link" href="">Sair</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    
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
                <button class="btn btn-center botaoPadrao botaoAdd" data-bs-toggle="modal" data-bs-target="#addCardModal"><i class="fa-solid fa-plus"></i> Cartão</button>

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
        <!-- Formulário de adicionar cartão e cartões salvos -->
        <c:forEach var="cartao" items="${cartoes}">
            <div class="container-fluid cartao">
                <div class="cartao-content">
                    <div class="icon-container">
                        <img src="./resources/images/Chip Card.png" alt="Chip" class="card-icon">
                    </div>
                    <div class="card-holder">
                        <p class="card-holder-name">${cartao.titular}</p>
                    </div>
                    <div class="card-number numeroCartao">
                        <p>${cartao.numero}</p>
                    </div>
                    <div class="card-footer">
                        <p class="expiry-date">${cartao.vencimento}</p>
                        <p class="card-brand">${cartao.bandeira}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
        <c:if test="${empty cartoes}">
        <p class="no-card-message" style="display: block;">Nenhum Cartão Armazenado</p>
        </c:if>

        <!-- Dropdown de cartões -->
        <div class="dropdown mt-3">
            <button class="btn btn-center botaoPadrao dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false" onclick="window.location.href='/cartao?acao=listarCartao'">
                Alterar Cartão
            </button>
            <ul class="dropdown-menu menuCard" aria-labelledby="dropdownMenuButton">
                <c:forEach var="cartao" items="${cartoes}">
                    <li>
                        <div class="d-flex justify-content-between">
                            <a class="dropdown-item itemCartao" href="#">Cartão Final: ${cartao.nr_cartao}</a>
                            <button class="btn btn-sm excluir-cartao" data-cartao="${cartao.id}"><i class="fa-solid fa-trash"></i></button>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
        <!-- Controle de fatura -->
        <div class="container mt-5 fatura">
            <h2 class="titulofatura">Controle de Fatura</h2>
            <h3 class="titulofaturaMobile">Controle de Fatura</h3>
            <canvas id="faturaChart"></canvas>

            <button class="btn btn-center botaoPadrao" data-bs-toggle="modal" data-bs-target="#addFaturaModal">+ Fatura Atual</button>

            <!-- Modal para adicionar fatura -->
            <div class="modal fade" id="addFaturaModal" tabindex="-1" aria-labelledby="addFaturaModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addFaturaModalLabel">Adicionar à Fatura Atual</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form id="faturaForm">
                                <div class="mb-3">
                                    <label for="faturaValue" class="form-label textoModal">Acrescentar à Fatura Atual</label>
                                    <input type="number" class="form-control" id="faturaValue" placeholder="R$" required>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn botaoFechar" data-bs-dismiss="modal">Fechar</button>
                            <button type="submit" form="faturaForm" class="btn botaoCadastrar">Adicionar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
    
    <script src="./resources/js/bootstrap.bundle.min.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="./resources/js/cartao.js" defer></script>
</body>
</html>
