package trabalhofinal;

import java.util.*;

// Classe que representa o leitor de comandos
class LeitorComandos {
    private Scanner scanner;
    private Facade facade;

    public LeitorComandos() {
        scanner = new Scanner(System.in);
        facade = Facade.getInstancia();
    }

    // Método que lê os comandos do console e os executa
    public void lerComandos() {
        while (true) {
            System.out.print("> ");
            String linha = scanner.nextLine();
            String[] partes = linha.split(" ");
            String comando = partes[0];
            Comando c = null;
            switch (comando) {
                case "emp":
                    Usuario usuario = facade.biblioteca.getUsuario(partes[1]);
                    Livro livro = facade.biblioteca.getLivro(Integer.parseInt(partes[2]));
                    c = new ComandoEmprestimo(usuario, livro);
                    break;
                case "dev":
                    usuario = facade.biblioteca.getUsuario(partes[1]);
                    livro = facade.biblioteca.getLivro(Integer.parseInt(partes[2]));
                    c = new ComandoDevolucao(usuario, livro);
                    break;
                case "res":
                    usuario = facade.biblioteca.getUsuario(partes[1]);
                    livro = facade.biblioteca.getLivro(Integer.parseInt(partes[2]));
                    c = new ComandoReserva(usuario, livro);
                    break;
                case "usu":
                    String requerente = partes[1];
                    c = new ComandoConsulta("usuario", requerente);
                    break;
                case "liv":
                    String book = partes[1];
                    c = new ComandoConsulta("livro", book);
                    break;
                case "obs":
                    Professor professor = (Professor) facade.biblioteca.getUsuario(partes[1]);
                    livro = facade.biblioteca.getLivro(Integer.parseInt(partes[2]));
                    c = new ComandoObservacao(professor, livro);
                    break;
                case "ntf":
                    Professor professorNtf = (Professor) facade.biblioteca.getUsuario(partes[1]);
                    c = new ComandoNotifica(professorNtf);
                    break;
                case "sai":
                    System.out.println("Saindo do sistema.");
                    return;
                default:
                    System.out.println("Comando inválido.");
            }
            if (c != null) {
                c.executar();
            }
        }
    }
}
