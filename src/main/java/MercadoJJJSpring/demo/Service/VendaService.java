package MercadoJJJSpring.demo.Service;


import MercadoJJJSpring.demo.DTO.ItemVendaRequestDTO;
import MercadoJJJSpring.demo.DTO.ProdutoRequestDTO;
import MercadoJJJSpring.demo.DTO.VendaRequesDTO;
import MercadoJJJSpring.demo.Entity.ItemVendaEntity;
import MercadoJJJSpring.demo.Entity.ProdutoEntity;
import MercadoJJJSpring.demo.Entity.VendaEntity;
import MercadoJJJSpring.demo.Repository.ItemVendaRepository;
import MercadoJJJSpring.demo.Repository.ProdutoRepository;
import MercadoJJJSpring.demo.Repository.VendaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VendaService {
    private ItemVendaRepository itemVendaRepository;
    private VendaRepository vendaRepository;
    private ProdutoRepository produtoRepository;

    @Transactional
    public VendaEntity realizarVenda(VendaRequesDTO vendaRequesDTO) {
        VendaEntity novaVenda = new VendaEntity();
        novaVenda.setDataHora(LocalDateTime.now());

        List<ItemVendaEntity> itensVenda = new ArrayList<>();

        for (ItemVendaRequestDTO itemDTO : vendaRequesDTO.itens()) {

            ProdutoEntity produto = produtoRepository.findById(itemDTO.produtoID())
                    .orElseThrow(() -> new RuntimeException("Produto ID " + itemDTO.produtoID() + " não encontrado!"));

            if(itemDTO.quantidade() > produto.getQuantidade()){
                throw new RuntimeException("O Produto não possui a quantidade necessaria para realizar a venda");
            }
            produto.setQuantidade(produto.getQuantidade() - itemDTO.quantidade());

            ItemVendaEntity novoItem = new ItemVendaEntity();
            novoItem.setProduto(produto);
            novoItem.setQuantidade(itemDTO.quantidade());
            novoItem.setPrecoUnitario(produto.getPreco());
            novoItem.setVendaEntity(novaVenda);

            itensVenda.add(novoItem);
        }
        novaVenda.setItens(itensVenda);

        return vendaRepository.save(novaVenda);
    }



}
