package MercadoJJJSpring.demo.DTO;

import MercadoJJJSpring.demo.Entity.ItemVendaEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record VendaRequesDTO(

        @NotEmpty(message = "O carrinho não pode ser nulo/vazio!")
        List<ItemVendaRequestDTO> itens
){

}
