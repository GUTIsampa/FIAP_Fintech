let goals = [];
let currentGoal = null;

// Função para atualizar a imagem e o progresso
function updateGoalDisplay() {
    const goalImageContainer = document.getElementById('goalImageContainer');
    const goalStatus = document.getElementById('goalStatus');

    if (!currentGoal) {
        // Exibir imagem e mensagem padrão quando não há metas
        goalImageContainer.innerHTML = `<img src="../images/porquinho0.png" alt="Sem Metas" class="img-fluid porquinhos">`;
        goalStatus.textContent = 'Sem metas no momento...';
        return;
    }

    const { name, current, target } = currentGoal;
    const progress = (current / target) * 100;

    // Atualizando status da meta
    goalStatus.textContent = `Nome da Meta: ${current}/${target}`;

    // Lógica de seleção da imagem baseada no progresso
    let imageUrl = '../images/porquinho0.png';
    if (progress < 25) {
        imageUrl = '../images/porquinho0.png';
    } else if (progress < 50) {
        imageUrl = '../images/porquinho25.png';
    } else if (progress < 75) {
        imageUrl = '../images/porquinho50.png';
    } else if (progress < 100) {
        imageUrl = '../images/porquinho75.png';
    } else if (progress >= 100) {
        imageUrl = '../images/porquinho100.png';
        
        // Exibir modal de conclusão da meta
        const goalCompletedModal = new bootstrap.Modal(document.getElementById('goalCompletedModal'));
        goalCompletedModal.show();
    }

    // Carregar a imagem
    goalImageContainer.innerHTML = `<img src="${imageUrl}" alt="Progresso da Meta" class="img-fluid porquinhos">`;
}

// Função para adicionar dinheiro na meta atual
function addMoney() {
    const amount = parseFloat(document.getElementById('addAmount').value);
    if (isNaN(amount) || amount <= 0 || !currentGoal) return;
    
    currentGoal.current += amount;
    updateGoalDisplay();
    
    // Fecha a modal de adicionar dinheiro
    const addMoneyModal = bootstrap.Modal.getInstance(document.getElementById('addMoneyModal'));
    addMoneyModal.hide();
    
    // Abre a modal de notificação
    const notificationModal = new bootstrap.Modal(document.getElementById('notificationModal'));
    document.getElementById('notificationMessage').textContent = 'Valor Adicionado na Meta'; // Atualiza a mensagem
    notificationModal.show();

    // Fecha a modal de notificação após 2 segundos
    setTimeout(() => {
        notificationModal.hide();
    }, 2000);
}

// Função para criar uma nova meta
function createGoal() {
    const name = document.getElementById('goalName').value;
    const target = parseFloat(document.getElementById('goalValue').value);
    if (!name || isNaN(target) || target <= 0) return;

    const newGoal = { name, target, current: 0 };
    goals.push(newGoal);
    currentGoal = newGoal;
    updateDropdown();
    updateGoalDisplay();
    
    // Fecha a modal de criação de meta
    const createGoalModal = bootstrap.Modal.getInstance(document.getElementById('createGoalModal'));
    createGoalModal.hide();
    
    // Abre a modal de notificação
    const notificationModal = new bootstrap.Modal(document.getElementById('notificationModal'));
    notificationModal.show();

    // Fecha a modal de notificação após 2 segundos
    setTimeout(() => {
        notificationModal.hide();
    }, 2000);
}

// Função para concluir a meta
function concludeGoal() {
    // Remove a meta concluída da lista de metas
    goals = goals.filter(goal => goal !== currentGoal);
    currentGoal = null; // Reseta a meta atual
    updateDropdown();
    updateGoalDisplay();
    
    // Fecha o modal de meta concluída
    const goalCompletedModal = bootstrap.Modal.getInstance(document.getElementById('goalCompletedModal'));
    goalCompletedModal.hide();
}

function updateDropdown() {
    const metaList = document.getElementById('metaList');
    const metaDropdown = document.getElementById('metaDropdown');
    metaList.innerHTML = '';

    if (goals.length === 0) {
        // Exibe uma opção padrão indicando que não há metas
        const emptyItem = document.createElement('li');
        emptyItem.classList.add('dropdown-item', 'text-center', 'semMeta');
        emptyItem.textContent = 'Sem metas disponíveis';
        metaList.appendChild(emptyItem);

        // Redefine a meta atual e mantém o dropdown ativo
        currentGoal = null;
        updateGoalDisplay();
        return;
    } else {
        // Ativa o dropdown se houver metas
        metaDropdown.classList.remove('disabled');
        metaDropdown.setAttribute('data-bs-toggle', 'dropdown');
    }

    // Atualiza a lista de metas no dropdown
    goals.forEach((goal, index) => {
        const listItem = document.createElement('li');
        listItem.classList.add('dropdown-item', 'd-flex', 'justify-content-between', 'align-items-center', 'itemMeta');
        
        const goalButton = document.createElement('span');
        goalButton.textContent = goal.name;
        goalButton.onclick = () => {
            currentGoal = goal;
            updateGoalDisplay();
        };
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('btn', 'btn-sm', 'ms-2');
        deleteButton.innerHTML = '<i class="fa-solid fa-trash lixinho"></i>';
        deleteButton.onclick = () => {
            goals.splice(index, 1);
            if (currentGoal === goal) currentGoal = null;
            updateDropdown();
            updateGoalDisplay();
        };

        listItem.appendChild(goalButton);
        listItem.appendChild(deleteButton);
        metaList.appendChild(listItem);
    });
}

// Chama a função uma vez para exibir o estado inicial
updateGoalDisplay();