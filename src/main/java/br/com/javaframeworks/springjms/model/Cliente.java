package br.com.javaframeworks.springjms.model;

/**
 * Bean utilizado como exemplo
 * 
 * @author Wagner Rondon - Java Frameworks
 *
 */
public class Cliente {

	private Long id;
	private String nome;
	private String sobreNome;
	private String email;
	
	
	public Cliente(Long id, String nome, String sobreNome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email + "]";
	}
	
}
