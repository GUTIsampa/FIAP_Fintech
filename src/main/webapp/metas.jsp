<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
<%@include file="header_metas.jsp"%>
    <div class="conteudo">
        <div class="container-fluid d-flex justify-content-center align-items-center">
            <div class="goal-container text-center container-fluid">
                <h1 class="mb-3 titulo">Metas Fintech</h1>
                <div class="dropdown mb-3">
                    <form action="<c:url value='/metas?mostrar=viewMetas'/>" method="get">
                        <button class="btn botaoPadrao dropdown-toggle" type="submit" data-bs-toggle="dropdown" aria-expanded="false">
                            Selecione a Meta
                        </button>
                        <ul class="dropdown-menu menuMeta" aria-labelledby="metaDropdown" id="metaList">
                            <c:if test="${not empty metas}">
                                <c:forEach items="${metas}" var="metasUser">
                                    <li>
                                        <a class="dropdown-item" href="#" style="color: white" onclick="setMetaName('${metasUser.nome_meta}');">
                                                ${metasUser.nome_meta} - ${metasUser.valor_meta}
                                        </a>
                                    </li>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty metas}">
                                <li>
                                    <span class="dropdown-item">Nenhuma meta encontrada.</span>
                                </li>
                            </c:if>

                        </ul>
                        <input type="hidden" id="metaInput" name="selectedMeta" value=""> <!-- Campo oculto para armazenar o valor da meta selecionada -->

                    </form>
                </div>
                <!-- Imagem dinâmica do Porquinho -->
                <div class="goal-image" id="goalImageContainer">

                </div>

                <div class="metaNum metaAtual">
                    <p id="goalStatus">Nome da Meta: <span id="selectedMetaName" style="color: white"> </span></p>
                </div>
                <button class="btn botaoPadrao botaoInf" data-bs-toggle="modal" data-bs-target="#addMoneyModal">Guardar $</button>
                <button class="btn botaoPadrao botaoInf" data-bs-toggle="modal" data-bs-target="#createGoalModal">Criar Meta</button>
            </div>
        </div>

        <!-- JavaScript para definir o nome da meta -->
        <script>
            function setMetaName(metaName) {
                // Atualiza o conteúdo da div com o nome da meta selecionada
                document.getElementById('selectedMetaName').textContent = metaName;
            }
        </script>

        <!-- Modal para Adicionar Dinheiro -->
        <div class="modal fade" id="addMoneyModal" tabindex="-1" aria-labelledby="addMoneyModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addMoneyModalLabel">Adicionar Valor na Meta</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form id="formGuardar" action="<c:url value='/metas?acao=guardar'/>" method="post">
                    <div class="modal-body">
                        <input type="number" class="form-control" id="addAmount" name="valGuardar" placeholder="Digite o valor" min="0">
                    </div>
                        <div class="modal-body">
                            <input type="text" class="form-control" id="addAmoun" name="nomeGuardar" placeholder="A qual meta deseja adicionar o valor" required>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="submit" form="formGuardar" class="btn botaoPadrao">Adicionar</button>
                        <button type="button" class="btn botaoPadrao" data-bs-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${not empty valor}">
            <div class="alert alert-info text-center" role="alert">
                    ${valor}
            </div>
        </c:if>
        
        <!-- Modal para Criar Meta -->
        <div class="modal fade" id="createGoalModal" tabindex="-1" aria-labelledby="createGoalModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="createGoalModalLabel">Criar Meta</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="<c:url value='/metas?acao=add'/>" method="post">
                            <input type="hidden" name="action" value="create">
                            <input type="text" class="form-control mb-3" name="nomeMeta" placeholder="Nome da Meta" required>
                            <input type="number" class="form-control" name="valMeta" placeholder="Valor da Meta" min="1" required>
                            <div class="modal-footer">
                                <button type="submit" class="btn botaoPadrao">Criar</button>
                                <button type="button" class="btn botaoPadrao" data-bs-dismiss="modal">Fechar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${not empty meta}">
            <div class="alert alert-info text-center" role="alert">
                    ${meta}
            </div>
        </c:if>


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