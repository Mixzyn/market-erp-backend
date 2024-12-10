package br.com.mixzyn.erp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;

    @Column(name = "nm_produto")
    private String nome;

    @Column(name = "cd_produto")
    private int codigoProduto;

    @Column(name = "vl_unitario")
    private double precoUnitario;

    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "qtd_produto")
    private int quantidade;

    @Column(name = "dt_criacao", updatable = false)
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "dt_atualizacao")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_estoque", nullable = false)
    @JsonBackReference
    private Estoque estoque;
}
