package com.easysystems.easycarapi.Controllers;

import com.easysystems.easycarapi.models.Cliente;
import com.easysystems.easycarapi.models.OrdemServico;
import com.easysystems.easycarapi.repository.ClienteRepository;
import com.easysystems.easycarapi.repository.OrdemServicoRepository;
import com.easysystems.easycarapi.services.ClienteService;
import com.easysystems.easycarapi.services.OrdemServicoService;
import exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("ordemServico")
public class OrdemServicoController {

    private final OrdemServicoRepository osDao;

    private OrdemServicoService osService;

    @Autowired
    public OrdemServicoController(OrdemServicoRepository dao, OrdemServicoService osService) {
        this.osDao = dao;
        this.osService = osService;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(osDao.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getOsByid(@PathVariable("id") Long id) {
        OrdemServico os = osDao.findById(id).orElse(null);
        if (os == null){
            throw new NotFoundException("não encontado");
        } else {
            return new ResponseEntity<>(os, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> save(@Valid @RequestBody OrdemServico os) {
        return new ResponseEntity<>(osDao.save(os), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody OrdemServico os) {
        osDao.save(os);
        return new ResponseEntity<>(os,HttpStatus.OK);
    }

}
