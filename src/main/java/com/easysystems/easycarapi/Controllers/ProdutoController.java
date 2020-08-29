package com.easysystems.easycarapi.Controllers;

import com.easysystems.easycarapi.models.Cliente;
import com.easysystems.easycarapi.models.Produto;
import com.easysystems.easycarapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoRepository produtoDao;

    @Autowired
    public ProdutoController(ProdutoRepository produtoDao) {
        this.produtoDao = produtoDao;
    }

    @GetMapping
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(produtoDao.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{nome}")
    public ResponseEntity<?> getProdutoByName(@PathVariable("nome") String nome) {
        Produto produto = produtoDao.findByNomeIgnoreCaseContaining(nome);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getProdutoById(@PathVariable("id") Long id) {
        Produto produto = produtoDao.findById(id).orElse(null);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> save(@Valid @RequestBody Produto produto) {
        return new ResponseEntity<>(produtoDao.save(produto), HttpStatus.OK);
    }
}
