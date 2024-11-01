document.addEventListener('click', function (event) {
    const dropdown = document.querySelector('.dropdown');
    const button = document.getElementById('dropdownMenuButton');

    if (!dropdown.contains(event.target) && !button.contains(event.target)) {
        const dropdownMenu = dropdown.querySelector('.dropdown-menu');
        if (dropdownMenu.classList.contains('show')) {
            dropdownMenu.classList.remove('show');
        }
    }
});

// Array para armazenar cartões criados
/*let cartoes = [];

// Função para atualizar o dropdown com os cartões
function atualizarDropdown() {
    const dropdownMenu = document.querySelector('.menuCard');
    dropdownMenu.innerHTML = ''; // Limpa o dropdown antes de adicionar novos itens

    cartoes.forEach(cartao => {
        const li = document.createElement('li');
        // Obtém os 4 últimos dígitos do número do cartão
        const ultimoNumero = cartao.numero.slice(-4); 
        li.innerHTML = `
        aqui fica o código apagado


        `;
        dropdownMenu.appendChild(li);
    });

    // Adicionar event listeners para os novos botões de exclusão
    adicionarListenersExclusao();
}

// Função para adicionar um novo cartão
document.getElementById('cardForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita o envio padrão do formulário

    const cardHolder = document.getElementById('cardHolder').value;
    const cardNumber = document.getElementById('cardNumber').value;
    const cardCvv = document.getElementById('cardCvv').value;
    const expiryDate = document.getElementById('expiryDate').value;
    const cardBrand = document.getElementById('cardBrand').value;


    // Adiciona o novo cartão ao array
    cartoes.push({
        titular: cardHolder,
        numero: cardNumber,
        cvv: cardCvv,
        validade: expiryDate,
        bandeira: cardBrand
    });
*/
    // Atualiza o dropdown
    atualizarDropdown();

    // Fecha a modal após adicionar
    const modal = bootstrap.Modal.getInstance(document.getElementById('addCardModal'));
    modal.hide();
    document.getElementById('cardForm').reset(); // Reseta o formulário
});

// Função para adicionar listeners aos botões de exclusão
function adicionarListenersExclusao() {
    document.querySelectorAll('.excluir-cartao').forEach(button => {
        button.addEventListener('click', function () {
            const cartaoNumero = this.getAttribute('data-cartao-numero');
            const confirmar = confirm(`Você realmente deseja excluir o cartão ${cartaoNumero}?`);
            if (confirmar) {
                alert(`Cartão ${cartaoNumero} foi excluído.`);
                // Remove o cartão do array
                cartoes = cartoes.filter(cartao => cartao.numero !== cartaoNumero);
                atualizarDropdown(); // Atualiza o dropdown
            }
        });
    });
}

// Inicializa o dropdown com os cartões (caso haja algum)
atualizarDropdown();

// Gráfico da fatura
const ctx = document.getElementById('faturaChart').getContext('2d');

// Dados fictícios para os últimos 5 meses
const labels = [
    'Setembro', 
    'Outubro', 
    'Novembro', 
    'Dezembro', 
    'Atual'
]; // Atualize os meses conforme necessário

const data = {
    labels: labels,
    datasets: [{
        label: 'Valor da Fatura',
        data: [150, 200, 180, 220, 450], // Valores de exemplo
        backgroundColor: '#BE6513',
        borderColor: '#152e3b',
        borderWidth: 1
    }]
};

const config = {
    type: 'bar',
    data: data,
    options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
            legend: {
                labels: {
                    color: '#000' // Altera a cor do texto na legenda
                }
            }
        },
        scales: {
            y: {
                beginAtZero: true,
                title: {
                    display: true,
                    text: 'Valor (R$)',
                    color: '#BE6513'
                },
                ticks: {
                    color: '#000' // Cor dos valores no eixo Y
                }
            },
            x: {
                title: {
                    display: true,
                    text: 'Meses',
                    color: '#BE6513'
                },
                ticks: {
                    color: '#000' // Cor dos valores no eixo Y
                }
            }
        }
    }
};

const faturaChart = new Chart(ctx, config);

// Formulário de fatura
document.getElementById('faturaForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita o envio padrão do formulário

    const faturaValue = document.getElementById('faturaValue').value;
    // Aqui você pode adicionar a lógica para processar o valor, como atualizar o gráfico ou enviar para o servidor

    console.log('Fatura adicionada: R$', faturaValue); // Exemplo de como processar o valor

    // Fecha a modal após adicionar
    const modal = bootstrap.Modal.getInstance(document.getElementById('addFaturaModal'));
    modal.hide();
    document.getElementById('faturaForm').reset(); // Reseta o formulário
});