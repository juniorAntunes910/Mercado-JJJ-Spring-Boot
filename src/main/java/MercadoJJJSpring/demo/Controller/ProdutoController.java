package MercadoJJJSpring.demo.Controller;


import MercadoJJJSpring.demo.DTO.ProdutoRequestDTO;
import MercadoJJJSpring.demo.DTO.ProdutoResponseDTO;
import MercadoJJJSpring.demo.Entity.ProdutoEntity;
import MercadoJJJSpring.demo.Service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> retornaTodosProdutos(){
        return ResponseEntity.ok(produtoService.retornaListaProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoEntity>> retornaPorID(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.retornaProdutoPorID(id));
    }

    @GetMapping("/nome{nome}")
    public ResponseEntity<ProdutoEntity> retornaPorNome(@PathVariable String nome){
        return ResponseEntity.ok(produtoService.retornaPorNome(nome));
    }



    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@Valid @RequestBody ProdutoRequestDTO dto){
        return ResponseEntity.ok(produtoService.cadastrar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePorId(@PathVariable Long id){
        produtoService.deletarPorID(id);
        return ResponseEntity.ok(java.util.Map.of("message", "O produto foi deletado com sucesso!"));
    }
}
