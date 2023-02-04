package com.example.vendas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfiguration {

    @Bean(name="cachoro")
    public Animal cachorro(){
        return  new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("Au AU");
            }
        };
    }

    @Bean(name="gato")
    public Animal gato(){
        return  new Animal() {
            @Override
            public void fazerBarulho() {
                System.out.println("Miau");
            }
        };
    }
}
