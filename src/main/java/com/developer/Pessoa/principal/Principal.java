package com.developer.Pessoa.principal;

import com.developer.Pessoa.model.Usuario;
import com.developer.Pessoa.repository.IUsuarioRepository;

import java.util.Scanner;

public class Principal {
    private final IUsuarioRepository repositorio;
    Scanner sc = new Scanner(System.in);

    public Principal (IUsuarioRepository repositorio){
        this.repositorio = repositorio;
    }
    public void mostraMenu(){

        int op = -1;
        do {

            String menu = """
            *************************************
            | 0 - Sair                          |                                  
            | 1 - Cadastrar                     |                                  
            | 2 - Listar                        |                                  
            |                                   |                                  
            |***********************************|
            """;

            System.out.println(menu);
            System.out.print(" Qual a sua opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    listarUsuario();
                    break;
                default:
                    System.out.println(" Opção inválida ! ");
            }
        }while (op != 0 );


    }
    public void cadastrarUsuario(){

        String novoUser = "S";
        while(novoUser.equalsIgnoreCase("S")){
            System.out.print("Digite o seu nome: ");
            String nome = sc.nextLine();
            System.out.print("Digite o seu sobrenome: ");
            String sobrenome = sc.nextLine();

            Usuario user = new Usuario(nome,sobrenome);
            repositorio.save(user);
            System.out.println("Deseja cadastrar novo usuario? (S/N)");
            novoUser = sc.nextLine();
        }

    }
    public void listarUsuario(){
        System.out.println(" -----------------------------------");
        repositorio.findAll().forEach(usuario -> System.out.println(usuario));
        System.out.println(" -----------------------------------");
    }
}
