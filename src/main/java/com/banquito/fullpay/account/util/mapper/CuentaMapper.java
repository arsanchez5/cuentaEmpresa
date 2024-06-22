package com.banquito.fullpay.account.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.fullpay.account.dto.CuentaDTO;
import com.banquito.fullpay.account.model.Cuenta;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CuentaMapper {
    CuentaDTO toDTO(Cuenta cuenta);
    Cuenta toPersistence(CuentaDTO cuentaDTO);
}
