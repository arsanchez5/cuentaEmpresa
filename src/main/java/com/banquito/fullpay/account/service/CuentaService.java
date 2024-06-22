package com.banquito.fullpay.account.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.account.dto.CuentaDTO;
import com.banquito.fullpay.account.model.Cuenta;
import com.banquito.fullpay.account.repository.CuentaRepository;
import com.banquito.fullpay.account.util.mapper.CuentaMapper;

@Service
public class CuentaService {
    private final CuentaRepository cuentaRepository;
    private final CuentaMapper cuentaMapper;

    public CuentaService(CuentaRepository cuentaRepository, CuentaMapper cuentaMapper) {
        this.cuentaRepository = cuentaRepository;
        this.cuentaMapper = cuentaMapper;
    }

    public Cuenta obtainCuentaById(Long id){
        Optional<Cuenta> cuentaOpt = this.cuentaRepository.findById(id);
        if (cuentaOpt.isPresent()){
            return cuentaOpt.get();
        }else{
            throw new RuntimeException("No existe la cuenta con el id: " + id);
        }
    }

    public CuentaDTO saveCuenta(CuentaDTO dto){
        Cuenta cuenta = this.cuentaMapper.toPersistence(dto);
        cuenta.setFechaCreacion(LocalDateTime.now());
        Cuenta cuentaCreated = this.cuentaRepository.save(cuenta);
        return this.cuentaMapper.toDTO(cuentaCreated);
    }

    public void deleteCuenta(Long id){
        this.cuentaRepository.deleteById(id);
    }

    public List<Cuenta> obtainAll(){
        return this.cuentaRepository.findAll();
    }



}
