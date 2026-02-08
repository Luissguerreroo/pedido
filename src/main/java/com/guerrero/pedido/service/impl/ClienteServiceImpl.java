package com.guerrero.pedido.service.impl;

import com.guerrero.pedido.entity.Cliente;
import com.guerrero.pedido.repository.ClienteRepository;
import com.guerrero.pedido.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente guardar(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    @Transactional
    public Cliente actualizar(Integer id, Cliente cliente) {
        Cliente existente = buscarPorId(id);
        if (existente != null) {
            existente.setRazonSocial(cliente.getRazonSocial());
            existente.setDocumento(cliente.getDocumento());
            existente.setDireccion(cliente.getDireccion());
            existente.setTelefono(cliente.getTelefono());
            return repository.save(existente);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
