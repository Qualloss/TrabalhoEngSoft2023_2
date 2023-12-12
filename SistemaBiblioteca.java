package trabalhofinal;

// Classe principal que inicia o sistema
public class SistemaBiblioteca {
        public static void main(String[] args) {
                // Criando alguns usuários e livros para teste
                Usuario u1 = new AlunoGraduacao("João da Silva", "123");
                Usuario u2 = new AlunoPosGraduacao("Luiz Fernando Rodrigues", "456");
                Usuario u3 = new Professor("Pedro Paulo", "789");
                Usuario u4 = new Professor("Carlos Lucena", "100");
                Usuario u5 = new AlunoGraduacao("Diego Quadros", "186");
                Livro l1 = new Livro("Engenharia de Software", "Ian Sommervile", 100, 6, "Adisson Wesley Profissional",
                                2000);
                Livro l2 = new Livro("UML - Guia do Usuário", "Grady Booch, James Rumbaugh, Ivar Jacobson", 101, 7,
                                "Campus", 2000);
                Livro l3 = new Livro("Code Complete", "Steve McConnell", 200, 2, "Microsoft Press", 2014);
                Livro l4 = new Livro("Agile Software Development,Principles,Patterns, and Practices", "Robert Martin",
                                201, 1,
                                "Prentice Hall", 2002);
                Livro l5 = new Livro("Refactoring: Improving the Design of Existing Code", "Martin Fowler", 300, 1,
                                "Addison-Wesley Professional", 1999);
                Livro l6 = new Livro("Software Metrics: A Rigorous and Pratical Approach",
                                "Norman Fenton, James Bieman", 301,
                                3, "CRC Press", 2014);
                Livro l7 = new Livro("Design Patterns: Elements of Reusable Object-Oriented Software",
                                "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 400, 1,
                                "Addison-Wesley Professional",
                                1994);
                Livro l8 = new Livro("UML Distiled: A Brief Guide to the Standard Object Modeling Language",
                                "Martin Fowler",
                                401, 3, "Addison-Wesley Professional", 2003);
                // Adicionando os usuários e livros ao sistema
                Facade facade = Facade.getInstancia();
                facade.biblioteca.addUsuario(u1);
                facade.biblioteca.addUsuario(u2);
                facade.biblioteca.addUsuario(u3);
                facade.biblioteca.addUsuario(u4);
                facade.biblioteca.addUsuario(u5);
                facade.biblioteca.addLivro(l1);
                facade.biblioteca.addLivro(l1);
                facade.biblioteca.addLivro(l2);
                facade.biblioteca.addLivro(l3);
                facade.biblioteca.addLivro(l4);
                facade.biblioteca.addLivro(l5);
                facade.biblioteca.addLivro(l5);
                facade.biblioteca.addLivro(l7);
                facade.biblioteca.addLivro(l7);
                facade.biblioteca.addLivro(l1);
                facade.biblioteca.addLivro(l1);
                facade.biblioteca.addLivro(l2);
                facade.biblioteca.addLivro(l3);
                facade.biblioteca.addLivro(l4);
                facade.biblioteca.addLivro(l5);
                facade.biblioteca.addLivro(l6);
                facade.biblioteca.addLivro(l7);
                facade.biblioteca.addLivro(l8);
                // Criando o leitor de comandos e iniciando a leitura
                LeitorComandos leitor = new LeitorComandos();
                leitor.lerComandos();
        }
}
