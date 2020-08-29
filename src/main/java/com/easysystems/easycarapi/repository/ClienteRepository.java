package com.easysystems.easycarapi.repository;
import com.easysystems.easycarapi.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findByNomeIgnoreCaseContaining(String nome);
}
