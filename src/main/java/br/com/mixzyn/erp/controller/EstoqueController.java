package br.com.mixzyn.erp.controller;

import br.com.mixzyn.erp.model.entity.Estoque;
import br.com.mixzyn.erp.service.EstoqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    private final EstoqueService service;

    public EstoqueController(EstoqueService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Estoque> criarEstoque(@RequestBody Estoque estoque){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarEstoque(estoque));
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> exibirEstoque(){
        return ResponseEntity.ok(service.exibirEstoque());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Estoque> deletarEstoque(@PathVariable("id") Integer id){
        service.deletarEstoque(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
