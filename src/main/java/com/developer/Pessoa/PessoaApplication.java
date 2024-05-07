package com.developer.Pessoa;

import com.developer.Pessoa.principal.Principal;
import com.developer.Pessoa.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class PessoaApplication implements CommandLineRunner {
	@Autowired
	private IUsuarioRepository repositorio;

	public static void main(String[] args) {

		SpringApplication.run(PessoaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.mostraMenu();
	}
}
