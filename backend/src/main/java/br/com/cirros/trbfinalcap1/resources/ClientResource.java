package br.com.cirros.trbfinalcap1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cirros.trbfinalcap1.dto.ClientDTO;
import br.com.cirros.trbfinalcap1.entities.Client;
import br.com.cirros.trbfinalcap1.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		//Por qustões acadêmicas, estou deixando comentado o código de teste inicial
//		List<Client> list = new ArrayList<>();
//		
//		list.add(new Client(1L, "Ricardo Soares", "029.215.226-40", 1000.00, Instant.now(), 2));
//		list.add(new Client(1L, "Ricardo Soares 1", "029.215.226-40", 1000.00, Instant.now(), 2));
//		list.add(new Client(1L, "Ricardo Soares 2", "029.215.226-40", 1000.00, Instant.now(), 2));
//		list.add(new Client(1L, "Ricardo Soares 3", "029.215.226-40", 1000.00, Instant.now(), 2));
		
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
