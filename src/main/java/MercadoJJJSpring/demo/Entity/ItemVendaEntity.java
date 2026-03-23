package MercadoJJJSpring.demo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "item_venda")
public class ItemVendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private VendaEntity vendaEntity;

    private int quantidade;

    @Column(name = "preco_unitario")
    private double precoUnitario;

}
