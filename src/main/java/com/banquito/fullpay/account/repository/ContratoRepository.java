package com.banquito.fullpay.account.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.fullpay.account.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

    List<Contrato> findByFechaInicioBetween(Date startDate, Date endDate);
}
