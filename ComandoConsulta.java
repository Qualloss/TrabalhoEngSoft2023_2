package trabalhofinal;

// Classe que representa um comando de consulta
class ComandoConsulta extends Comando {
    private String tipo;
    private String parametro;

    public ComandoConsulta(String tipo, String parametro) {
        this.facade = Facade.getInstancia();
        this.tipo = tipo;
        this.parametro = parametro;
    }

    // Método que executa o comando de consulta
    @Override
    public void executar() {
        facade.consultar(tipo, parametro);
    }
}
