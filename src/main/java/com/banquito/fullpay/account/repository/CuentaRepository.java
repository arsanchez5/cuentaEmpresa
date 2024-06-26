package com.banquito.fullpay.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banquito.fullpay.account.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
    
}
