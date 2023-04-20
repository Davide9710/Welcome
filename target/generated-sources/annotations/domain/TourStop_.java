package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TourStop.class)
public abstract class TourStop_ {

	public static volatile SingularAttribute<TourStop, String> duration;
	public static volatile ListAttribute<TourStop, Image> images;
	public static volatile SingularAttribute<TourStop, Double> cost;
	public static volatile SingularAttribute<TourStop, GeographicCoordinates> coordinates;
	public static volatile SingularAttribute<TourStop, Integer> index;
	public static volatile SingularAttribute<TourStop, String> description;
	public static volatile ListAttribute<TourStop, Suggestion> suggestions;
	public static volatile SingularAttribute<TourStop, Long> id;
	public static volatile SingularAttribute<TourStop, Transport> transport;
	public static volatile SingularAttribute<TourStop, String> title;
	public static volatile SingularAttribute<TourStop, Tour> tour;

	public static final String DURATION = "duration";
	public static final String IMAGES = "images";
	public static final String COST = "cost";
	public static final String COORDINATES = "coordinates";
	public static final String INDEX = "index";
	public static final String DESCRIPTION = "description";
	public static final String SUGGESTIONS = "suggestions";
	public static final String ID = "id";
	public static final String TRANSPORT = "transport";
	public static final String TITLE = "title";
	public static final String TOUR = "tour";

}

