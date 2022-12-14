package com.pdfinspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdfinspringboot.Entity.Allowance;
import com.pdfinspringboot.Entity.Intern;

@Repository
public interface AllowanceRepository extends JpaRepository<Allowance, Long> {}