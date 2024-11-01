<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Metas</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/styleNav.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./resources/css/styleMetas.css">
</head>

<body>
    <header>
        <div class="desktop">
            <nav class="navbar">
                <img class="logofin img-fluid" src="./resources/images/Logo2.png" alt="Logo Fintech">
                <div class="nav-item">
                    <a class="nav-link" href="cartao.jsp" data-page="cartao"><i class="fa-regular fa-credit-card icones"></i> Cartão</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="transferencias.jsp" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                </div>
                <div class="active">
                    <a class="nav-link" href="metas.jsp" data-page="metas"><i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
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
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="cartao.jsp" data-page="cartao"><i class="fa-regular fa-credit-card icones"></i> Cartão</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" aria-current="page" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                        </div>
                        <div class="active itemMobile">
                            <a class="nav-link" href="metas.jsp" data-page="metas"><i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
                        </div>
                        <div class="nav-itemitemMobile">
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
        <div class="container-fluid d-flex justify-content-center align-items-center">
            <div class="goal-container text-center container-fluid">
                <h1 class="mb-3 titulo">Metas Fintech</h1>
                <div class="dropdown mb-3">
                    <button class="btn botaoPadrao dropdown-toggle" type="button" id="metaDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        Selecione a Meta
                    </button>
                    <ul class="dropdown-menu menuMeta" aria-labelledby="metaDropdown" id="metaList">
                        <!-- Itens de meta adicionados dinamicamente -->
                    </ul>
                </div>
                <!-- Imagem dinâmica do Porquinho -->
                <div class="goal-image" id="goalImageContainer"></div>

                <div class="metaNum metaAtual">
                    <p id="goalStatus">Nome da Meta: X/Y</p>
                </div>
                <button class="btn botaoPadrao botaoInf" data-bs-toggle="modal" data-bs-target="#addMoneyModal">Guardar $</button>
                <button class="btn botaoPadrao botaoInf" data-bs-toggle="modal" data-bs-target="#createGoalModal">Criar Meta</button>
            </div>
        </div>

        <!-- Modal para Adicionar Dinheiro -->
        <div class="modal fade" id="addMoneyModal" tabindex="-1" aria-labelledby="addMoneyModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addMoneyModalLabel">Adicionar Valor na Meta</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="number" class="form-control" id="addAmount" placeholder="Digite o valor" min="0">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn botaoPadrao" onclick="addMoney()">Adicionar</button>
                        <button type="button" class="btn botaoPadrao" data-bs-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Modal para Criar Meta -->
        <div class="modal fade" id="createGoalModal" tabindex="-1" aria-labelledby="createGoalModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="createGoalModalLabel">Criar Meta</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="text" class="form-control mb-3" id="goalName" placeholder="Nome da Meta">
                        <input type="number" class="form-control" id="goalValue" placeholder="Valor da Meta" min="1">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn botaoPadrao" onclick="createGoal()">Criar</button>
                        <button type="button" class="btn botaoPadrao" data-bs-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal para Notificação -->
        <div class="modal fade" id="notificationModal" tabindex="-1" aria-labelledby="notificationModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="notificationModalLabel">Notificação</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body metacriada">
                        Meta Criada!
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn botaoPadrao" data-bs-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal para Meta Concluída -->
        <div class="modal fade" id="goalCompletedModal" tabindex="-1" aria-labelledby="goalCompletedModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="goalCompletedModalLabel">Parabéns!</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body sucesso">
                        Parabéns! Você concluiu a Meta!!!!! 
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn botaoPadrao" onclick="concludeGoal()">Concluir Meta</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="./resources/js/bootstrap.bundle.min.js" defer></script>
    <script src="./resources/js/meta.js"></script>
</body>
</html>