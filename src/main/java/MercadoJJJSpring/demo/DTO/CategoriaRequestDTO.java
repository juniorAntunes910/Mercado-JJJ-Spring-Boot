package MercadoJJJSpring.demo.DTO;

import jakarta.validation.constraints.NotNull;

public record CategoriaRequestDTO(
        @NotNull
        String nome) {
}
