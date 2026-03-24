package MercadoJJJSpring.demo.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ItemVendaRequestDTO(
        @NotNull(message = "O id do produto não pode ser nulo")
        Long produtoID,

        @NotNull(message = "A quantidade não pode ser nula")
        @Min(value = 1, message = "O valor deve ser superior a 1")
        Integer quantidade
){
}
