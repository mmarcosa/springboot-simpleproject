package br.com.listavip.configuracao;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.com.listavip.configuracao.controller.ConvidadoController;
import br.com.listavip.configuracao.repository.ConvidadoRepository;


@SpringBootApplication
@ComponentScan(basePackages = {"br.com.listavip.controller", "br.com.listavip.repository"}, basePackageClasses = {ConvidadoController.class, ConvidadoRepository.class})
public class Configuracao {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip?autoReconnect=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("scope227");
		return dataSource;
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class,  args);
	}

}