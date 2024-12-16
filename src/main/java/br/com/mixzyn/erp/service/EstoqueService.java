package br.com.mixzyn.erp.service;

import br.com.mixzyn.erp.model.entity.Estoque;
import br.com.mixzyn.erp.model.entity.Produto;
import br.com.mixzyn.erp.repository.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    private final EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }

    public List<Estoque> exibirEstoque(){
        return repository.findAll();
    }

    public Estoque salvarEstoque(Estoque estoque){
        return repository.save(estoque);
    }

    public void deletarEstoque(Integer id) {
        repository.deleteById(id);
    }

}
