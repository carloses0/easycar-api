package com.easysystems.easycarapi.models;

import com.easysystems.easycarapi.enums.EnumStatusOrcamento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Embeddable
public class Orcamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(targetEntity = Produto.class, cascade = {CascadeType.ALL})
    private List<Produto> produtos;

    @OneToMany(targetEntity = Servico.class, cascade = {CascadeType.ALL})
    private List<Servico> servicos;

    private Double valorTotal;

    private EnumStatusOrcamento status;

    private String problemas;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;


    public Orcamento() {};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public EnumStatusOrcamento getStatus() {
        return status;
    }

    public void setStatus(EnumStatusOrcamento status) {
        this.status = status;
    }

    public String getProblemas() {
        return problemas;
    }

    public void setProblemas(String problemas) {
        this.problemas = problemas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orcamento orcamento = (Orcamento) o;
        return id.equals(orcamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
