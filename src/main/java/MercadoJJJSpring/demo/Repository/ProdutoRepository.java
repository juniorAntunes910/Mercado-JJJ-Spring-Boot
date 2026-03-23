package MercadoJJJSpring.demo.Repository;

import MercadoJJJSpring.demo.Entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
