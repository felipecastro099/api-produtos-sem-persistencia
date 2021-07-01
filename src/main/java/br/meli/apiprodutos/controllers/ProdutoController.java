package br.meli.apiprodutos.controllers;

import br.meli.apiprodutos.models.Produto;
import br.meli.apiprodutos.repositories.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping()
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(ProdutoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable long id) {
        Produto produto = ProdutoRepository.findById(id);

        if (produto != null) {
            return ResponseEntity.ok(produto);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não encontrado");
    }

    @PostMapping
    public ResponseEntity<?> store(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoRepository.add(produto));
    }

    @PutMapping()
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Produto produto) {
        Produto novoProduto = ProdutoRepository.update(id, produto);

        if (novoProduto != null) {
            return ResponseEntity.ok(novoProduto);
        }

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable long id) {
        Produto produto = ProdutoRepository.delete(id);

        if(produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não encontrado.");
        }
    }

}
