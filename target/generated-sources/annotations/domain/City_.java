package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(City.class)
public abstract class City_ {

	public static volatile ListAttribute<City, Guide> guideList;
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, Long> id;

	public static final String GUIDE_LIST = "guideList";
	public static final String NAME = "name";
	public static final String ID = "id";

}
