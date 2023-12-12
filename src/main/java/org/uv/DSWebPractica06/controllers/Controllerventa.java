/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DSWebPractica06.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.DSWebPractica06.data.Detalleventa;
import org.uv.DSWebPractica06.data.RepositoryDetalleventa;
import org.uv.DSWebPractica06.data.RepositoryEmpleado;

import org.uv.DSWebPractica06.data.RepositoryVenta;
import org.uv.DSWebPractica06.data.venta;

/**
 *
 * @author jair
 */
@Validated 
@RestController
@RequestMapping("/api/venta")
public class Controllerventa {
    
    @Autowired
    private RepositoryVenta repositoryVenta;
    
    @Autowired
    private RepositoryDetalleventa repositoryDetalle;
    
    
    @PostMapping
    public ResponseEntity<venta> post(@RequestBody DTOventa ventadto) {
        System.out.println(ventadto.toString());
        BigDecimal totalf = BigDecimal.ZERO;
    Date fecha = new Date(System.currentTimeMillis());
      
      
       Long idventa = ventadto.getId();
      
       venta venta = new venta(idventa,fecha,totalf  );
       
       venta.setVentaDetalles(  ventadto.getLstcalldetalle() )   ;  
      
       
       
       BigDecimal total = BigDecimal.ZERO;
        for (Detalleventa detalle : venta.getVentaDetalles()) {
            BigDecimal precio = detalle.getPrecio();
            int cantidad = detalle.getCantidad();
            total = total.add(precio.multiply(BigDecimal.valueOf(cantidad)));
            detalle.setVenta(venta);
        }

        venta.setTotal(total);
      
          venta empRes=repositoryVenta.save(venta);
        return ResponseEntity.ok(empRes);
        
        
        
    }
    
    @GetMapping()
    public List<venta> list() {
        return repositoryVenta.findAll();
    }
    
    @GetMapping("/{id}")
    public venta get(@PathVariable Long id) {
        Optional<venta> optRes=repositoryVenta.findById(id);
        return optRes.isPresent() ? optRes.get():null;
        
        
    }
//
//    @GetMapping("msg")
//    public String msg() {
//        return "Hola Mundo";
//    }
//      
//    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
}
