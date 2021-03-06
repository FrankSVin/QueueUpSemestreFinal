package com.queueup.queueup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.queueup.queueup.domain.Cliente;
import com.queueup.queueup.domain.Usuario;


@RestController
public class UsuariosController {

	private List<Usuario> usuarios; 
	
	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}
	
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(
			@PathVariable("nomeDoUsuario") String nome){
		List<Usuario> usuariosEncontrados = new ArrayList<Usuario>();
		for(Usuario u : usuarios) {
			if(u.getNome().equals(nome)) {
				usuariosEncontrados.add(u);
			}
		}
		if(usuariosEncontrados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(usuariosEncontrados);
		}
	}
	
	private List<Usuario> obterTodosUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		usuarios.add(new Cliente("Fulano1"));
		usuarios.add(new Cliente("Fulano2"));
		usuarios.add(new Cliente("Fulano3"));
		usuarios.add(new Cliente("Fulano4"));
		return usuarios;
	}
}
