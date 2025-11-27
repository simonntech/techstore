package br.com.t2_fat.techstore.repository;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")

public class pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido",
        cascade= CascadeType.ALL)
    private List<ItemPedido>itens;
}
