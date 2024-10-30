public static void main(String[] args) {
    Perfil perfil = new Perfil();
    perfil.setNome("Leo Fiap");
    perfil.setEmail("leo.fiap@example.com");
    perfil.setSenha("senha456");
    perfil.setSaldo(150.00);

    PerfilDAO perfilDAO = new PerfilDAO();
    perfilDAO.cadastrarPerfil(perfil);


    Perfil perfilBuscado = perfilDAO.buscarPerfilPorEmail("leo.fiap@example.com");
    if (perfilBuscado != null) {
        perfilBuscado.setSaldo(200.00);
        perfilDAO.atualizarPerfil(perfilBuscado);
    }
}
