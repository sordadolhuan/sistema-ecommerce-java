package com.mycompany.sistemae.commerce;

class ItemCarrinho {
	private Produto produto;
	private int quantidade;
        private double precoUnitario;
	public ItemCarrinho(Produto produto, int quantidade) {
		if (produto == null) {
	        throw new IllegalArgumentException("Produto não pode ser nulo!");
	    }

	    if (quantidade <= 0) {
	        throw new IllegalArgumentException(
	        		"A quantidade deve ser maior que zero!"
	        		);
	    }
		this.produto = produto;
		this.quantidade = quantidade;
                this.precoUnitario = produto.getPreco();
	}
        public ItemCarrinho(Produto produto, int quantidade,  double precoUnitario){
            if (produto == null) {
                throw new IllegalArgumentException("Produto não pode ser nulo!");
	    }

	    if (quantidade <= 0) {
	        throw new IllegalArgumentException(
	        		"A quantidade deve ser maior que zero!"
	        		);
	    }
            if (!Double.isFinite(precoUnitario) || precoUnitario < 0) {
                throw new IllegalArgumentException("Preço unitário inválido!");
}
		this.produto = produto;
		this.quantidade = quantidade;
                this.precoUnitario = precoUnitario;
        }
	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if(quantidade<=0) {
			 throw new IllegalArgumentException(
			            "A quantidade deve ser maior que zero!"
			        );
		}
		this.quantidade = quantidade;
	}

        public double getPrecoUnitario() {
            return precoUnitario;
        }
        
	public double calcularSubtotal() {
		return precoUnitario*quantidade;
	}
}
