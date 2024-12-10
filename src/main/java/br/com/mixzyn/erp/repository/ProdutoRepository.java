package br.com.mixzyn.erp.repository;

import br.com.mixzyn.erp.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findAllByNomeContaining(String n);
}
