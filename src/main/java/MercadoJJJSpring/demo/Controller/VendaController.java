package MercadoJJJSpring.demo.Controller;


import MercadoJJJSpring.demo.DTO.VendaRequesDTO;
import MercadoJJJSpring.demo.DTO.VendaResponseDTO;
import MercadoJJJSpring.demo.Service.VendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
@AllArgsConstructor
public class VendaController {
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<VendaResponseDTO> realizarVenda(@RequestBody VendaRequesDTO dto){
            return ResponseEntity.ok(vendaService.realizarVenda(dto));
    }
}
