<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Bruno+Ace&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="./resources/css/styleCadastro.css">
</head>

<body>
<div class="container quadroCadastro">
  <div class="row justify-content-center">
    <div class="col-md-8">
      <h2 class="text-center tituloMobile">Cadastro de Conta Fintech</h2>
      <h1 class="text-center tituloDesk">Cadastro de Conta Fintech</h1>

      <!-- Mensagem de sucesso -->
      <c:if test="${not empty mensagemSucesso}">
        <div class="alert alert-success">
            ${mensagemSucesso}
        </div>
      </c:if>

      <!--acionada caso o e-mail já exista-->
      <c:if test="${not empty mensagemErro}">
        <div class="alert alert-danger">
            ${mensagemErro}
        </div>
      </c:if>

      <form action="<c:url value='/cadastro?acao=cadastrar'/>" method="post">
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="nome" class="info">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" placeholder="..." required>
          </div>
          <div class="form-group col-md-6">
            <label for="documento" class="info">Data de Nascimento</label>
            <input type="date" class="form-control" id="documento" name="dataNascimento" placeholder="DD/MM/AA" required>
          </div>
        </div>
        <div class="form-group">
          <label for="email" class="info">Email</label>
          <input type="email" class="form-control" id="email" name="email" placeholder="exemplo@email.com" required>
        </div>
        <div class="form-group">
          <label for="senha" class="info">Senha</label>
          <input type="password" class="form-control" id="senha" name="senha" placeholder="..." required>
        </div>

        <div class="d-flex justify-content-between mt-4">
         <a href="cadastro?acao=voltar"> <button type="button" class="btn botao">Voltar</button></a>
          <button type="submit" class="btn botao">Cadastrar</button>
        </div>
      </form>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="./resources/js/cadastro.js" defer></script>
</body>
</html>
