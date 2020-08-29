package com.easysystems.easycarapi.services;

import com.easysystems.easycarapi.models.Cliente;
import com.easysystems.easycarapi.models.Contato;
import com.easysystems.easycarapi.models.Endereco;
import com.easysystems.easycarapi.models.Veiculo;
import com.easysystems.easycarapi.repository.ClienteRepository;
import com.easysystems.easycarapi.repository.EnderecoRepository;
import exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {

    private ClienteRepository clienteDao;
    private EnderecoRepository enderecoDao;

    @Autowired
    public ClienteService(ClienteRepository clienteDao, EnderecoRepository enderecoDao) {
        this.clienteDao = clienteDao;
        this.enderecoDao = enderecoDao;
    }

    public Iterable<Cliente> findAll() {
        return this.clienteDao.findAll();
    }

    public Cliente getClienteByName(String nome) {
        Cliente cl = clienteDao.findByNomeIgnoreCaseContaining(nome);
        if (cl == null) {
            throw new NotFoundException("Não encontado");
        }


        return cl;
    }

    public Cliente findById(Long id) {
        clienteExistente(id);
        if (clienteExistente(id)) {
            throw new NotFoundException("Não encontrado");
        }
        return clienteDao.findById(id).orElse(null);
    }

    public boolean clienteExistente(Long id) {
        return clienteDao.findById(id).orElse(null) == null;
    }

    public Cliente salvar(Cliente cliente) {

        alterarEnd(cliente);
        addVeiculo(cliente);

        return clienteDao.save(cliente);
    }



    private void addVeiculo(Cliente cliente) {
        if (!cliente.getVeiculos().isEmpty()) {
            cliente.getVeiculos().forEach(v -> {
                if (v.getCliente() == null)
                    v.setCliente(cliente);
            });

        }

    }

    private void alterarEnd(Cliente cliente) {
        if (!cliente.getEnderecos().isEmpty()) {
//            cliente.getEnderecos().forEach(endereco -> {
//                endereco.setCliente(cliente);
//            });

            cliente.getEnderecos().get(0).setCliente(cliente);
        }
    }
}
