package trabalhofinal;

// Classe que representa um aluno de graduação
class AlunoGraduacao extends Usuario {

    public AlunoGraduacao(String nome, String matricula) {
        super(nome, matricula);
        podeEmprestar = new PodeEmprestarGraduacao();
        inadimplente = new DevedorGraduacao();
        emprestimoLotado = new EmprestimoCheioGraduacao();
        limiteDias = 3;
    }

}
