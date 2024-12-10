package br.com.mixzyn.erp.service;

import br.com.mixzyn.erp.entity.Produto;
import br.com.mixzyn.erp.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> findAllProdutos() {
        return repository.findAll();
    }

    public Produto findProdutoById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findProdutoByName(String name){
        return repository.findAllByNomeContaining(name);
    }

    public Produto criarProduto(Produto produto) {
        return repository.save(produto);
    }

    public void deleteProduto(Integer id){
        repository.deleteById(id);
    }
}
