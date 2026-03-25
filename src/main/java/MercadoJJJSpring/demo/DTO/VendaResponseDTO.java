package MercadoJJJSpring.demo.DTO;


import java.time.LocalDateTime;
import java.util.List;

public record VendaResponseDTO(
        Long idVenda,
        LocalDateTime dataHora,
        Double valorTotal,
        List<ItemVendaResponseDTO> itens
) {
}
