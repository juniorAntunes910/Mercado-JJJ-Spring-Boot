package MercadoJJJSpring.demo.DTO;

import MercadoJJJSpring.demo.Entity.ProdutoEntity;

public record ProdutoResponseDTO (String nome, double preco, Long categoria) {

public ProdutoResponseDTO(ProdutoEntity entity){
    this(entity.getNome(), entity.getPreco(), entity.getCategoria().getId());
}
}
