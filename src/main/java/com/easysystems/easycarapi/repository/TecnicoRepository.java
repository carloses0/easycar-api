package com.easysystems.easycarapi.repository;

import com.easysystems.easycarapi.models.Tecnico;
import org.springframework.data.repository.CrudRepository;

public interface TecnicoRepository extends CrudRepository<Tecnico, Long> {
    Tecnico findByNomeIgnoreCaseContaining(String nome);
}
