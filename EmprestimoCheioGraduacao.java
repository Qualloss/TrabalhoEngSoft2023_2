package trabalhofinal;

public class EmprestimoCheioGraduacao implements EmprestimoCheio {
    public boolean emprestimoCheio(Usuario usuario) {
        return usuario.emprestimos.size() < 3;
    }
}
