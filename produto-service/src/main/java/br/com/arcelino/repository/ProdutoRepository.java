package br.com.arcelino.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arcelino.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByNomeIgnoreCaseContaining(String nome, Pageable pageable);

}
