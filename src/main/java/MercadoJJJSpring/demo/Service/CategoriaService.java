package MercadoJJJSpring.demo.Service;

import MercadoJJJSpring.demo.Entity.CategoriaEntity;
import MercadoJJJSpring.demo.Repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    public CategoriaEntity salvar(String nome) {
        if (categoriaRepository.existsByNome(nome)) {
            throw new RuntimeException("Ja existe uma categoria com este nome");
        }
        System.out.println(nome);
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setNome(nome);

        return categoriaRepository.save(categoria);
    }

    public List<CategoriaEntity> retornaCategoria(){
        List<CategoriaEntity> todasCategorias = categoriaRepository.findAll();
        return todasCategorias;
    }

    public Optional<CategoriaEntity> retornaPorId(Long id){
        Optional<CategoriaEntity> categoria = categoriaRepository.findById(id);
        if(categoria.isEmpty() || categoria == null){
            throw new RuntimeException("ID não existe");
        }
        return categoria;
    }

    public void deletaPorId (Long id){
        if(!categoriaRepository.existsById(id)){
            throw new RuntimeException("ID não existe");
        }
        categoriaRepository.deleteById(id);
    }
}

