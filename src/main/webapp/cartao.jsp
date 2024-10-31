<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                    <a class="nav-link" aria-current="" data-page="cartao"><i class="fa-regular fa-credit-card icones"></i> Cartão</a>
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
            <button class="btn btn-center botaoPadrao dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                Alterar Cartão
            </button>
            <ul class="dropdown-menu menuCard" aria-labelledby="dropdownMenuButton">
                <c:forEach var="cartao" items="${cartoes}">
                    <li>
                        <div class="d-flex justify-content-between">
                            <a class="dropdown-item itemCartao" href="#">Cartão Final: ${cartao.final}</a>
                            <button class="btn btn-sm excluir-cartao" data-cartao="${cartao.id}"><i class="fa-solid fa-trash"></i></button>
                        </div>
                    </li>
                </c:forEach>
            </ul>
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
    </div>
    
    
    <script src="./resources/js/bootstrap.bundle.min.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="./resources/js/cartao.js" defer></script>
</body>
</html>
