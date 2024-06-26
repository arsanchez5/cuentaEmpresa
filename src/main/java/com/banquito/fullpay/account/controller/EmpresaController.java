package com.banquito.fullpay.account.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.fullpay.account.model.Empresa;
import com.banquito.fullpay.account.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Integer id){
        try {
            Empresa empresa = empresaService.obtainEmpresaById(id);
            return ResponseEntity.ok(empresa);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresas(){
        List<Empresa> empresas = empresaService.obtainAllEmpresa();
        return ResponseEntity.ok(empresas);
    }

    @PostMapping("/create")
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa){
        Empresa empresaCreated = empresaService.CreateEmpresa(empresa);
        return ResponseEntity.ok(empresaCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Integer id){
        empresaService.deleteEmpresa(id);
        return ResponseEntity.noContent().build();
    }

    
}
