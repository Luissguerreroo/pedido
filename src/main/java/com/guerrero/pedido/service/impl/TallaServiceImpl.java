package com.guerrero.pedido.service.impl;

import com.guerrero.pedido.entity.Talla;
import com.guerrero.pedido.repository.TallaRepository;
import com.guerrero.pedido.service.TallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TallaServiceImpl implements TallaService {

    @Autowired
    private TallaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Talla> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Talla buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Talla guardar(Talla talla) {
        return repository.save(talla);
    }

    @Override
    @Transactional
    public Talla actualizar(Integer id, Talla talla) {
        Talla existente = buscarPorId(id);
        if (existente != null) {
            existente.setNombre(talla.getNombre());
            existente.setRelacion(talla.getRelacion());
            existente.setPrenda(talla.getPrenda());
            existente.setTalla(talla.getTalla());
            existente.setNotas(talla.getNotas());
            existente.setActivo(talla.getActivo());
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
