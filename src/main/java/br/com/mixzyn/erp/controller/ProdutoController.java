package br.com.mixzyn.erp.controller;

import br.com.mixzyn.erp.model.entity.Produto;
import br.com.mixzyn.erp.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> exibirProdutos(){
        return ResponseEntity.ok(service.exibirTodosProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> encontrarProduto(@PathVariable("id") Integer id){
        if(service.seProdutoExiste(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(service.encontrarProdutoPorId(id));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Produto>> encontrarProdutoPorNome(@PathVariable("name") String name){

        return ResponseEntity.ok(service.encontrarProdutoPorNome(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(
            @PathVariable("id") Integer id,
            @RequestBody Produto produto
    ){
        if(service.seProdutoExiste(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        produto.setId(id);
        return ResponseEntity.ok(service.salvarProduto(produto));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Produto> atualizarQuantidade(
            @PathVariable("id") Integer id,
            @RequestBody Produto produto
    ){
        return ResponseEntity.ok(service.atualizarQtdProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable("id") Integer id){
        service.deletarProduto(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
