package br.com.cirros.trbfinalcap1.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cirros.trbfinalcap1.dto.ClientDTO;
import br.com.cirros.trbfinalcap1.entities.Client;
import br.com.cirros.trbfinalcap1.repositories.ClientRepository;
import br.com.cirros.trbfinalcap1.services.exception.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
//	public List<ClientDTO> findAll(){
//		List<Client> list = repository.findAll();
//		
//		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
//	}
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Nenhum Cliente Encontrado!"));
		return new ClientDTO(entity);
	}

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}	
	
	@Transactional
	public ClientDTO insertClient(ClientDTO dto) {
		Client entity = new Client();
		
		copyDtoToEntity(dto, entity);
		
		entity = repository.save(entity);
		return new ClientDTO(entity);
	}
	
	@Transactional
	public ClientDTO updateClient(Long id, ClientDTO dto) {
		try {
			Client entity = repository.getOne(id);
			
			copyDtoToEntity(dto, entity);
			
			entity = repository.save(entity);
			return new ClientDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado!" + id);
		}
	}	
	
	public void deleteClient(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado!" + id);
		}
	}
	
	private void copyDtoToEntity(ClientDTO dto, Client entity) {

		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());;
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setName(dto.getName());
	}
}
