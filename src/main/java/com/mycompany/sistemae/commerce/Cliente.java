package com.mycompany.sistemae.commerce;

class Cliente extends Pessoa implements Comparable<Cliente> {
	private int idCliente;
	private String email;
	public Cliente(String nome, String cpf, int idCliente, String email) {
		super(nome, cpf);
		this.idCliente = idCliente;
		this.email = email;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String exibirInformacoes() {
		
		return super.exibirInformacoes()+"\nID do Cliente: "+idCliente+"\nEmail: "+email;
		
	}
        @Override
        public int compareTo(Cliente outro) {
            return this.getNome().compareToIgnoreCase(outro.getNome());
        }
	
}