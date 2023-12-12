package trabalhofinal;

import java.time.LocalDate;

public class Facade {

    private static Facade instancia;

    Biblioteca biblioteca = Biblioteca.getInstancia();

    public static Facade getInstancia() {
        if (instancia == null) {
            instancia = new Facade();
        }
        return instancia;
    }

    public void emprestar(Usuario usuario, Livro livro) {
        if (!biblioteca.getUsuarios().containsValue(usuario)) {
            GerenciadorMensagensNaoEncontrado.usuarioNaoEncontrado();
        } else if (!biblioteca.getLivros().containsValue(livro)) {
            GerenciadorMensagensNaoEncontrado.livroNaoEncontrado();
        } else {
            if (usuario.emprestavel(livro)) {
                if (usuario.getReservas().contains(livro)) {
                    usuario.removeReserva(livro);
                    usuario.addReservaHistorico(livro);
                }
                livro.addEmprestimo(usuario);
                usuario.addEmprestimo(livro, LocalDate.now());
                GerenciadorMensagensTransacoes.emprestimoRealizado(livro, usuario);
            } else {
                GerenciadorMensagensTransacoes.recusaEmprestimo(livro, usuario);
            }
        }
    }

    public void devolver(Usuario usuario, Livro livro) {
        if (!biblioteca.getUsuarios().containsValue(usuario)) {
            GerenciadorMensagensNaoEncontrado.usuarioNaoEncontrado();
        } else if (!biblioteca.getLivros().containsValue(livro)) {
            GerenciadorMensagensNaoEncontrado.livroNaoEncontrado();
        } else {
            if (usuario.podeDevolver(livro)) {
                usuario.removeEmprestimo(livro);
                livro.removeEmprestimo(usuario);
                usuario.addEmprestimoHistorico(livro, LocalDate.now());
                GerenciadorMensagensTransacoes.devolucaoRealizada(livro, usuario);
            } else {
                GerenciadorMensagensTransacoes.recusaDevolucao(livro, usuario);
            }
        }
    }

    public void reservar(Usuario usuario, Livro livro) {
        if (!biblioteca.getUsuarios().containsValue(usuario)) {
            GerenciadorMensagensNaoEncontrado.usuarioNaoEncontrado();
        } else if (!biblioteca.getLivros().containsValue(livro)) {
            GerenciadorMensagensNaoEncontrado.livroNaoEncontrado();
        } else {
            if (usuario.podeReservar(livro)) {
                usuario.addReserva(livro, LocalDate.now());
                livro.addReserva(usuario);
                GerenciadorMensagensTransacoes.reservaRealizada(livro, usuario);
                // Se houver mais de duas reservas, os observadores são notificados[^3^][3]
                if (livro.getReservas().size() > 2) {
                    livro.notificarObservadores();
                }
            } else {
                GerenciadorMensagensTransacoes.recusaReserva(livro, usuario);
            }
        }
    }

    public void observar(Professor professor, Livro livro) {
        professor.addObservacao(livro);
        livro.registrarObservador(professor);
        GerenciadorMensagensTransacoes.observacaoRealizada(livro, professor);
    }

    public void quantidadeNotificacao(Professor professor) {
        GerenciadorMensagensTransacoes.confirmacaoNotificado(professor);
    }

    public void consultar(String tipo, String parametro) {
        if (tipo.equals("livro")) {
            Livro livro = biblioteca.getLivros().get(Integer.parseInt(parametro));
            if (livro != null) {
                GerenciadorMensagensConsulta.boasVindasLivro(livro);
                GerenciadorMensagensConsulta.retornaReservasLivro(livro);
                GerenciadorMensagensConsulta.retornaStatusLivros(livro);
            } else {
                GerenciadorMensagensConsulta.bibliotecaSemLivro();
            }

        }

        else if (tipo.equals("usuario"))

        {
            Usuario usuario = biblioteca.getUsuarios().get(parametro);
            if (usuario != null) {
                GerenciadorMensagensConsulta.boasVindasUsuario(usuario);
                GerenciadorMensagensConsulta.retornarEmprestimoUsuarios(usuario);
                GerenciadorMensagensConsulta.retornarReservasUsuarios(usuario);
                if (usuario instanceof Professor) {
                    System.out.println("Observações: " + ((Professor) usuario).getObservacoes().size());
                }
            } else {
                GerenciadorMensagensConsulta.bibliotecaSemUsuario();
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }
}
