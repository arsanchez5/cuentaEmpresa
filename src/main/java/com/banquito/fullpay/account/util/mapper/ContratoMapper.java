package com.banquito.fullpay.account.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.fullpay.account.dto.ContratoDTO;
import com.banquito.fullpay.account.model.Contrato;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContratoMapper {
    ContratoDTO toDTO(Contrato contrato);

    Contrato toEntity(ContratoDTO contratoDTO);
}
