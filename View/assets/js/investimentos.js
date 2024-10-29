function calcularInvestimento() {
    const investimentoInicial = parseFloat(document.getElementById("investimento").value);
    const taxaJuros = parseFloat(document.getElementById("taxa-juros").value) / 100;
    const periodo = parseInt(document.getElementById("periodo").value);

    if (isNaN(investimentoInicial) || isNaN(taxaJuros) || isNaN(periodo)) {
        alert("Por favor, preencha todos os campos corretamente.");
        return;
    }

    // Fórmula de juros compostos: M = P * (1 + i)^n
    const valorFinal = investimentoInicial * Math.pow(1 + taxaJuros, periodo);

    document.getElementById("valor-final").textContent = valorFinal.toLocaleString("pt-BR", { style: "currency", currency: "BRL" });
}
