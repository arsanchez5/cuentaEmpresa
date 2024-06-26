package com.banquito.fullpay.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.account.model.Empresa;
import com.banquito.fullpay.account.repository.EmpresaRepository;

@Service
public class EmpresaService {
    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> obtainAllEmpresa() {
        return empresaRepository.findAll();
    }

    public Empresa obtainEmpresaById(Integer id) {
        Optional<Empresa> empresaOpt = this.empresaRepository.findById(id);
        if (empresaOpt.isPresent()) {
            return empresaOpt.get();
        } else {
            throw new RuntimeException("No existe la empresa con el id: " + id);
        }

    }

    public Empresa CreateEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteEmpresa(Integer id) {
        Optional<Empresa> empresa = this.empresaRepository.findById(id);
        if (empresa.isPresent()) {
            Empresa empresaOpt = empresa.get();
            empresaOpt.setEstado("INA");
            empresaRepository.save(empresaOpt);
        } else {
            throw new RuntimeException("No existe la empresa con el id: " + id);
        }
    }

}
