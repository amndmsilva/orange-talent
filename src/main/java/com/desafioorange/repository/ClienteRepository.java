package com.desafioorange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafioorange.model.Client;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long> {

}
