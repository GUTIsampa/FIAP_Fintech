<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transferências</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/styleNav.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="./resources/css/styleTransferencias.css">
</head>

<body>
    <header>
        <div class="desktop">
            <nav class="navbar">
                <img class="logofin img-fluid" src="./resources/images/Logo2.png" alt="Logo Fintech">
                <div class="nav-item">
                    <a class="nav-link" href="cartao.jsp" data-page="cartao"><i class="fa-regular fa-credit-card icones"></i> Cartão</a>
                </div>
                <div class="active">
                    <a class="nav-link" href="transferencias.jsp" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="/FintechBackEnd_war_exploded/metas?mostrar=viewMetas" data-page="metas"><i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
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
                        <div class="active itemMobile">
                            <a class="nav-link" aria-current="page" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                        </div>
                        <div class="nav-item itemMobile">
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
        <div class="container-fluid mt-4">
            <div class="saldo text-center p3" >
                <c:if test="${not empty saldoAtual}">
                    Seu Saldo Atual é: <span id="saldo">R$ <c:out value="${saldoAtual}" /></span>
                </c:if>
                <c:if test="${empty saldoAtual}">
                    Seu saldo não está disponível no momento.
                </c:if>
            </div>
            <div class="mt-5">
                <button class="btn botaoPadrao" data-bs-toggle="modal" data-bs-target="#modalFormulario">Adicionar Valor</button>
            </div>

            <div class="modal fade" id="modalFormulario" tabindex="-1" aria-labelledby="modalFormularioLabel" aria-hidden="true">
                <div class="modal-dialog modalTrans">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title textoForm" id="modalFormularioLabel">Adicionar Transferência</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form id="formularioTransferencia" action="<c:url value='/transferencias?acao=cadastrarTrans'/>" method="post">
                                <div class="mb-3">
                                    <label for="nome" class="form-label textoForm">Nome na Transferência</label>
                                    <input type="text" class="form-control" id="nome" name="nomeTrans" placeholder="Ex: Mercado, Salário, Pix...">
                                </div>
                                <div class="mb-3">
                                    <label for="valor" class="form-label textoForm">Valor</label>
                                    <input type="text" class="form-control" id="valor" name="valTrans" step="0.01" placeholder="R$" required>
                                </div>
                                <div class="mb-3">
                                    <label for="data" class="form-label textoForm">Data</label>
                                    <input type="date" class="form-control" id="data" name="dataTrans" required>
                                </div>
                                <div class="mb-3">
                                    <label for="tipo" class="form-label textoForm">Tipo</label>
                                    <select class="form-select" id="tipo" name="tipoTrans" required>
                                        <option class="opcao" value="recebimento">Recebimento</option>
                                        <option class="opcao" value="pagamento">Pagamento</option>
                                    </select>
                                </div>
                                <div class="text-success" id="mensagemSucesso" style="display: none;">Valor Adicionado com Sucesso!</div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" form="formularioTransferencia" class="btn botaoPadrao">Adicionar</button>
                            <button type="button" class="btn botaoPadrao" data-bs-dismiss="modal">Fechar</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="mt-4 divTabela text-center">
                <table class="table corpoTabela">
                    <thead class="cabecalho">
                        <tr>
                            <th class="coluna">Nome</th>
                            <th class="coluna">Valor</th>
                            <th class="coluna">Data</th>
                            <th class="coluna">Tipo</th>
                        </tr>
                    </thead>
                    <tbody id="tabelaTransferencias">
                        <c:choose>
                            <c:when test="${empty transferencias}">
                                <tr id="mensagemVazia">
                                    <td colspan="4" class="mensagem-vazia coluna">
                                        <h2 class="semVal">Sem valores por enquanto...</h2>
                                        <img src="./resources/images/porquinhoQuebrado.png" alt="Cofrinho Quebrado" class="cofrinhoQuebrado">
                                    </td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="trans" items="${transferencias}">
                                    <tr>
                                        <td class="coluna"><c:out value="${trans.nome_transferencia}" /></td>
                                        <td class="coluna"><c:out value="${trans.valor_transferencia}" /></td>
                                        <td class="coluna"><c:out value="${trans.data_transferencia}" /></td>
                                        <td class="coluna"><c:out value="${trans.tipo_transferencia}" /></td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>
            <c:if test="${not empty transferencia}">
                <div class="alert alert-info text-center" role="alert">
                        ${transferencia}
                </div>
            </c:if>
        </div>
    </div>

    <script src="./resources/js/bootstrap.bundle.min.js" defer></script>
    <script src="./resources/js/transferencias.js"></script>
</body>
</html>