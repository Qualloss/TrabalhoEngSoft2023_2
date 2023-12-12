package trabalhofinal;

import java.util.*;

// Classe que representa um professor
class Professor extends Usuario implements Observador {
    private List<Livro> observacoes;
    private int notificacoesObservacoes;

    public Professor(String nome, String matricula) {
        super(nome, matricula);
        this.observacoes = new ArrayList<>();
        this.notificacoesObservacoes = 0;
        podeEmprestar = new PodeEmprestarProfessor();
        inadimplente = new DevedorProfessor();
        emprestimoLotado = new EmprestimoCheioProfessor();
        limiteDias = 7;
    }

    @Override
    public void update(Livro livro) {
        this.notificacoesObservacoes += 1;
        System.out.println("O professor " + getNome() + " foi notificado que o livro " + livro.getTitulo()
                + " tem mais de duas reservas.");
    }

    public int getNotificacoesObservacoes() {
        return this.notificacoesObservacoes;
    }

    public List<Livro> getObservacoes() {
        return this.observacoes;
    }

    public void addObservacao(Livro livro) {
        this.observacoes.add(livro);
    }

    public void removeObservacao(Livro livro) {
        this.observacoes.remove(livro);
    }
}
