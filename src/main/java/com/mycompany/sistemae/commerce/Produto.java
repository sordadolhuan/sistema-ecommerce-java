
package com.mycompany.sistemae.commerce;


class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(int codigo, String nome, double preco, int estoque) {
        setCodigo(codigo);
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("O código deve ser positivo!");
        }

        this.codigo = codigo;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto inválido!");
        }

        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (!Double.isFinite(preco) || preco < 0) {
            throw new IllegalArgumentException("Preço inválido!");
        }

        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo!");
        }

        this.estoque = estoque;
    }
   
    boolean reduzirEstoque(int quantidade){
        if(quantidade <= 0){
            System.out.println("A quantidade deve ser maior que 0");
            return false;
        }
        else if(quantidade > estoque){
            System.out.println("Estoque insuficiente");
            return false;
        }
        estoque = estoque - quantidade;
        return true;
    }

    
    public String exibirInformacoes() {
        return "Código= " + codigo + "\nNome= " + nome + "\nPreço= " + preco + "\nEstoque= " + estoque;
    }
    
}
