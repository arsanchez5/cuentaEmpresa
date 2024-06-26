package com.banquito.fullpay.account.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Value;

@Value
@Builder

public class ContratoDTO {
    private Integer codContrato;
    private Integer codEmpresa;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;
}
