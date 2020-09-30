package br.com.cirros.trbfinalcap1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cirros.trbfinalcap1.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
