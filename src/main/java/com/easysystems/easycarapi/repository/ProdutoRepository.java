package com.easysystems.easycarapi.repository;

import com.easysystems.easycarapi.models.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    Produto findByNomeIgnoreCaseContaining(String nome);

}
