package com.tentativa.logintest.service;

import com.tentativa.logintest.model.Usuario;
import com.tentativa.logintest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Restcontroller = receptor de requisição HTTP
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public boolean login(String email, String senha) {

        Usuario usuario = repository.findByEmail(email);

        if(usuario == null) {
            return false;
        }

        return usuario.getSenha().equals(senha);
    }
}
