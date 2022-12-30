package br.com.arcelino.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arcelino.dto.ProdutoForm;
import br.com.arcelino.dto.ProdutoResponse;
import br.com.arcelino.service.ProdutoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoForm produtoForm) {
        var produtoResponse = service.create(produtoForm);
        return ResponseEntity.ok(produtoResponse);
    }

    @GetMapping
    public Page<ProdutoResponse> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        var produtoResponse = service.findById(id);
        return ResponseEntity.ok(produtoResponse);
    }

    @GetMapping("/nome/{nome}")
    public Page<ProdutoResponse> findByNomeIgnoreCaseContaining(@PathVariable String nome, Pageable pageable) {
        return service.findByNomeIgnoreCaseContaining(nome, pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable Long id, @RequestBody ProdutoForm produtoForm) {
        var produtoResponse = service.update(id, produtoForm);
        return ResponseEntity.ok(produtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
