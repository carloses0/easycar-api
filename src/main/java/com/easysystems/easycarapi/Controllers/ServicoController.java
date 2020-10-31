package com.easysystems.easycarapi.Controllers;

import com.easysystems.easycarapi.models.Servico;
import com.easysystems.easycarapi.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("servicos")
public class ServicoController {

    private final ServicoRepository servicoDao;

    @Autowired
    public ServicoController(ServicoRepository servicoDao) {
        this.servicoDao = servicoDao;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(servicoDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{nome}")
    public ResponseEntity<?> getProdutoByName(@PathVariable("nome") String nome) {
        Servico servico = servicoDao.findByNomeIgnoreCaseContaining(nome);
        return new ResponseEntity<>(servico, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProdutoById(@PathVariable("id") Long id) {
        Servico servico = servicoDao.findById(id).orElse(null);
        return new ResponseEntity<>(servico, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> save(@Valid @RequestBody Servico servico) {
        return new ResponseEntity<>(servicoDao.save(servico), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@Valid @RequestBody Servico servico) {
        return new ResponseEntity<>(servicoDao.save(servico), HttpStatus.OK);
    }
}
