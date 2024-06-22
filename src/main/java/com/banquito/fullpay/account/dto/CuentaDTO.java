package com.banquito.fullpay.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CuentaDTO {
    private Long id;
    private Long codEmpresa;
    private String numCuenta;
    private String tipoCuenta;
    private BigDecimal saldoDisponible;
    private BigDecimal saldoContable;
    private String estado;
    private LocalDateTime fechaUltModificacion;
}

