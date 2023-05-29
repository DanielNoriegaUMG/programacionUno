package com.programacion.db;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-23T23:54:55", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Airplains.class)
public class Airplains_ { 

    public static volatile SingularAttribute<Airplains, String> marca;
    public static volatile SingularAttribute<Airplains, String> motor;
    public static volatile SingularAttribute<Airplains, String> gasolina;
    public static volatile SingularAttribute<Airplains, String> matricula;
    public static volatile SingularAttribute<Airplains, BigInteger> numPasajeros;
    public static volatile SingularAttribute<Airplains, BigDecimal> id;
    public static volatile SingularAttribute<Airplains, BigInteger> modelo;

}