package trabalhofinal;

// Classe que representa um comando de observação
class ComandoObservacao extends Comando {
    private Professor professor;
    private Livro livro;

    public ComandoObservacao(Professor professor, Livro livro) {
        this.professor = professor;
        this.livro = livro;
    }

    // Método que executa o comando de observação
    @Override
    public void executar() {
        facade.observar(professor, livro);
    }
}
