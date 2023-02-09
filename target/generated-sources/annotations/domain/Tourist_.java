package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tourist.class)
public abstract class Tourist_ {

	public static volatile ListAttribute<Tourist, Report> reports;
	public static volatile ListAttribute<Tourist, Review> reviews;
	public static volatile ListAttribute<Tourist, Suggestion> suggestions;
	public static volatile SingularAttribute<Tourist, Long> id;
	public static volatile ListAttribute<Tourist, Tour> tours;

	public static final String REPORTS = "reports";
	public static final String REVIEWS = "reviews";
	public static final String SUGGESTIONS = "suggestions";
	public static final String ID = "id";
	public static final String TOURS = "tours";

}

