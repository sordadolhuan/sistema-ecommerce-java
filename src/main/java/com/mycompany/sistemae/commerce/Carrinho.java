package com.mycompany.sistemae.commerce;
import java.util.List;
import java.util.ArrayList;

class Carrinho {
	private List<ItemCarrinho> itens;
	public Carrinho() {
		itens = new ArrayList<>();
	}
	public double calcularTotal() {
		double total = 0;
		for(ItemCarrinho item: itens) {
			total+= item.calcularSubtotal();
			
		}
		return total;
	}
	public void adicionarItem(Produto produto, int quantidade) {
		if(produto == null) {
			throw new IllegalArgumentException("Produto inválido!");
		}
		if(quantidade <= 0) {
			System.out.println("A Quantidade precisa ser maior que 0");
			return;
		}
		else if(quantidade >produto.getEstoque()) {
			System.out.println("A quantidade é maior do que a quantidade existente no estoque");
			return;
		}
		 
		
		for(ItemCarrinho item: itens) {
			if(item.getProduto().getCodigo() == produto.getCodigo()) {
				long novaQuantidade = (long)item.getQuantidade() + quantidade;

				if (novaQuantidade > produto.getEstoque()) {
				    System.out.println("Estoque insuficiente!");
				    return;
				}

				item.setQuantidade((int)(novaQuantidade));
				
				return;
				
			}
			
		}
		ItemCarrinho novo = new ItemCarrinho(produto, quantidade);
		itens.add(novo);
		
	}
	public void removerItem(int codigoProduto) {
		for(int i = 0; i<itens.size(); i++) {
			if(itens.get(i).getProduto().getCodigo() == codigoProduto) {
				itens.remove(i);
				return;
			}
			
		}
		System.out.println("Produto não encontrado no carrinho!");
	}
	public void exibirCarrinho() {
		if(itens.isEmpty()) {
			System.out.println("Carrinho vazio");
			return;
			
		}
		for(ItemCarrinho item: itens) {
			System.out.println("Produto: "+item.getProduto().getNome()+" Quantidade: "+item.getQuantidade()+" Subtotal R$"+item.calcularSubtotal());
			
		}
		System.out.printf("Total: R$ %.2f%n", calcularTotal());
	}
	public List<ItemCarrinho> getItens() {
            List<ItemCarrinho> copia = new ArrayList<>();

            for (ItemCarrinho item : itens) {
                ItemCarrinho novo = new ItemCarrinho(
                item.getProduto(),
                item.getQuantidade(),
                item.getPrecoUnitario()
            );

        copia.add(novo);
    }

        return copia;
}
        public void limparCarrinho() {
            itens.clear();
        }
}
