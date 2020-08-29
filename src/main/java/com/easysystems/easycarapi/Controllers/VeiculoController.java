package com.easysystems.easycarapi.Controllers;


import com.easysystems.easycarapi.models.Cliente;
import com.easysystems.easycarapi.models.Veiculo;
import com.easysystems.easycarapi.repository.ClienteRepository;
import com.easysystems.easycarapi.repository.VeiculoRepository;
import com.easysystems.easycarapi.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "veiculos")
public class VeiculoController {

    private VeiculoRepository veiculoDao;
    private ClienteRepository clienteDao;
    private ClienteService clienteService;

    @Autowired
    public VeiculoController(VeiculoRepository veiculoRepository, ClienteRepository clienteDao, ClienteService clienteService) {
        this.veiculoDao = veiculoRepository;
        this.clienteDao = clienteDao;
        this.clienteService = clienteService;
    }

    @PostMapping(path = "/addVeiculo/{id}")
    public ResponseEntity<?> addVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo ve) {
        Cliente cl = clienteDao.findById(id).orElse(null);
        clienteService.clienteExistente(id);
        ve.setCliente(cl);

        veiculoDao.save(ve);
        return new ResponseEntity<>(cl, HttpStatus.OK);
    }

    @GetMapping(path = "/{placa}")
    public ResponseEntity<?> getVeiculoByPlaca(@PathVariable("placa") String placa) {
        Veiculo v = veiculoDao.findByPlaca(placa);

        if (v != null) {
            return new ResponseEntity<>(v, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping
//    public ResponseEntity<?> update(@Valid @RequestBody Veiculo veiculo) {
//
//        veiculoDao.save(veiculo);
//        return new ResponseEntity<>(veiculo,HttpStatus.OK);
//    }

    @PutMapping
    public ResponseEntity<?> alterarVeiculo(@RequestBody Veiculo v) {

        try {
            if (v.getId() != null) {
                veiculoDao.findById(v.getId()).ifPresent(veiculo -> veiculoDao.save(veiculo));
            }
            Veiculo veiculoAlterado = veiculoDao.findById(v.getId()).orElse(null);
            return new ResponseEntity<>(veiculoAlterado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
