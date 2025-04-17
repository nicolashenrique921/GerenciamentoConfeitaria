package confeitaria.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import confeitaria.demo.model.Sabor;
import confeitaria.demo.repository.SaborRepository;

@Service
public class SaborService {

    @Autowired
    private SaborRepository repository;

    public Sabor salvar(Sabor sabor) {
        return repository.save(sabor);
    }

    public List<Sabor> listar() {
        return repository.findAll();
    }
}

