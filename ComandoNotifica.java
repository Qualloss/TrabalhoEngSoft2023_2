package trabalhofinal;

public class ComandoNotifica extends Comando {
    private Professor professor;

    public ComandoNotifica(Professor professor) {
        this.facade = Facade.getInstancia();
        this.professor = professor;
    }

    @Override
    public void executar() {
        facade.quantidadeNotificacao(professor);
    }
}
