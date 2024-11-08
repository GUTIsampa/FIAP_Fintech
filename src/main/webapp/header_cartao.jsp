<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cartão</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/css/styleNav.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>


<header>
    <div class="desktop">
        <nav class="navbar">
            <img class="logofin img-fluid" src="./resources/images/Logo2.png" alt="Logo Fintech">
            <div class="active">
                <a class="nav-link" data-page="cartao"><i class="fa-regular fa-credit-card icones"></i> Cartão</a>
            </div>
            <div class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/transferencias?acao=saldo&view=viewFatura&id=${sessionScope.id}" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
            </div>
            <div class="nav-item">
                <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
            </div>
            <div class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/metas?mostrar=viewMetas" data-page="metas"><i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
            </div>
            <div class="nav-item">
                <a class="nav-link" href="perfil.jsp" data-page="perfil"><i class="fa-solid fa-user icones"></i> Perfil</a>
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
                        <a class="nav-link" href="${pageContext.request.contextPath}/transferencias?acao=saldo&id=${sessionScope.id}" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                    </div>
                    <div class="nav-item itemMobile">
                        <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                    </div>
                    <div class="nav-item itemMobile">
                        <a class="nav-link" href="metas.jsp" data-page="metas"><i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
                    </div>
                    <div class="nav-item itemMobile">
                        <a class="nav-link" href="perfil.jsp" data-page="perfil"><i class="fa-solid fa-user icones"></i> Perfil</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

    <script src="./resources/js/bootstrap.bundle.min.js" defer></script>
</html>