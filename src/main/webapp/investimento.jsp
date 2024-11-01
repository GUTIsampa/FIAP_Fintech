<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
    <header>
        <div class="desktop">
            <nav class="navbar">
                <img class="logofin img-fluid" src="./resources/images/Logo2.png" alt="Logo Fintech">
                <div class="nav-item">
                    <a class="nav-link" aria-current="page" href="" data-page="cartao"> <i class="fa-regular fa-credit-card icones"></i> Cartão</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                </div>
                <div class="active">
                    <a class="nav-link" href="investimento.jsp" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                </div>
                <div class="nav-item">
                    <a class="nav-link" href="" data-page="metas"> <i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
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
                            <a class="nav-link" aria-current="page" href="" data-page="cartao"> <i class="fa-regular fa-credit-card icones"></i> Cartão</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="" data-page="transferencias"><i class="fa-solid fa-money-bill-transfer icones"></i> Transferências</a>
                        </div>
                        <div class="active itemMobile">
                            <a class="nav-link" href="" data-page="investimentos"><i class="fa-solid fa-money-bill-trend-up icones"></i> Investimentos</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="" data-page="metas"> <i class="fa-solid fa-piggy-bank icones"></i> Metas</a>
                        </div>
                        <div class="nav-item itemMobile">
                            <a class="nav-link" href="" data-page="perfil"><i class="fa-solid fa-user icones"></i> Perfil</a>
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