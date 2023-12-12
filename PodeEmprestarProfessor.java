package trabalhofinal;

public class PodeEmprestarProfessor implements PodeEmprestar {
    public boolean podeEmprestar(Livro livro, Usuario usu) {
        return livro.getQuantidade() > livro.getEmprestados() && !usu.devedor()
                && !usu.getEmprestimos().contains(livro);
    }
}
