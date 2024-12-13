package br.com.mixzyn.erp.service;

import br.com.mixzyn.erp.model.entity.Produto;
import br.com.mixzyn.erp.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> exibirTodosProdutos() {
        return repository.findAll();
    }

    public Optional<Produto> encontrarProdutoPorId(Integer id){
        return repository.findById(id);
    }

    public List<Produto> encontrarProdutoPorNome(String name){
        return repository.findAllByNomeContaining(name);
    }

    public Produto salvarProduto(Produto produto) {
        return repository.save(produto);
    }

    public void deletarProduto(Integer id){
        repository.deleteById(id);
    }

    public boolean seProdutoExiste(Integer id) {
        return repository.existsById(id);
    }
}
