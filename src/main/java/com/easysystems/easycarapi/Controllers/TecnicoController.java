package com.easysystems.easycarapi.Controllers;

import com.easysystems.easycarapi.models.Tecnico;
import com.easysystems.easycarapi.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "tecnicos")
public class TecnicoController {
        private TecnicoRepository tecnicoDao;

        @Autowired
        public TecnicoController(TecnicoRepository tecnicoDao) {
            this.tecnicoDao = tecnicoDao;
        }

        @GetMapping
        public ResponseEntity<?> listAll() {
            return new ResponseEntity<>(tecnicoDao.findAll(), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<?> salvar(@RequestBody Tecnico tecnico){
            return new ResponseEntity<>(tecnicoDao.save(tecnico), HttpStatus.OK);
        }

        @GetMapping(path = "/{id}")
        public ResponseEntity<?> getById(@PathVariable("id") long id){
            return new ResponseEntity<>(tecnicoDao.findById(id), HttpStatus.OK);
        }

        @GetMapping(path = "/findByName/{name}")
        public ResponseEntity<?> getById(@PathVariable("name") String name){
            return new ResponseEntity<>(tecnicoDao.findByNomeIgnoreCaseContaining(name), HttpStatus.OK);
        }
    }
