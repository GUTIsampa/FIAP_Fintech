let goals = [];
let currentGoal = null;

// Função para atualizar a imagem e o progresso
function updateGoalDisplay() {
    const goalImageContainer = document.getElementById('goalImageContainer');
    const goalStatus = document.getElementById('goalStatus');

    if (!currentGoal) {
        // Exibir imagem e mensagem padrão quando não há metas
        goalImageContainer.innerHTML = `<img src="/View/assets/images/porquinho0.png" alt="Sem Metas" class="img-fluid porquinhos">`;
        goalStatus.textContent = 'Sem metas no momento...';
        return;
    }

    const { name, current, target } = currentGoal;
    const progress = (current / target) * 100;

    // Atualizando status da meta
    goalStatus.textContent = `Nome da Meta: ${current}/${target}`;

    // Lógica de seleção da imagem baseada no progresso
    let imageUrl = '/View/assets/images/porquinho0.png';
    if (progress < 25) {
        imageUrl = '/View/assets/images/porquinho0.png';
    } else if (progress < 50) {
        imageUrl = '/View/assets/images/porquinho25.png';
    } else if (progress < 75) {
        imageUrl = '/View/assets/images/porquinho50.png';
    } else if (progress < 100) {
        imageUrl = '/View/assets/images/porquinho75.png';
    } else if (progress >= 100) {
        imageUrl = '/View/assets/images/porquinho100.png';
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
}

// Função para atualizar o dropdown com as metas
function updateDropdown() {
    const metaList = document.getElementById('metaList');
    const metaDropdown = document.getElementById('metaDropdown');
    metaList.innerHTML = '';
    
    if (goals.length === 0) {
        // Desativar o dropdown se não houver metas
        metaDropdown.classList.add('disabled');
        metaDropdown.removeAttribute('data-bs-toggle');
        currentGoal = null;
        updateGoalDisplay();
        return;
    } else {
        // Ativar o dropdown se houver metas
        metaDropdown.classList.remove('disabled');
        metaDropdown.setAttribute('data-bs-toggle', 'dropdown');
    }

    goals.forEach((goal, index) => {
        const listItem = document.createElement('li');
        listItem.classList.add('dropdown-item', 'd-flex', 'justify-content-between', 'align-items-center');
        
        const goalButton = document.createElement('span');
        goalButton.textContent = goal.name;
        goalButton.onclick = () => {
            currentGoal = goal;
            updateGoalDisplay();
        };
        
        const deleteButton = document.createElement('button');
        deleteButton.classList.add('btn', 'btn-sm','ms-2');
        deleteButton.innerHTML = '<i class="fa-solid fa-trash lixinho "></i>';
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