package com.banquito.fullpay.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.fullpay.account.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
}
