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

/**
 *
 * @author czambrano
 */
@Embeddable
public class CpmunidanePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short cmdncoddep;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short cmdncodmun;

    public CpmunidanePK() {
    }

    public CpmunidanePK(short cmdncoddep, short cmdncodmun) {
        this.cmdncoddep = cmdncoddep;
        this.cmdncodmun = cmdncodmun;
    }

    public short getCmdncoddep() {
        return cmdncoddep;
    }

    public void setCmdncoddep(short cmdncoddep) {
        this.cmdncoddep = cmdncoddep;
    }

    public short getCmdncodmun() {
        return cmdncodmun;
    }

    public void setCmdncodmun(short cmdncodmun) {
        this.cmdncodmun = cmdncodmun;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cmdncoddep;
        hash += (int) cmdncodmun;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CpmunidanePK)) {
            return false;
        }
        CpmunidanePK other = (CpmunidanePK) object;
        if (this.cmdncoddep != other.cmdncoddep) {
            return false;
        }
        if (this.cmdncodmun != other.cmdncodmun) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.CpmunidanePK[ cmdncoddep=" + cmdncoddep + ", cmdncodmun=" + cmdncodmun + " ]";
    }
    
}
