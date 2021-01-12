package com.desafioorange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafioorange.model.Client;
import com.desafioorange.repository.ClienteRepository;
import com.desafioorange.util.ValidarCPF;

@RestController
@RequestMapping("/cliente")
public class ClientController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Client> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client adicionar(@RequestBody Client client) {
		Boolean isCpfValido = ValidarCPF.isCPF(client.getCpf());
		if(isCpfValido) {
			return clienteRepository.save(client);
		} else {
			return null;
		}
		
	}


}
