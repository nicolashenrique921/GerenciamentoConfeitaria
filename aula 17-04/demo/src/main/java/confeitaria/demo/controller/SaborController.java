package confeitaria.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import confeitaria.demo.model.Sabor;
import confeitaria.demo.service.SaborService;

@RestController
@RequestMapping("/sabores")
public class SaborController {

    @Autowired
    private SaborService service;

    @PostMapping
    public ResponseEntity<Sabor> cadastrar(@RequestBody Sabor sabor) {
        return ResponseEntity.ok(service.salvar(sabor));
    }

    @GetMapping
    public ResponseEntity<List<Sabor>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}

