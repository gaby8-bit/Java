package com.exemplu.repository;

import com.exemplu.entity.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilizatorRepository extends JpaRepository<Utilizator, Integer> {
    Optional<Utilizator> findByUtilizator(String utilizator);

}
