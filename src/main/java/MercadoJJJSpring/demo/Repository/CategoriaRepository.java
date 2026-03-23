package MercadoJJJSpring.demo.Repository;

import MercadoJJJSpring.demo.Entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    boolean existsByNome(String nome);

}
