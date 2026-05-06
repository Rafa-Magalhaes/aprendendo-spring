package com.rafael.aprendendo_spring.infrastructure.repository;

import com.rafael.aprendendo_spring.infrastructure.entity.Telefones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonesRepository extends JpaRepository <Telefones, Long> {
}
