package br.com.arcelino.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.arcelino.dto.ProdutoForm;
import br.com.arcelino.dto.ProdutoResponse;
import br.com.arcelino.repository.ProdutoRepository;
import br.com.arcelino.util.ProdutoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Transactional
    public ProdutoResponse create(ProdutoForm produtoForm) {
        var produto = produtoMapper.toProduto(produtoForm);
        produtoRepository.save(produto);
        return produtoMapper.toProdutoResponse(produto);
    }

    public Page<ProdutoResponse> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable).map(produtoMapper::toProdutoResponse);
    }

    public Page<ProdutoResponse> findByNomeIgnoreCaseContaining(String nome, Pageable pageable) {
        return produtoRepository.findByNomeIgnoreCaseContaining(nome, pageable).map(produtoMapper::toProdutoResponse);
    }

    public ProdutoResponse findById(Long id) {
        var produto = produtoRepository.findById(id).orElseThrow();
        return produtoMapper.toProdutoResponse(produto);
    }

    @Transactional
    public ProdutoResponse update(Long id, ProdutoForm produtoForm) {
        var produto = produtoRepository.findById(id).orElseThrow();
        produto.setNome(produtoForm.getNome());
        produto.setDescricao(produtoForm.getDescricao());
        produto.setPreco(produtoForm.getPreco());
        produto.setEstoque(produtoForm.getEstoque());
        produtoRepository.save(produto);
        return produtoMapper.toProdutoResponse(produto);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
