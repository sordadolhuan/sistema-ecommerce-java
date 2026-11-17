
package com.mycompany.sistemae.commerce;

import java.util.Scanner;
public class Teste {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Loja loja = new Loja();
        Produto produto1 = new Produto(101, "Camiseta", 50.0, 10);
        Produto produto2 = new Produto(102, "Calça", 120.0, 5);
        Produto produto3 = new Produto(103, "Tênis", 250.0, 8);
        loja.cadastrarProduto(produto1);
        loja.cadastrarProduto(produto2);
        loja.cadastrarProduto(produto3);
        
        Cliente cliente1 = new Cliente("Maria", "52998224725", 1, "maria@email.com");
        Cliente cliente2 = new Cliente("João", "11144477735", 2, "joao@email.com");
        Cliente cliente3 = new Cliente("Lhuan", "12345678909", 3, "lhuanbc@gmail.com");
        Cliente cliente4 = new Cliente("Ian", "12347890901", 4, "ian@eail.com");
        loja.cadastrarCliente(cliente1);
        loja.cadastrarCliente(cliente2);
        loja.cadastrarCliente(cliente3);
        loja.cadastrarCliente(cliente4);
        Pessoa pessoa = cliente1;

        System.out.println("\n=== TESTE DE POLIMORFISMO ===");
        System.out.println(pessoa.exibirInformacoes());
        
        System.out.println("\n===== BEM-VINDO À LOJA VIRTUAL =====");

        System.out.println("\n=== CLIENTES CADASTRADOS ===");

        loja.listarClientesOrdenados();
        
        

       
        
        System.out.println("\n=== IDENTIFICAÇÃO DO CLIENTE ===");

        Cliente clienteEscolhido = null;

        while (clienteEscolhido == null) {
            System.out.print("Digite o ID do cliente: ");

            if (!sc.hasNextInt()) {
                System.out.println("Digite um número válido!");
                sc.next();
                continue;
            }

            int idCliente = sc.nextInt();
            clienteEscolhido = loja.buscarCliente(idCliente);

            if (clienteEscolhido == null) {
                System.out.println("Cliente não encontrado! Tente novamente.");
            }
        }
        System.out.println("Bem-vindo(a), " + clienteEscolhido.getNome() + "!");


        
        
        Carrinho carrinhoInterativo = new Carrinho();
        String continuar = "S";
        while (continuar.equalsIgnoreCase("S")){
            System.out.println("=== PRODUTOS DISPONÍVEIS ===");
            loja.listarProdutos();

            System.out.print("Digite o código do produto: ");
            if (!sc.hasNextInt()) {
            System.out.println("Código inválido!");
            sc.next();
            continue;
        }

            int codigo = sc.nextInt();

            Produto escolhido = loja.buscarProduto(codigo);

            if (escolhido == null) {
                System.out.println("Produto não encontrado!");
            }
            else {
                System.out.print("Digite a quantidade: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Quantidade inválida!");
                    sc.next();
                    continue;
                }

                int quantidade = sc.nextInt();

                carrinhoInterativo.adicionarItem(escolhido, quantidade);
                carrinhoInterativo.exibirCarrinho();
        }
            System.out.print("Deseja continuar comprando? (S/N): ");
            continuar = sc.next();
            while (!continuar.equalsIgnoreCase("S") && !continuar.equalsIgnoreCase("N")) {
                System.out.println("Resposta inválida! Digite S ou N.");
                continuar = sc.next();
}
            
    }
        System.out.println("\n=== RESUMO DO CARRINHO ===");
        carrinhoInterativo.exibirCarrinho();
        System.out.print("Deseja finalizar a compra? (S/N): ");
        String confirmar = sc.next();
        while (!confirmar.equalsIgnoreCase("S") && !confirmar.equalsIgnoreCase("N")) {
            System.out.print("Resposta inválida! Digite S ou N: ");
            confirmar = sc.next();
}

        if (confirmar.equalsIgnoreCase("S")) {
            loja.finalizarCompra(1001, clienteEscolhido, carrinhoInterativo);
            
            
        } 
        else {
            System.out.println("Compra não finalizada!");
        }
        System.out.println("\n=== PEDIDOS REGISTRADOS ===");
        loja.listarPedidos();

        System.out.println("\n=== ESTOQUE ATUAL ===");
        loja.listarProdutos();
        testarExcecao();
    }
    
    
    
    
        public static void testarExcecao() {
        System.out.println("\n=== TESTE DE VALIDAÇÃO DE PRODUTO ===");

        try {
            Produto invalido = new Produto(104, "Notebook", -2000, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro tratado: " + e.getMessage());
        }

}
}