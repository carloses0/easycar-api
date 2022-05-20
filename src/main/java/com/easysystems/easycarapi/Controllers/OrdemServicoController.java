package com.easysystems.easycarapi.Controllers;

import com.easysystems.easycarapi.models.OrdemServico;
import com.easysystems.easycarapi.repository.OrdemServicoRepository;
import com.easysystems.easycarapi.services.OrdemServicoService;
import com.easysystems.easycarapi.services.RelatorioService;
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

    private RelatorioService relService;

    @Autowired
    public OrdemServicoController(OrdemServicoRepository dao, OrdemServicoService osService, RelatorioService relService) {
        this.osDao = dao;
        this.osService = osService;
        this.relService = relService;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(osDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
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
        OrdemServico osRes = osDao.save(os);
        return new ResponseEntity<>(osRes, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody OrdemServico os) {
        osDao.save(os);
        return new ResponseEntity<>(os,HttpStatus.OK);
    }

}
