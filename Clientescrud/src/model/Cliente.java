package model;

public class Cliente {
	
	protected String id;
	protected String nome;
	protected String cpfcnpj;
	protected String email;
	protected String telefone;
	protected String endereco;
	
	public Cliente() {
		
	}
	
	
	public Cliente(String id, String nome, String cpfcnpj, String email, String telefone, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfcnpj = cpfcnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpfcnpj() {
		return cpfcnpj;
	}


	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	

}
