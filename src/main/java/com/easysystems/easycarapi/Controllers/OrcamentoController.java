package com.easysystems.easycarapi.Controllers;

import com.easysystems.easycarapi.models.Cliente;
import com.easysystems.easycarapi.models.Orcamento;
import com.easysystems.easycarapi.models.OrdemServico;
import com.easysystems.easycarapi.repository.OrcamentoRepository;
import com.easysystems.easycarapi.services.OrcamentoService;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("orcamento")
public class OrcamentoController {

    private OrcamentoService orcamentoService;

    private OrcamentoRepository orcamentoRepository;

    @Autowired
    public OrcamentoController(OrcamentoService orcamentoService, OrcamentoRepository orcamentoRepository) {
        this.orcamentoService = orcamentoService;
        this.orcamentoRepository = orcamentoRepository;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(orcamentoRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable("id") Long id) {
        Orcamento orcamento = orcamentoRepository.findById(id).orElse(null);
        return new ResponseEntity<>(orcamento, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> save(@Valid @RequestBody Orcamento orcamento) {
        return new ResponseEntity<>(orcamentoService.salvar(orcamento), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            orcamentoRepository.deleteById(id);
        } catch (Exception e) {
            throw new FatalBeanException("Error ao Ecluir item");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


