package MercadoJJJSpring.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutoRequestDTO(

        @NotBlank(message = "O nome do produto não pode ser Nulo")
        String nome,

        @NotNull(message = "O preço do produto não pode ser nulo")
        @Positive(message = "O preço do produto deve ser positivo, ou maior que zero")
        double preco,

        @NotNull(message = "O produto precisa de uma categoria")
        Long categoria,

        @NotNull(message = "A quantidade em estoque não pode ser nula")
        int quantidadeEstoque) {
}


