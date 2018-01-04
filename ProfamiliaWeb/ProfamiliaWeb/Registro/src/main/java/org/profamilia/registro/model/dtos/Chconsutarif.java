package org.profamilia.registro.model.dtos;

import java.math.BigDecimal;
import org.profamilia.registro.model.entities.Cpservicio;

public class Chconsutarif {

 



    private Cpservicio material;
    
    private java.lang.String nombreMaterial;
    
    private java.lang.Integer cantidadMaterial;
    
    private java.lang.String lugarServicio;
 
    private BigDecimal importeJoven;
    
    private BigDecimal importeJovenAdulto;
    
    private BigDecimal importeAdulto;
    
    private BigDecimal importeParticular;
    
    private BigDecimal importeEmpleado;
    
    private BigDecimal descuentoJoven;
    
    private BigDecimal descuentoJovenAdulto;
    
    private BigDecimal descuentoAdulto;
    
    private BigDecimal descuentoParticular;
    
    private BigDecimal descuentoEmpleado;

    private BigDecimal totalJoven;
    
    private BigDecimal totalJovenAdulto;
    
    private BigDecimal totalAdulto;
    
    private BigDecimal totalParticular;
    
    private BigDecimal totalEmpleado;
    
   

    public Chconsutarif() {
    }

    public void setMaterial(Cpservicio material) {
        this.material = material;
    }

    public Cpservicio getMaterial() {
        return material;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setCantidadMaterial(Integer cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public Integer getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setLugarServicio(String lugarServicio) {
        this.lugarServicio = lugarServicio;
    }

    public String getLugarServicio() {
        return lugarServicio;
    }

    public void setImporteJoven(BigDecimal importeJoven) {
        this.importeJoven = importeJoven;
    }

    public BigDecimal getImporteJoven() {
        return importeJoven;
    }

    public void setImporteJovenAdulto(BigDecimal importeJovenAdulto) {
        this.importeJovenAdulto = importeJovenAdulto;
    }

    public BigDecimal getImporteJovenAdulto() {
        return importeJovenAdulto;
    }

    public void setImporteAdulto(BigDecimal importeAdulto) {
        this.importeAdulto = importeAdulto;
    }

    public BigDecimal getImporteAdulto() {
        return importeAdulto;
    }

    public void setImporteParticular(BigDecimal importeParticular) {
        this.importeParticular = importeParticular;
    }

    public BigDecimal getImporteParticular() {
        return importeParticular;
    }

    public void setImporteEmpleado(BigDecimal importeEmpleado) {
        this.importeEmpleado = importeEmpleado;
    }

    public BigDecimal getImporteEmpleado() {
         return importeEmpleado;
    }

    public void setDescuentoJoven(BigDecimal descuentoJoven) {
        this.descuentoJoven = descuentoJoven;
    }

    public BigDecimal getDescuentoJoven() {
           return descuentoJoven;
    }

    public void setDescuentoJovenAdulto(BigDecimal descuentoJovenAdulto) {
        this.descuentoJovenAdulto = descuentoJovenAdulto;
    }

    public BigDecimal getDescuentoJovenAdulto() {
   
        return descuentoJovenAdulto;
    }

    public void setDescuentoAdulto(BigDecimal descuentoAdulto) {
        this.descuentoAdulto = descuentoAdulto;
    }

    public BigDecimal getDescuentoAdulto() {
  
        return descuentoAdulto;
    }

    public void setDescuentoParticular(BigDecimal descuentoParticular) {
        this.descuentoParticular = descuentoParticular;
    }

    public BigDecimal getDescuentoParticular() {
 
        return descuentoParticular;
    }

    public void setDescuentoEmpleado(BigDecimal descuentoEmpleado) {
        this.descuentoEmpleado = descuentoEmpleado;
    }

    public BigDecimal getDescuentoEmpleado() {
  
        return descuentoEmpleado;
    }

    public void setTotalJoven(BigDecimal totalJoven) {
        this.totalJoven = totalJoven;
    }

    public BigDecimal getTotalJoven() {
   
        return totalJoven;
    }

    public void setTotalJovenAdulto(BigDecimal totalJovenAdulto) {
        this.totalJovenAdulto = totalJovenAdulto;
    }

    public BigDecimal getTotalJovenAdulto() {
    return totalJovenAdulto;
    }

    public void setTotalAdulto(BigDecimal totalAdulto) {
        this.totalAdulto = totalAdulto;
    }

    public BigDecimal getTotalAdulto() {
     return totalAdulto;
    }

    public void setTotalParticular(BigDecimal totalParticular) {
        this.totalParticular = totalParticular;
    }

    public BigDecimal getTotalParticular() {
   return totalParticular;
    }

    public void setTotalEmpleado(BigDecimal totalEmpleado) {
        this.totalEmpleado = totalEmpleado;
    }

    public BigDecimal getTotalEmpleado() {
       return totalEmpleado;
    }
}
