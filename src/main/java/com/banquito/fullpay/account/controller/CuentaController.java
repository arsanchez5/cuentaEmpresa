package com.banquito.fullpay.account.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.fullpay.account.dto.CuentaDTO;
import com.banquito.fullpay.account.model.Cuenta;
import com.banquito.fullpay.account.service.CuentaService;
import com.banquito.fullpay.account.util.mapper.CuentaMapper;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
    private final CuentaService cuentaService;
    private final CuentaMapper cuentaMapper;

    public CuentaController(CuentaService cuentaService, CuentaMapper cuentaMapper) {
        this.cuentaService = cuentaService;
        this.cuentaMapper = cuentaMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaDTO> getCuentaById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(this.cuentaMapper.toDTO(this.cuentaService.obtainCuentaById(id)));
        } catch (RuntimeException rte) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity <List<CuentaDTO>> getAllCuenta(){
        List<Cuenta> cuentas = this.cuentaService.obtainAll();
        return ResponseEntity.ok(cuentas.stream().map(c -> this.cuentaMapper.toDTO(c)).collect(Collectors.toList()));
    }

    @PostMapping("/create")
    public ResponseEntity<CuentaDTO> createCuenta(@RequestBody CuentaDTO dto){
        CuentaDTO cuentaCreated = cuentaService.saveCuenta(dto);
        return ResponseEntity.ok(cuentaCreated);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCuenta(@PathVariable Integer id){
        cuentaService.deleteCuenta(id);
        return ResponseEntity.notFound().build();
    }

}
