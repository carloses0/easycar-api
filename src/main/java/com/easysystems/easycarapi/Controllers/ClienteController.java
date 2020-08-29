package com.easysystems.easycarapi.Controllers;
import com.easysystems.easycarapi.models.Cliente;
import com.easysystems.easycarapi.repository.ClienteRepository;
import com.easysystems.easycarapi.services.ClienteService;
import exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteRepository clienteDao;

    private ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteRepository dao, ClienteService clienteService) {
        this.clienteDao = dao;
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable("id") Long id) {
        Cliente cl = clienteService.findById(id);
        return new ResponseEntity<>(cl, HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{nome}")
    public ResponseEntity<?> getClienteByName(@PathVariable("nome") String nome) {


        Cliente cl = clienteDao.findByNomeIgnoreCaseContaining(nome);

        if (cl == null){
            throw new NotFoundException("Não encontado");
        }
        return new ResponseEntity<>(cl, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> save(@Valid @RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.salvar(cliente), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> remove(@NotNull @PathVariable("id") Long id) {
        clienteService.clienteExistente(id);
        clienteDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cl) {
        clienteService.clienteExistente(cl.getId());
        clienteService.salvar(cl);
        return new ResponseEntity<>(cl,HttpStatus.OK);
    }




}
