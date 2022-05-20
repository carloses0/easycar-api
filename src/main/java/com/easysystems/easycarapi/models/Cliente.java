package com.easysystems.easycarapi.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cliente extends AbstractEntity implements Serializable {
    private  static final long serialVersionUID = 1L;

    @NotEmpty
    private String nome;

    private String cpfCnpj;

    @OneToOne(targetEntity = Contato.class, cascade = CascadeType.ALL)
    private Contato contato;

    @OneToMany(mappedBy = "cliente", targetEntity = Veiculo.class, cascade = CascadeType.ALL)
    private List<Veiculo> veiculos;

    @OneToMany( mappedBy = "cliente", targetEntity = Endereco.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Endereco> enderecos;


    public Cliente() {
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

