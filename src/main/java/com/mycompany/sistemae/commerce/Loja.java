
package com.mycompany.sistemae.commerce;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Loja {
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private List<Pedido<Integer>> pedidos;

    public Loja() {
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    public void cadastrarProduto(Produto produto){
        if(produto == null){
            throw new IllegalArgumentException("Produto inválido!");
        }
        for(Produto p: produtos ){
        if(p.getCodigo()==produto.getCodigo()){
            System.out.println("Já existe um produto com esse código");
            return;
        }
    }
        produtos.add(produto);
        
    }
    public void cadastrarCliente(Cliente cliente){
        if(cliente == null){
           throw new IllegalArgumentException("Cliente inválido!"); 
        }
       
        for(Cliente c: clientes){
            if (c.getCpf().equals(cliente.getCpf())) {
                System.out.println("CPF já cadastrado!");
                return;
                
                }
            else if(c.getIdCliente() == cliente.getIdCliente()) {
                System.out.println("ID de cliente já cadastrado!");
                return;
                }
        }
        clientes.add(cliente);
    }
    public void listarProdutos() {
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto registrado");
            return;
        }
        for(Produto p: produtos){
            System.out.println(p.exibirInformacoes());
        }
}
    public void listarClientesOrdenados() {
        if(clientes.isEmpty()){
            System.out.println("Nenhum cliente registrado");
            return;
        }
        List<Cliente> ordenados = new ArrayList<>(clientes);
        Collections.sort(ordenados);
        for(Cliente c: ordenados){
            System.out.println(c.exibirInformacoes());
        }
    }
    public boolean registrarPedido(Pedido<Integer> pedido){
        if(pedido == null){
            System.out.println("Pedido inexistente");
            return false;
        }
        for(Pedido<Integer> p: pedidos){
            if(p.getNumeroPedido().equals(pedido.getNumeroPedido())){
                System.out.println("Pedido já cadastrado");
                return false;
            }
            
        }
        pedidos.add(pedido);
        return true;
    }
    public void listarPedidos() {
        if(pedidos.isEmpty()){
            System.out.println("Nenhum pedido cadastrado");
            return;
        }
        for(Pedido<Integer> p: pedidos){
            p.exibirPedido();
        }
    }
    public void finalizarCompra(int numeroPedido, Cliente cliente, Carrinho carrinho) {
        if (cliente == null || carrinho == null) {
            System.out.println("Cliente ou carrinho inválido!");
            return;
    }
        boolean clienteCadastrado = false;
        
        for (Cliente c : clientes) {
            if (c == cliente) {
                clienteCadastrado = true;
                break;
                }
        }

            if (!clienteCadastrado) {
            System.out.println("Cliente não cadastrado!");
            return;
        }
        List<ItemCarrinho> itensCompra = carrinho.getItens();    
        if (itensCompra.isEmpty()) {
            System.out.println("Não é possível finalizar um carrinho vazio!");
            return;
    }
        for(Pedido<Integer> p: pedidos){
            if(p.getNumeroPedido().equals(numeroPedido)){
                System.out.println("O pedido já existe");
                return;
            }
            
          
        }
        
        for (ItemCarrinho item : itensCompra) {
            boolean produtoCadastrado = false;

            for (Produto p : produtos) {
                if (p == item.getProduto()) {
                    produtoCadastrado = true;
                    break;
                }
            }

            if (!produtoCadastrado) {
                System.out.println("Produto não cadastrado!");
                return;
}
            if (item.getQuantidade() > item.getProduto().getEstoque()) {
                System.out.println("Estoque insuficiente para: " + item.getProduto().getNome());
                return;
}
        }
        Pedido<Integer> novoPedido = new Pedido<>(numeroPedido, cliente, itensCompra);
        for (ItemCarrinho item : itensCompra) {
            Produto p = item.getProduto();
            boolean sucesso = p.reduzirEstoque(item.getQuantidade());
            if(!sucesso){
                System.out.println("Falha ao reduzir estoque!");
                return;
            }
        }
        boolean registrado = registrarPedido(novoPedido);

        if (!registrado) {
            System.out.println("Não foi possível registrar o pedido!");
            return;
        }

        carrinho.limparCarrinho();
        System.out.println("A Compra foi finalizada com Sucesso!");
    

    
        
        
    }
    public Produto buscarProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }

        return null;
}
    public Cliente buscarCliente(int id) {
    for (Cliente c : clientes) {
        if (c.getIdCliente() == id) {
            return c;
        }
    }
    return null;
}
}
