package br.com.mixzyn.erp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Integer id;

    @Column(name = "qtd_total")
    private int quantidadeTotal;

    @Column(name = "dt_criacao", updatable = false)
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "dt_atualizacao")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "estoque")
    @JsonManagedReference
    private List<Produto> produtos;
}
