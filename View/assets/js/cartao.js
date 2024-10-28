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

document.querySelectorAll('.excluir-cartao').forEach(button => {
    button.addEventListener('click', function () {
        const cartao = this.getAttribute('data-cartao');
        const confirmar = confirm(`Você realmente deseja excluir ${cartao}?`);
        if (confirmar) {
            alert(`${cartao} foi excluído.`);
            this.closest('li').remove();
        }
    });
});

// Função para excluir cartão
function setupCardDeletion() {
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
}