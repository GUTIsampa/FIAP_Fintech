let saldo = 0;
    const maxTransferencias = 10;
    const tabela = document.getElementById("tabelaTransferencias");
    const saldoElement = document.getElementById("saldo");
    const mensagemVazia = document.getElementById("mensagemVazia");

    function adicionarTransferencia() {
        const nome = document.getElementById("nome").value;
        const valor = parseFloat(document.getElementById("valor").value);
        const data = document.getElementById("data").value;
        const tipo = document.getElementById("tipo").value;

        if (nome && valor && data && tipo) {
            // Atualizar saldo
            saldo += tipo === "recebimento" ? valor : -valor;
            saldoElement.innerText = `R$ ${saldo.toFixed(2)}`;

            // Remover a mensagem de tabela vazia se for a primeira transferência
            if (mensagemVazia) {
                mensagemVazia.remove();
            }

            // Adicionar nova linha na tabela
            const novaLinha = tabela.insertRow(0);
            novaLinha.classList.add(tipo);
            novaLinha.innerHTML = `
                <td>${nome}</td>
                <td>R$ ${valor.toFixed(2)}</td>
                <td>${data}</td>
                <td>${tipo.charAt(0).toUpperCase() + tipo.slice(1)}</td>
            `;

            // Remover o último item se a tabela tiver mais que o máximo permitido
            if (tabela.rows.length > maxTransferencias) {
                tabela.deleteRow(maxTransferencias);
            }

            // Exibir mensagem de sucesso e resetar o formulário
            document.getElementById("mensagemSucesso").style.display = "block";
            setTimeout(() => {
                document.getElementById("mensagemSucesso").style.display = "none";
            }, 2000);
            document.getElementById("formularioTransferencia").reset();
        }
    }