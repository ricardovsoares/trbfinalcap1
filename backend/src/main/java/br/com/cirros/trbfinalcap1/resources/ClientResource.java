package br.com.cirros.trbfinalcap1.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cirros.trbfinalcap1.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = new ArrayList<>();
		
		list.add(new Client(1L, "Ricardo Soares", "029.215.226-40", 1000.00, Instant.now(), 2));
		list.add(new Client(1L, "Ricardo Soares 1", "029.215.226-40", 1000.00, Instant.now(), 2));
		list.add(new Client(1L, "Ricardo Soares 2", "029.215.226-40", 1000.00, Instant.now(), 2));
		list.add(new Client(1L, "Ricardo Soares 3", "029.215.226-40", 1000.00, Instant.now(), 2));
		
		return ResponseEntity.ok().body(list);
	}
	
}
