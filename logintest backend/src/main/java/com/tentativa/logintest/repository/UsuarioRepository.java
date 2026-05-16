package com.tentativa.logintest.repository;
//literalmente o possível "suficiente" para comunicar backend java com Banco de dados (só testando pra descobrir)
import com.tentativa.logintest.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
//o "extends JpaRepository<Usuario, Long>" já cria tudo de findby(nome do que está sendo procurado)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}