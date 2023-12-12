package trabalhofinal;

public class EmprestimoCheioPosGraduacao implements EmprestimoCheio {
    public boolean emprestimoCheio(Usuario usuario) {
        return usuario.emprestimos.size() < 4;
    }
}
