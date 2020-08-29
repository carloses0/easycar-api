package com.easysystems.easycarapi.models;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrdemServico implements Serializable {
    private  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dataInicio;

    private Date dataFinal;

    private Cliente cliete;

    private Veiculo veiculo;

    private List<Servico> servico;

    private List<Item> itens;

    private BigDecimal orcamento;

    private String status;



}
