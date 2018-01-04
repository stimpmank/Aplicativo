/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author czambrano
 */
@Embeddable
public class SapermisoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String spmcusuari;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String spmcprogra;

    public SapermisoPK() {
    }

    public SapermisoPK(String spmcusuari, String spmcprogra) {
        this.spmcusuari = spmcusuari;
        this.spmcprogra = spmcprogra;
    }

    public String getSpmcusuari() {
        return spmcusuari;
    }

    public void setSpmcusuari(String spmcusuari) {
        this.spmcusuari = spmcusuari;
    }

    public String getSpmcprogra() {
        return spmcprogra;
    }

    public void setSpmcprogra(String spmcprogra) {
        this.spmcprogra = spmcprogra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spmcusuari != null ? spmcusuari.hashCode() : 0);
        hash += (spmcprogra != null ? spmcprogra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SapermisoPK)) {
            return false;
        }
        SapermisoPK other = (SapermisoPK) object;
        if ((this.spmcusuari == null && other.spmcusuari != null) || (this.spmcusuari != null && !this.spmcusuari.equals(other.spmcusuari))) {
            return false;
        }
        if ((this.spmcprogra == null && other.spmcprogra != null) || (this.spmcprogra != null && !this.spmcprogra.equals(other.spmcprogra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.SapermisoPK[ spmcusuari=" + spmcusuari + ", spmcprogra=" + spmcprogra + " ]";
    }
    
}
