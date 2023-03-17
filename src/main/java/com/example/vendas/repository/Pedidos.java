package com.example.vendas.repository;

import com.example.vendas.domain.entity.Cliente;
import com.example.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {


    List<Pedido> findByCliente(Cliente cliente);
}