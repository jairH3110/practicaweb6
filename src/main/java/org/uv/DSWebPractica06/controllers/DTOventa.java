/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWebPractica06.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.uv.DSWebPractica06.data.Detalleventa;

/**
 *
 * @author jair
 */
public class DTOventa {
    private Long id;
    private String fecha ;
    private BigDecimal total;
    private List<Detalleventa> lstcalldetalle = new ArrayList();

    public DTOventa(Long id, String fecha, BigDecimal total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Detalleventa> getLstcalldetalle() {
        return lstcalldetalle;
    }

    public void setLstcalldetalle(List<Detalleventa> lstcalldetalle) {
        this.lstcalldetalle = lstcalldetalle;
    }

    @Override
    public String toString() {
        return "DTOventa{" + "id=" + id + ", fecha=" + fecha + ", total=" + total + ", lstcalldetalle=" + lstcalldetalle + '}';
    }
    
}
