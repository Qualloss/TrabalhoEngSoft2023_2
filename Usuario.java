package trabalhofinal;

import java.util.*;
import java.time.LocalDate;

// Classe que representa um usuário
abstract class Usuario {
    protected String nome;
    protected String matricula;
    protected Map<Livro, LocalDate> emprestimos;
    protected Map<Livro, LocalDate> reservas;
    protected Map<Livro, LocalDate> historicoEmprestimos;
    protected Map<Livro, LocalDate> historicoReservas;
    protected Set<Livro> setOfKeys;
    protected Iterator<Livro> itr;
    protected int dias;
    protected PodeEmprestar podeEmprestar;
    protected Devedor inadimplente;
    protected EmprestimoCheio emprestimoLotado;
    int limiteDias;

    protected Usuario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.emprestimos = new HashMap<>();
        this.reservas = new HashMap<>();
        this.historicoEmprestimos = new HashMap<>();
        this.historicoReservas = new HashMap<>();
        this.setOfKeys = emprestimos.keySet();
        this.itr = setOfKeys.iterator();
        this.dias = 0;
    }

    public LocalDate getDataEmprestimo(Livro livro) {
        return this.emprestimos.get(livro);
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public Set<Livro> getEmprestimos() {
        return this.emprestimos.keySet();
    }

    public Set<Livro> getEmprestimosHistorico() {
        return this.historicoEmprestimos.keySet();
    }

    public int getQuantidadeEmprestimos() {
        return this.emprestimos.size();
    }

    public void addEmprestimo(Livro livro, LocalDate data) {
        this.emprestimos.put(livro, data);
    }

    public void addEmprestimoHistorico(Livro livro, LocalDate data) {
        this.historicoEmprestimos.put(livro, data);
    }

    public void removeEmprestimo(Livro livro) {
        this.emprestimos.remove(livro);
    }

    public Set<Livro> getReservas() {
        return this.reservas.keySet();
    }

    public Set<Livro> getReservasHistorico() {
        return this.historicoReservas.keySet();
    }

    public boolean emprestavel(Livro livro) {
        return podeEmprestar.podeEmprestar(livro, this);
    }

    public boolean devedor() {
        return inadimplente.devedor(this);
    }

    public void addReserva(Livro livro, LocalDate data) {
        this.reservas.put(livro, data);
    }

    public void addReservaHistorico(Livro livro) {
        this.historicoReservas.put(livro, LocalDate.now());
    }

    public void removeReserva(Livro livro) {
        this.reservas.remove(livro);
        livro.removeReserva(this);
    }

    public boolean emprestimosCheio() {
        return emprestimoLotado.emprestimoCheio(this);
    }

    public boolean podeDevolver(Livro livro) {
        return getEmprestimos().contains(livro);
    }

    public boolean podeReservar(Livro livro) {
        return getReservas().size() < 3 && !getEmprestimos().contains(livro) && !getReservas().contains(livro);
    }
}
