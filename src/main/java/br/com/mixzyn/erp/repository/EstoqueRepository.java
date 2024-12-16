package br.com.mixzyn.erp.repository;

import br.com.mixzyn.erp.model.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
}
