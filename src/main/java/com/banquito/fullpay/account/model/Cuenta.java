package com.banquito.fullpay.account.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "COR_CUENTA")
public class Cuenta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CUENTA", nullable = false)
    private Long id;
    @Column(name = "COD_EMPRESA", nullable = false)
    private Long codEmpresa;
    @Column(name = "NUMERO_CUENTA", length = 10, nullable = false)
    private String numCuenta;
    @Column(name = "TIPO_CUENTA", length = 3, nullable = false)
    private String tipoCuenta;
    @Column(name = "SALDO_DISPONIBLE", precision = 17, scale = 2, nullable = false)
    private BigDecimal saldoDisponible;
    @Column(name = "SALDO_CONTABLE", precision = 17, scale = 2, nullable = false)
    private BigDecimal saldoContable;
    @Column(name = "ESTADO", length = 3, nullable = false)
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CREACION")
    private LocalDateTime fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ULT_MODIFICACION", nullable = false)
    private LocalDateTime fechaUltModificacion;

    @ManyToOne
    @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
    private Empresa empresa;

    public Cuenta(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Cuenta other = (Cuenta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
