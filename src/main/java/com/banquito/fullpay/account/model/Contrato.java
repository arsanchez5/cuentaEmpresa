package com.banquito.fullpay.account.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COR_CONTRATO", schema = "cobrosrecaudos")
public class Contrato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CONTRATO", nullable = false)
    private Integer codContrato;
    @Column(name = "COD_EMPRESA", nullable = false)
    private Integer codEmpresa;
    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_INICIO")
    private LocalDateTime fechaInicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_FIN")
    private LocalDateTime fechaFin;

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
    private Empresa empresa;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codContrato == null) ? 0 : codContrato.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contrato other = (Contrato) obj;
        if (codContrato == null) {
            if (other.codContrato != null)
                return false;
        } else if (!codContrato.equals(other.codContrato))
            return false;
        return true;
    }

}
