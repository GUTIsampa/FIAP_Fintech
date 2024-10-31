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



// Função para excluir cartão
    document.querySelectorAll('.excluir-cartao').forEach(button => {
        button.addEventListener('click', function () {
            const cartao = this.getAttribute('data-cartao');
            const confirmar = confirm(`Você realmente deseja excluir esse ${cartao}?`);
            if (confirmar) {
                alert(`${cartao} foi excluído.`);
                this.closest('li').remove();
            }
        });
    });


{const ctx = document.getElementById('faturaChart').getContext('2d');

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

    const faturaChart = new Chart(ctx, config);}


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
