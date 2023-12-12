package trabalhofinal;

import java.util.*;

// Classe que representa a fachada do sistema de biblioteca
class Biblioteca {
    private static Biblioteca instancia;
    private Map<String, Usuario> usuarios;
    private Map<Integer, Livro> livros;

    private Biblioteca() {
        usuarios = new HashMap<>();
        livros = new HashMap<>();
    }

    // Método que retorna a única instância da classe (Singleton)
    public static Biblioteca getInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public Usuario getUsuario(String matricula) {
        return usuarios.get(matricula);
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public Livro getLivro(int codigo) {
        return livros.get(codigo);
    }

    public Map<Integer, Livro> getLivros() {
        return livros;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.put(usuario.getMatricula(), usuario);
    }

    public void addLivro(Livro livro) {
        if (!livros.containsKey(livro.getCodigo())) {
            livros.put(livro.getCodigo(), livro);
            livro.addExemplar(1);
        } else {
            getLivro(livro.getCodigo()).addExemplar(1);
        }
    }
}
