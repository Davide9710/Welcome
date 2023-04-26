package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transport.class)
public abstract class Transport_ {

	public static volatile SingularAttribute<Transport, String> transportDetails;
	public static volatile SingularAttribute<Transport, String> transportOtherOptions;
	public static volatile SingularAttribute<Transport, Double> transportCost;
	public static volatile SingularAttribute<Transport, String> transportType;
	public static volatile SingularAttribute<Transport, String> transportDuration;

	public static final String TRANSPORT_DETAILS = "transportDetails";
	public static final String TRANSPORT_OTHER_OPTIONS = "transportOtherOptions";
	public static final String TRANSPORT_COST = "transportCost";
	public static final String TRANSPORT_TYPE = "transportType";
	public static final String TRANSPORT_DURATION = "transportDuration";

}

