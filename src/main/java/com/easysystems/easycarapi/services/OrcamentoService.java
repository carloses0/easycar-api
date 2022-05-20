package com.easysystems.easycarapi.services;

import com.easysystems.easycarapi.models.Orcamento;
import com.easysystems.easycarapi.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrcamentoService {

    private OrcamentoRepository orcamentoRepository;

    @Autowired
    public OrcamentoService(OrcamentoRepository dao) {
        this.orcamentoRepository = dao;
    }

    public Orcamento salvar(Orcamento orcamento) {
        return  orcamentoRepository.save(orcamento);
    }

}

