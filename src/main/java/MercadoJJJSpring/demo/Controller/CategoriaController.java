package MercadoJJJSpring.demo.Controller;

import MercadoJJJSpring.demo.DTO.CategoriaRequestDTO;
import MercadoJJJSpring.demo.Entity.CategoriaEntity;
import MercadoJJJSpring.demo.Service.CategoriaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@AllArgsConstructor
public class CategoriaController {
    private  CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> todasCategorias(){
        return ResponseEntity.ok(categoriaService.retornaCategoria());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaEntity>> categoriaPorID(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.retornaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaEntity> cadastrar(@Valid @RequestBody CategoriaRequestDTO dto){
        return ResponseEntity.ok(categoriaService.salvar(dto.nome()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaPorID(@PathVariable Long id){
        categoriaService.deletaPorId(id);
        return ResponseEntity.ok(java.util.Map.of("message", "A categoria foi deletada com sucesso!"));
    }
}
