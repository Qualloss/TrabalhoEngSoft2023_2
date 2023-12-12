package trabalhofinal;

public class PodeEmprestarPosGraduacao implements PodeEmprestar {
    public boolean podeEmprestar(Livro livro, Usuario usu) {
        return (((livro.getQuantidade() > livro.getEmprestados() + livro.getReservas().size())
                && !usu.getEmprestimos().contains(livro) && !usu.devedor() && usu.emprestimosCheio())
                || (livro.getQuantidade() <= livro.getEmprestados() + livro.getReservas().size()
                        && (livro.getQuantidade() > livro.getEmprestados()) && usu.getReservas().contains(livro)
                        && !usu.getEmprestimos().contains(livro) && !usu.devedor() && usu.emprestimosCheio()));
    }
}
