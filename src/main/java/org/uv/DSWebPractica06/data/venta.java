/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWebPractica06.data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jair
 */
@Entity
@Table(name="venta")
public class venta {
        @Id
    @GeneratedValue(generator = "venta_idventa_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "venta_idventa_seq",sequenceName = "venta_idventa_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "idventa")
    private Long idVenta;
    
    @Column(name = "fecha")
    private Date fecha;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "venta",cascade = CascadeType.ALL)
    private List<Detalleventa> ventaDetalles;

    
    @Column(name = "total")
    private BigDecimal total;
    
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "idempleado",referencedColumnName = "idempleado")
//   
//    private Empleado cli;
    


    public List<Detalleventa> getVentaDetalles() {
        return ventaDetalles;
    }

    public void setVentaDetalles(List<Detalleventa> ventaDetalles) {
        this.ventaDetalles = ventaDetalles;
    }
    
    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

//    public Empleado getCli() {
//        return cli;
//    }
//
//    public void setCli(Empleado cli) {
//        this.cli = cli;
//    }

    public venta(Long idVenta, Date fecha, BigDecimal total) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
    }

}
