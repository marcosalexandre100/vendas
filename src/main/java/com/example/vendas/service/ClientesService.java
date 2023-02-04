package com.example.vendas.service;

import com.example.vendas.model.Cliente;
import com.example.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClienteRepository repository;

    @Autowired
    public ClientesService(ClienteRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        //ClienteRepository clienteRepository = new ClienteRepository(); consome muita memoria
        
        this.repository.persistir(cliente);
    }
    public void validarCliente(Cliente cliente){
        //aplica validações
    }
}
