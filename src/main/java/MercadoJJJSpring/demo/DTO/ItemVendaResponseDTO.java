package MercadoJJJSpring.demo.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ItemVendaResponseDTO(
        Long produtoID,
        String nomeProduto,
        Integer quantidade,
        Double precoUnitario,
        Double subTotal
) {
}
