package confeitaria.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import confeitaria.demo.model.Cliente;
import confeitaria.demo.model.Pedido;
import confeitaria.demo.model.PedidoStatus;
import confeitaria.demo.model.Sabor;
import confeitaria.demo.repository.ClienteRepository;
import confeitaria.demo.repository.PedidoRepository;
import confeitaria.demo.repository.SaborRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SaborRepository saborRepository;

    public Pedido criarPedido(Long clienteId, Long saborId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Sabor sabor = saborRepository.findById(saborId)
                .orElseThrow(() -> new RuntimeException("Sabor não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setSabor(sabor);
        pedido.setDataPedido(LocalDate.now());
        pedido.setStatus(PedidoStatus.PENDENTE);

        return repository.save(pedido);
    }

    public Pedido atualizarStatus(Long pedidoId, PedidoStatus status) {
        Pedido pedido = repository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(status);
        return repository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return repository.findAll();
    }
}

