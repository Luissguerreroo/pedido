package com.guerrero.pedido.service;

import com.guerrero.pedido.entity.Talla;
import java.util.List;

public interface TallaService {

    List<Talla> listar();

    Talla buscarPorId(Integer id);

    Talla guardar(Talla talla);

    Talla actualizar(Integer id, Talla talla);

    void eliminar(Integer id);
}
