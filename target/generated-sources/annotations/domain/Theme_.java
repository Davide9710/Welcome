package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Theme.class)
public abstract class Theme_ {

	public static volatile SingularAttribute<Theme, String> name;
	public static volatile SingularAttribute<Theme, Long> id;
	public static volatile ListAttribute<Theme, Tour> tours;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TOURS = "tours";

}

