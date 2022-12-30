package br.com.arcelino.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.arcelino.dto.ProdutoForm;
import br.com.arcelino.dto.ProdutoResponse;
import br.com.arcelino.entity.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(target = "id", ignore = true)
    Produto toProduto(ProdutoForm produtoForm);

    ProdutoResponse toProdutoResponse(Produto produto);

}
