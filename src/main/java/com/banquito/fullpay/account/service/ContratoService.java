package com.banquito.fullpay.account.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.account.dto.ContratoDTO;
import com.banquito.fullpay.account.util.mapper.ContratoMapper;
import com.banquito.fullpay.account.model.Contrato;
import com.banquito.fullpay.account.repository.ContratoRepository;

import jakarta.transaction.Transactional;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;

    private final ContratoMapper contratoMapper;

    public ContratoService(ContratoRepository contratoRepository, ContratoMapper contratoMapper) {
        this.contratoRepository = contratoRepository;
        this.contratoMapper = contratoMapper;
    }

    @Transactional(Transactional.TxType.NEVER)
    public ContratoDTO obtainContratoById(Integer id) {
        Optional<Contrato> contrato = this.contratoRepository.findById(id);
        if (contrato.isPresent()) {
            return contratoMapper.toDTO(contrato.get());
        } else {
            throw new RuntimeException("Contrato no encontrado");
        }
    }

    @Transactional
    public ContratoDTO inactivateContrato(Integer id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        contrato.setEstado("INA");
        return contratoMapper.toDTO(contratoRepository.save(contrato));
    }

    @Transactional
    public ContratoDTO activateContrato(Integer id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        contrato.setEstado("ACT");
        return contratoMapper.toDTO(contratoRepository.save(contrato));
    }

    public List<ContratoDTO> getContratosByDateRange(Date fechaInicio, Date fechaFin) {
        try {
            return contratoRepository.findByFechaInicioBetween(fechaInicio, fechaFin).stream()
                    .map(contratoMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener contratos por rango de fechas", e);
        }
    }

}
