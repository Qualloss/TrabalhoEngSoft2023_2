package trabalhofinal;
// interface que define o comportamento de um assunto (quem notifica o observador)
public interface Subject {
	public void registrarObservador(Observador o);
	public void removerObservador(Observador o);
	public void notificarObservadores();
}