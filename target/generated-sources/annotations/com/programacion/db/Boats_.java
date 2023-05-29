package com.programacion.db;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-28T22:08:05", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Boats.class)
public class Boats_ { 

    public static volatile SingularAttribute<Boats, String> marca;
    public static volatile SingularAttribute<Boats, String> motor;
    public static volatile SingularAttribute<Boats, String> gasolina;
    public static volatile SingularAttribute<Boats, String> matricula;
    public static volatile SingularAttribute<Boats, Short> remos;
    public static volatile SingularAttribute<Boats, BigDecimal> id;

}