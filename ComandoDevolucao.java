package trabalhofinal;

// Classe que representa um comando de devolução
class ComandoDevolucao extends Comando {
    private Usuario usuario;
    private Livro livro;

    public ComandoDevolucao(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    // Método que executa o comando de devolução
    @Override
    public void executar() {
        facade.devolver(usuario, livro);
    }
}