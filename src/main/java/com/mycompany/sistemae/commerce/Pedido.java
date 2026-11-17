
package com.mycompany.sistemae.commerce;
import java.util.List;
import java.util.ArrayList;

class Pedido<T> {
    private T numeroPedido;
    private Cliente cliente;
    private List<ItemCarrinho> itens;
    private double valorTotal;

    public Pedido(T numeroPedido, Cliente cliente, List<ItemCarrinho> itens) {
        if (numeroPedido == null || cliente == null || itens == null || itens.isEmpty()) {
        throw new IllegalArgumentException("Dados do pedido inválidos!");
        }
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        for (ItemCarrinho item : itens) {
            ItemCarrinho novo = new ItemCarrinho(item.getProduto(), item.getQuantidade(), item.getPrecoUnitario());
            this.itens.add(novo);
        }
        this.valorTotal = calcularTotal();
    }
    private double calcularTotal() {
		double total = 0;
		for(ItemCarrinho item: itens) {
			total+= item.calcularSubtotal();
			
		}
		return total;
	}

    public T getNumeroPedido() {
        return numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemCarrinho> getItens() {
        List<ItemCarrinho> copia = new ArrayList<>();
        

    for (ItemCarrinho item : itens) {
        copia.add(new ItemCarrinho(
            item.getProduto(),
            item.getQuantidade(),
            item.getPrecoUnitario()
        ));
    }

    return copia;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public void exibirPedido() {
        System.out.println("Pedido: " + numeroPedido);
        System.out.println("Cliente: "+cliente.getNome());
        for(ItemCarrinho item: itens){
            
            System.out.printf("Produto: %s | Quantidade: %d | Subtotal: %.2f%n", item.getProduto().getNome(), item.getQuantidade(), item.calcularSubtotal());
            
        }
        System.out.printf("Total: R$%.2f%n", valorTotal);
}
    
}
