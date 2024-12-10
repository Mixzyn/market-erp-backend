package br.com.mixzyn.erp.controller;

import br.com.mixzyn.erp.entity.Produto;
import br.com.mixzyn.erp.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto createProduto(@RequestBody Produto produto){
        return service.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> findAll(){
        return service.findAllProdutos();
    }

    @GetMapping("/{id}")
    public Produto findProdutoById(@PathVariable("id") Integer id){
        return service.findProdutoById(id);
    }

    @GetMapping("/search/{name}")
    public List<Produto> findProdutoByName(@PathVariable("name") String name){
        return service.findProdutoByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable("id") Integer id){
        service.deleteProduto(id);
    }
}
