package trabalhofinal;

// Classe que representa um comando de empréstimo
class ComandoEmprestimo extends Comando {
    private Usuario usuario;
    private Livro livro;

    public ComandoEmprestimo(Usuario usuario, Livro livro) {
        this.facade = Facade.getInstancia();
        this.usuario = usuario;
        this.livro = livro;
    }

    // Método que executa o comando de empréstimo
    @Override
    public void executar() {
        facade.emprestar(usuario, livro);
    }
}
