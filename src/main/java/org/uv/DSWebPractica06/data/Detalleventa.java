/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWebPractica06.data;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author jair
 */
@Entity
@Table(name="detalleventa")
public class Detalleventa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalleventa_id_seq")
    @SequenceGenerator(name = "detalleventa_id_seq", sequenceName = "detalleventa_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "iddetalleventa")
    private Long idDetalleVenta;
    

    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "precio")
    private BigDecimal precio;
    

    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "subtotal")
    private double subtotal;

        @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venta")
    private venta venta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public venta getVenta() {
        return venta;
    }

    public void setVenta(venta venta) {
        this.venta = venta;
    }

  

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

  
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Detalleventa{" + "idDetalleVenta=" + idDetalleVenta + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", venta=" + venta + '}';
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
