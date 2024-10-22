document.addEventListener("DOMContentLoaded", function() {
    // Carregar a página inicial ao carregar o documento
    loadPage("cartao.html");

    // Função para carregar a página
    function loadPage(page) {
        fetch(page)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(html => {
                document.getElementById("content").innerHTML = html;
                updateActiveNav(page);
            })
            .catch(error => {
                console.error('There was a problem with the fetch operation:', error);
            });
    }

     // Função para atualizar o item de navegação ativo
     function updateActiveNav(activePage) {
        const navLinks = document.querySelectorAll('.nav-item');
        navLinks.forEach(link => {
            const page = link.querySelector('a').getAttribute('href');
            if (page === activePage) {
                link.classList.add('active'); // Adiciona a classe active
            } else {
                link.classList.remove('active'); // Remove a classe active dos outros
            }
        });
    }


    // Adicionar evento de clique nas navegações
    const navLinks = document.querySelectorAll('.nav-link');
    navLinks.forEach(link => {
        link.addEventListener('click', function(event) {
            event.preventDefault(); // Evita o comportamento padrão do link
            const page = this.getAttribute('href'); // Pega o href do link
            loadPage(page); // Carrega a nova página
        });
    });
});