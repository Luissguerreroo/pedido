package com.guerrero.pedido.service;

import com.guerrero.pedido.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listar();

    Cliente buscarPorId(Integer id);

    Cliente guardar(Cliente cliente);

    Cliente actualizar(Integer id, Cliente cliente);

    void eliminar(Integer id);
}
