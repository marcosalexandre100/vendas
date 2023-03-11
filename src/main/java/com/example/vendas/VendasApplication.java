package com.example.vendas;

import com.example.vendas.domain.entity.Cliente;
import com.example.vendas.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			/*Cliente cliente = new Cliente();
			cliente.setNome("Marcos Alexandre");
			clientes.salvar(cliente);*/ //forma grande
			System.out.println("Salvando clientes");
			clientes.save(new Cliente("Marcos Alexandre"));
			clientes.save(new Cliente("Aline Gomes"));

			List<Cliente> todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes");
			todosClientes.forEach( c ->{
				c.setNome(c.getNome() + " atualizado.");
				clientes.save(c);
			});

			todosClientes = clientes.findAll();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando clientes");
			clientes.findByNomeLike("Cli").forEach(System.out::println);

			System.out.println("deletando clintes");
			clientes.findAll().forEach(c -> {
				clientes.delete(c);
			});

			todosClientes = clientes.findAll();
			if(todosClientes.isEmpty()){
				System.out.println("Nenhum cliente encontrado.");
			}else {
				todosClientes.forEach(System.out::println);
			}

		};
	}
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
