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
			clientes.salvar(new Cliente("Marcos Alexandre"));
			clientes.salvar(new Cliente("Aline Gomes"));

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando clientes");
			todosClientes.forEach( c ->{
				c.setNome(c.getNome() + " atualizado.");
				clientes.atualizar(c);
			});
			  System.out.println("deletando clientes");
              clientes.obterTodos().forEach(c -> {
				  clientes.deletar(c);
            });
            todosClientes = clientes.obterTodos();
			if(todosClientes.isEmpty()){
				System.out.println("Nenhum cliente encontrado.");
			} else{
				todosClientes.forEach(System.out::println);
			}

		};
	}
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
