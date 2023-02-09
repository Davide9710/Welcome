package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tag.class)
public abstract class Tag_ {

	public static volatile SingularAttribute<Tag, String> name;
	public static volatile SingularAttribute<Tag, Long> id;
	public static volatile ListAttribute<Tag, Tour> tours;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TOURS = "tours";

}

