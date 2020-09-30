package br.com.cirros.trbfinalcap1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cirros.trbfinalcap1.dto.ClientDTO;
import br.com.cirros.trbfinalcap1.entities.Client;
import br.com.cirros.trbfinalcap1.repositories.ClientRepository;

public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
}
