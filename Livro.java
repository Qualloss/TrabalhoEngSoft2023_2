package trabalhofinal;

import java.util.*;

// Classe que representa um livro
class Livro implements Subject {
    private String titulo;
    private String autor;
    private String editora;
    private int edicao;
    private int codigo;
    private int quantidade;
    private int ano;

    public int getAno() {
        return ano;
    }

    private List<Usuario> emprestimos;
    private List<Usuario> reservas;
    private List<Observador> observadores;

    public Livro(String titulo, String autor, int codigo, int edicao, String editora, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.codigo = codigo;
        this.ano = ano;
        this.quantidade = 0;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getEditora() {
        return this.editora;
    }

    public int getEdicao() {
        return this.edicao;
    }

    public int getEmprestados() {
        return emprestimos.size();
    }

    public List<Usuario> getEmprestimos() {
        return this.emprestimos;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void addExemplar(int exemplares) {
        this.quantidade += exemplares;
    }

    public List<Usuario> getReservas() {
        return this.reservas;
    }

    public void addEmprestimo(Usuario usuario) {
        emprestimos.add(usuario);
    }

    public void removeEmprestimo(Usuario usuario) {
        emprestimos.remove(usuario);
    }

    public void addReserva(Usuario usuario) {
        reservas.add(usuario);
    }

    public void removeReserva(Usuario usuario) {
        reservas.remove(usuario);
    }

    public boolean isDisponivel() {
        return this.quantidade > this.emprestimos.size();
    }

    public List<Observador> getObservadores() {
        return this.observadores;
    }

    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.update(this);
        }
    }
}
