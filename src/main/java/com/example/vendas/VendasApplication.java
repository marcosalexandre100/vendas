package com.example.vendas;

import com.example.vendas.domain.entity.Cliente;
import com.example.vendas.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {
   /*  @Bean
    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
		return args -> {
			Cliente c = new Cliente(null, "Fulano");
			clientes.save(c);
		};
	}*/ //Vamos eliminar essa necessidade pois vao criar um Post
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
