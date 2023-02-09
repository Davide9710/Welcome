package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GeographicCoordinates.class)
public abstract class GeographicCoordinates_ {

	public static volatile SingularAttribute<GeographicCoordinates, Double> latitude;
	public static volatile SingularAttribute<GeographicCoordinates, Double> longitude;

	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";

}

