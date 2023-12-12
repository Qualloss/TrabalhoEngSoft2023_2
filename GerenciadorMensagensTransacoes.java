package trabalhofinal;

public class GerenciadorMensagensTransacoes {

    public static String usu = "O usuário: ";

    public static void emprestimoRealizado(Livro livro, Usuario usuario) {
        System.out.println(usu + usuario.getNome() + " realizou o empréstimo do livro: " + livro.getTitulo() + ".");
    }

    public static void recusaEmprestimo(Livro livro, Usuario usuario) {
        if (usuario.getEmprestimos().contains(livro)) {
            System.out.println(
                    usu + usuario.getNome() + " não pôde realizar o empréstimo pois já possui o livro: "
                            + livro.getTitulo()
                            + " em seus empréstimos.");
        } else if (livro.getQuantidade() <= livro.getReservas().size() + livro.getEmprestados()) {
            System.out.println(
                    usu + usuario.getNome() + " não pôde realizar o empréstimo do livro: " + livro.getTitulo()
                            + " pois não há exemplares disponíveis para empréstimo.");
        } else if (!usuario.emprestimosCheio()) {
            System.out.println(
                    usu + usuario.getNome() + " não pôde realizar o empréstimo do livro:"
                            + livro.getTitulo()
                            + " pois o usuário já atingiu seu limite de empréstimos.");
        } else if (usuario.devedor()) {
            System.out.println(
                    usu + usuario.getNome()
                            + " não pôde realizar o empréstimo pois está com exemplares ativos atrasados.");
        }
    }

    public static void reservaRealizada(Livro livro, Usuario usuario) {
        System.out.println(usu + usuario.getNome() + " reservou com sucesso o livro: " + livro.getTitulo() + ".");
    }

    public static void recusaReserva(Livro livro, Usuario usuario) {
        if (usuario.getReservas().size() >= 3) {
            System.out.println(
                    usu + usuario.getNome() + " não pôde realizar a reserva do livro: " + livro.getTitulo()
                            + " pois já atingiu sua cota máxima de reservas permitidas.");
        } else if (usuario.getReservas().contains(livro)) {
            System.out.println(
                    usu + usuario.getNome() + " não pôde realizar a reserva do livro: " + livro.getTitulo()
                            + " pois já existe uma reserva pendente deste livro para o usuário.");
        } else if (usuario.getEmprestimos().contains(livro)) {
            System.out.println(
                    usu + usuario.getNome() + " não pôde realizar a reserva do livro :" + livro.getTitulo()
                            + " pois o mesmo já se encontra emprestado para o usuário.");
        }

    }

    public static void devolucaoRealizada(Livro livro, Usuario usuario) {
        System.out.println(usu + usuario.getNome() + " devolveu com sucesso o livro : " + livro.getTitulo() + ".");
    }

    public static void recusaDevolucao(Livro livro, Usuario usuario) {
        System.out.println(usu + usuario.getNome() + " não devolveu com sucesso o livro : " + livro.getTitulo()
                + " pois o mesmo não possui um empréstimo ativo da obra.");
    }

    public static void observacaoRealizada(Livro livro, Professor professor) {
        System.out.println("O professor : " + professor.getNome() + " se registrou como observador do livro "
                + livro.getTitulo() + ".");
    }

    public static void confirmacaoNotificado(Professor professor) {
        System.out.println(
                "O professor: " + professor.getNome() + " foi notificado " + professor.getNotificacoesObservacoes()
                        + " vezes para livros que observa.");
    }
}
