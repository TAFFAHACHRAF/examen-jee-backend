package com.taffah.springjwt.repository;

import com.taffah.springjwt.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
