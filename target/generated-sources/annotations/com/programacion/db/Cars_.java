package com.programacion.db;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-21T22:50:11", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Cars.class)
public class Cars_ { 

    public static volatile SingularAttribute<Cars, String> marca;
    public static volatile SingularAttribute<Cars, String> motor;
    public static volatile SingularAttribute<Cars, BigInteger> puertas;
    public static volatile SingularAttribute<Cars, String> gasolina;
    public static volatile SingularAttribute<Cars, String> matricula;
    public static volatile SingularAttribute<Cars, BigDecimal> id;
    public static volatile SingularAttribute<Cars, BigInteger> ruedas;
    public static volatile SingularAttribute<Cars, BigInteger> modelo;

}