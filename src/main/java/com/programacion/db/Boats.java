/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.db;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "BOATS", catalog = "", schema = "SYSTEM", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"MATRICULA"})})
@NamedQueries({
    @NamedQuery(name = "Boats.findAll", query = "SELECT b FROM Boats b")})
public class Boats implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "MATRICULA", nullable = false, length = 8)
    private String matricula;
    @Basic(optional = false)
    @Column(name = "MARCA", nullable = false, length = 30)
    private String marca;
    @Column(name = "MOTOR", length = 25)
    private String motor;
    @Basic(optional = false)
    @Column(name = "GASOLINA", nullable = false, length = 20)
    private String gasolina;
    @Column(name = "REMOS")
    private Short remos;

    public Boats() {
    }

    public Boats(BigDecimal id) {
        this.id = id;
    }

    public Boats(BigDecimal id, String matricula, String marca, String gasolina) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.gasolina = gasolina;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getGasolina() {
        return gasolina;
    }

    public void setGasolina(String gasolina) {
        this.gasolina = gasolina;
    }

    public Short getRemos() {
        return remos;
    }

    public void setRemos(Short remos) {
        this.remos = remos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boats)) {
            return false;
        }
        Boats other = (Boats) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.programacion.db.Boats[ id=" + id + " ]";
    }
    
}
