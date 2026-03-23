package MercadoJJJSpring.demo.Repository;

import MercadoJJJSpring.demo.Entity.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaEntity, Long> {
}
