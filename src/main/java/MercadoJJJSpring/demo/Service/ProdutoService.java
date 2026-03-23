package MercadoJJJSpring.demo.Service;

import MercadoJJJSpring.demo.DTO.ProdutoRequestDTO;
import MercadoJJJSpring.demo.DTO.ProdutoResponseDTO;
import MercadoJJJSpring.demo.Entity.CategoriaEntity;
import MercadoJJJSpring.demo.Entity.ProdutoEntity;
import MercadoJJJSpring.demo.Repository.CategoriaRepository;
import MercadoJJJSpring.demo.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;

    @Transactional
    public ProdutoResponseDTO cadastrar(ProdutoRequestDTO dto){
        CategoriaEntity categoria = categoriaRepository.findById(dto.categoria())
                .orElseThrow(() -> new RuntimeException("Essa Categoria não existe"));

        ProdutoEntity produto = new ProdutoEntity();
        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setCategoria(categoria);
        produto.setQuantidade(dto.quantidadeEstoque());

        ProdutoEntity salvo = produtoRepository.save(produto);

        return new ProdutoResponseDTO(salvo);
    }

}
