package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transport.class)
public abstract class Transport_ {

	public static volatile SingularAttribute<Transport, String> transferDetails;
	public static volatile SingularAttribute<Transport, String> transferType;
	public static volatile SingularAttribute<Transport, Double> transferCost;
	public static volatile SingularAttribute<Transport, String> otherOptions;
	public static volatile SingularAttribute<Transport, Long> transferDuration;

	public static final String TRANSFER_DETAILS = "transferDetails";
	public static final String TRANSFER_TYPE = "transferType";
	public static final String TRANSFER_COST = "transferCost";
	public static final String OTHER_OPTIONS = "otherOptions";
	public static final String TRANSFER_DURATION = "transferDuration";

}

