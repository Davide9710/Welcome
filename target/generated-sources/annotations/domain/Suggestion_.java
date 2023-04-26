package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Suggestion.class)
public abstract class Suggestion_ {

	public static volatile SingularAttribute<Suggestion, Tourist> author;
	public static volatile SingularAttribute<Suggestion, String> description;
	public static volatile SingularAttribute<Suggestion, TourStop> tourStop;
	public static volatile SingularAttribute<Suggestion, Long> id;
	public static volatile SingularAttribute<Suggestion, Tour> tour;

	public static final String AUTHOR = "author";
	public static final String DESCRIPTION = "description";
	public static final String TOUR_STOP = "tourStop";
	public static final String ID = "id";
	public static final String TOUR = "tour";

}

