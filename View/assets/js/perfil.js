
    console.log("Script perfil.js carregado");

    // Seleciona os elementos HTML
    const profilePic = document.getElementById('profile-pic');
    const profilePicInput = document.getElementById('profile-pic-input');
    const changeProfilePicBtn = document.getElementById('change-profile-pic');
    
    // Abre o seletor de arquivos quando o botão é clicado
    changeProfilePicBtn.addEventListener('click', () => {
        profilePicInput.click();
    });
    
    // Atualiza a foto de perfil quando uma nova imagem é escolhida
    profilePicInput.addEventListener('change', () => {
        const file = profilePicInput.files[0];
        if (file) {
            const reader = new FileReader();
            
            reader.onload = function(e) {
                profilePic.src = e.target.result; // Define a nova imagem
            };
            
            reader.readAsDataURL(file);
        }
    }); 




    document.getElementById('delete-account').addEventListener('click', function() {
        if (confirm("Tem certeza de que deseja excluir a conta? Esta ação não pode ser desfeita.")) {
            // Lógica para excluir a conta
            alert("Conta excluída com sucesso.");
        }
    });


    document.getElementById('change-password').addEventListener('click', function() {
        const newPassword = prompt("Digite sua nova senha:");
        if (newPassword) {
            // Lógica para atualizar a senha
            alert("Senha alterada com sucesso.");
        }
    });
    

    

