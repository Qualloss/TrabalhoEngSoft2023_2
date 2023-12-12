package trabalhofinal;

// Classe que representa um aluno de pós-graduação
class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String nome, String matricula) {
        super(nome, matricula);
        podeEmprestar = new PodeEmprestarPosGraduacao();
        inadimplente = new DevedorPosGraduacao();
        emprestimoLotado = new EmprestimoCheioPosGraduacao();
        limiteDias = 4;
    }
}
