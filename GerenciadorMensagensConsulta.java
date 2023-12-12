package trabalhofinal;

public class GerenciadorMensagensConsulta {
    public static void boasVindasLivro(Livro livro) {
        System.out.println("Informações sobre o livro:");
        System.out.println("Título: " + livro.getTitulo());
    }

    public static void retornaReservasLivro(Livro livro) {
        if (livro.getReservas().isEmpty()) {
            System.out.println("Quantidade de reservas: " + livro.getReservas().size());
        } else {
            System.out.println("Quantidade de reservas: " + livro.getReservas().size() + "\n"
                    + "Os usuários que fizeram reserva são:");
            for (Usuario usuario : livro.getReservas()) {
                System.out.println(usuario.getNome());
            }
        }
    }

    public static void retornaStatusLivros(Livro livro) {
        for (Usuario usu : livro.getEmprestimos()) {
            System.out.println(
                    "Código do livro: " + livro.getCodigo() + " || Disponibilidade: Emprestado || Locatário: "
                            + usu.getNome() + " || Data de empréstimo: " + usu.emprestimos.get(livro)
                            + " || Data de devolução: "
                            + usu.emprestimos.get(livro).plusDays(usu.limiteDias));
        }
        for (int i = 0; i < livro.getQuantidade() - livro.getEmprestados(); i++) {
            System.out.println(
                    "Código do livro: " + livro.getCodigo() + " || Disponibilidade: Disponível.");
        }
    }

    public static void bibliotecaSemLivro() {
        System.out.println("Livro não encontrado.");
    }

    public static void boasVindasUsuario(Usuario usuario) {
        System.out.println("Informações sobre o usuário:");
        System.out.println("Nome: " + usuario.getNome());
    }

    public static void retornarEmprestimoUsuarios(Usuario usuario) {
        if (usuario.getEmprestimos().isEmpty()) {
            System.out.println("O usuário: " + usuario.getNome() + " não possui empréstimos ativos.");
        } else {
            System.out.println("O usuário: " + usuario.getNome() + " possui os seguintes empréstimos ativos:");
            for (Livro livro : usuario.getEmprestimos()) {
                System.out.println(
                        "Título do livro: " + livro.getTitulo() + " || Data de empréstimo: "
                                + usuario.emprestimos.get(livro)
                                + " || Empréstimo: em curso || Data prevista de devolução: "
                                + usuario.emprestimos.get(livro).plusDays(usuario.limiteDias));
            }
        }
        if (usuario.getEmprestimosHistorico().isEmpty()) {
            System.out.println("O usuário: " + usuario.getNome() + " não possui empréstimos finalizados.");
        } else {
            System.out.println("O usuário: " + usuario.getNome() + " possui os seguintes empréstimos finalizados:");
            for (Livro livro : usuario.getEmprestimosHistorico()) {
                System.out.println(
                        "Título do livro: " + livro.getTitulo() + " || Data de devolução: "
                                + usuario.historicoEmprestimos.get(livro)
                                + " || Empréstimo: finalizado||");
            }
        }
    }

    public static void retornarReservasUsuarios(Usuario usuario) {
        if (usuario.getReservas().isEmpty()) {
            System.out.println("O usuário: " + usuario.getNome() + " não possui reservas ativas.");
        } else {
            System.out.println("O usuário: " + usuario.getNome() + " possui as seguintes reservas ativas: ");
            for (Livro livro : usuario.getReservas()) {
                System.out.println(
                        "Título do livro: " + livro.getTitulo() + " || Data da efetuação da reserva: "
                                + usuario.reservas.get(livro)
                                + " || Reserva: em curso.");
            }
        }
        if (usuario.getReservasHistorico().isEmpty()) {
            System.out.println("O usuário: " + usuario.getNome() + " não possui reservas finalizadas.");
        } else {
            System.out.println("O usuário: " + usuario.getNome() + " possui as seguintes reservas finalizadas:");
            for (Livro livro : usuario.getReservasHistorico()) {
                System.out.println(
                        "Título do livro: " + livro.getTitulo() + " || Data do fim da reserva: "
                                + usuario.historicoReservas.get(livro)
                                + " || Reserva: finalizada.");
            }
        }
    }

    public static void bibliotecaSemUsuario() {
        System.out.println("Usuário não encontrado.");
    }
}
