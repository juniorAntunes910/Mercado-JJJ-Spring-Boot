package MercadoJJJSpring.demo.Service;

import MercadoJJJSpring.demo.DTO.ProdutoRequestDTO;
import MercadoJJJSpring.demo.DTO.ProdutoResponseDTO;
import MercadoJJJSpring.demo.Entity.CategoriaEntity;
import MercadoJJJSpring.demo.Entity.ProdutoEntity;
import MercadoJJJSpring.demo.Repository.CategoriaRepository;
import MercadoJJJSpring.demo.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;


    public List<ProdutoEntity> retornaListaProdutos(){
        List<ProdutoEntity> listaProd = produtoRepository.findAll();
        if(listaProd.isEmpty()){
            throw new RuntimeException("Lista vazia!");
        }
        return listaProd;
    }

    public Optional<ProdutoEntity> retornaProdutoPorID(Long id){
        Optional<ProdutoEntity> prod = produtoRepository.findById(id);
        if(prod.isEmpty()){
            throw new RuntimeException("Id não existe");
        }
        return prod;
    }

    public ProdutoEntity retornaPorNome(String name){
        ProdutoEntity prod = produtoRepository.findByNome(name);
        if(prod == null){
            throw new RuntimeException("Nome do Produto não encontrado");
        }
        return prod;
    }


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

    public void deletarPorID(Long id){
        Optional<ProdutoEntity> prodel = produtoRepository.findById(id);
        if(prodel.isEmpty() || prodel == null){
            throw new RuntimeException("ID não existe");
        }
        produtoRepository.deleteById(id);
    }

}
