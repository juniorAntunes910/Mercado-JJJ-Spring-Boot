package MercadoJJJSpring.demo.Repository;

import MercadoJJJSpring.demo.Entity.ItemVendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVendaRepository extends JpaRepository<ItemVendaEntity, Long> {
}
