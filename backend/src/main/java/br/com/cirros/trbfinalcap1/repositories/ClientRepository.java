package br.com.cirros.trbfinalcap1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cirros.trbfinalcap1.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
