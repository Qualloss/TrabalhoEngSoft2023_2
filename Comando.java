package trabalhofinal;

// Classe que representa um comando
abstract class Comando {
    protected Facade facade;

    protected Comando() {
        this.facade = Facade.getInstancia();
    }

    // Método abstrato que executa o comando
    public abstract void executar();
}
