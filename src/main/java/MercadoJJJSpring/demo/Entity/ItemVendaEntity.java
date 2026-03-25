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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    public VendaEntity getVendaEntity() {
        return vendaEntity;
    }

    public void setVendaEntity(VendaEntity vendaEntity) {
        this.vendaEntity = vendaEntity;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemVendaEntity{" +
                "id=" + id +
                ", produto=" + produto +
                ", vendaEntity=" + vendaEntity +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
