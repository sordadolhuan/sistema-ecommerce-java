
package com.mycompany.sistemae.commerce;

import java.util.Scanner;

public abstract class Pessoa implements Verificavel {

    private String nome;
    private String cpf;

    // Construtor com parâmetros
    public Pessoa(String nome, String cpf) {
        this.nome = nome;

        if (validar(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido!");
            solicitarNovo();
        }
    }

    // Construtor sem parâmetros
    public Pessoa() {

    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        if (validar(cpf)) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido!");
            solicitarNovo();
        }
    }

    // Métodos da interface
    @Override
    public boolean validar(String codigo) {
        if (codigo == null) {
            return false;
        }

        return codigo.matches("\\d{11}");
    }

    @Override
    public void solicitarNovo() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite um novo CPF: ");
        String novoCpf = entrada.nextLine();

        while (!validar(novoCpf)) {
            System.out.println("CPF inválido!");
            System.out.print("Digite outro CPF: ");
            novoCpf = entrada.nextLine();
        }

        this.cpf = novoCpf;
        System.out.println("CPF cadastrado!");
    }

    public String exibirInformacoes() {
        return "Nome: " + nome + "\nCPF: " + cpf;
    }
}
