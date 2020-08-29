package com.easysystems.easycarapi.repository;

import com.easysystems.easycarapi.models.Veiculo;
import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
        Veiculo findByPlaca(String placa);
}
