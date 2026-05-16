package com.tentativa.logintest.controller;

import com.tentativa.logintest.model.Usuario;
import com.tentativa.logintest.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
//CrossOrigin permite frontend acessar backend (e evita CORS)
@CrossOrigin("*")
public class UsuarioController {

    //Autowired = Spring cria objeto sozinha
    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastro")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return service.cadastrarUsuario(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean loginValido = service.login(usuario.getEmail(), usuario.getSenha());

        if(loginValido) {
            return "Login correto";
        }
        return "Usuário ou senha incorretos. Por favor, tente novamente";
    }
}
