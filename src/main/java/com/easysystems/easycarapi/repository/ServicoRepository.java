package com.easysystems.easycarapi.repository;
import com.easysystems.easycarapi.models.Servico;
import org.springframework.data.repository.CrudRepository;
public interface ServicoRepository extends CrudRepository<Servico, Long> {
    Servico findByNomeIgnoreCaseContaining(String nome);

}
