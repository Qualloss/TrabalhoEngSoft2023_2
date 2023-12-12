package trabalhofinal;

// Classe que representa um comando de reserva
class ComandoReserva extends Comando {
    private Usuario usuario;
    private Livro livro;

    public ComandoReserva(Usuario usuario, Livro livro) {
        this.facade = Facade.getInstancia();
        this.usuario = usuario;
        this.livro = livro;
    }

    // Método que executa o comando de reserva
    @Override
    public void executar() {
        facade.reservar(usuario, livro);
    }
}
