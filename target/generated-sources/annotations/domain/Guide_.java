package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Guide.class)
public abstract class Guide_ extends domain.PlatformUser_ {

	public static volatile SingularAttribute<Guide, String> organizationName;
	public static volatile SingularAttribute<Guide, City> city;
	public static volatile SingularAttribute<Guide, Long> id;
	public static volatile ListAttribute<Guide, Tour> tours;

	public static final String ORGANIZATION_NAME = "organizationName";
	public static final String CITY = "city";
	public static final String ID = "id";
	public static final String TOURS = "tours";

}

