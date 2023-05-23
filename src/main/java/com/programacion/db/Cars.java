/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author Daniel Noriega
 */
@Entity
@Table(name = "CARS", catalog = "", schema = "SYSTEM", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"MATRICULA"})})
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", precision = 38, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "MATRICULA", nullable = false, length = 8)
    private String matricula;
    @Basic(optional = false)
    @Column(name = "MARCA", nullable = false, length = 30)
    private String marca;
    @Column(name = "MODELO")
    private BigInteger modelo;
    @Column(name = "MOTOR", length = 25)
    private String motor;
    @Basic(optional = false)
    @Column(name = "GASOLINA", nullable = false, length = 20)
    private String gasolina;
    @Basic(optional = false)
    @Column(name = "RUEDAS", nullable = false)
    private BigInteger ruedas;
    @Basic(optional = false)
    @Column(name = "PUERTAS", nullable = false)
    private BigInteger puertas;

    public Cars() {
    }

    public Cars(BigDecimal id) {
        this.id = id;
    }

    public Cars(BigDecimal id, String matricula, String marca, String gasolina, BigInteger ruedas, BigInteger puertas) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.gasolina = gasolina;
        this.ruedas = ruedas;
        this.puertas = puertas;
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

    public BigInteger getModelo() {
        return modelo;
    }

    public void setModelo(BigInteger modelo) {
        this.modelo = modelo;
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

    public BigInteger getRuedas() {
        return ruedas;
    }

    public void setRuedas(BigInteger ruedas) {
        this.ruedas = ruedas;
    }

    public BigInteger getPuertas() {
        return puertas;
    }

    public void setPuertas(BigInteger puertas) {
        this.puertas = puertas;
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
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "com.programacion.db.Cars[ id=" + id + " ]";
        String txt = getMatricula() + " " + getMarca() + " " + getMotor() + " " + getGasolina() + " " + getModelo() + " " + getRuedas() + " " +  getPuertas();
        return txt;
    }
    
}
