package domain;

import domain.Tour.TourStatus;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tour.class)
public abstract class Tour_ {

	public static volatile ListAttribute<Tour, Report> reports;
	public static volatile SingularAttribute<Tour, Instant> creationTime;
	public static volatile SingularAttribute<Tour, City> city;
	public static volatile SingularAttribute<Tour, String> title;
	public static volatile SetAttribute<Tour, Tag> tags;
	public static volatile SingularAttribute<Tour, Double> approxCost;
	public static volatile ListAttribute<Tour, Review> reviews;
	public static volatile SingularAttribute<Tour, Instant> lastUpdate;
	public static volatile SingularAttribute<Tour, String> approxDuration;
	public static volatile ListAttribute<Tour, TourStop> TourStops;
	public static volatile ListAttribute<Tour, Suggestion> suggestions;
	public static volatile SingularAttribute<Tour, Theme> theme;
	public static volatile SingularAttribute<Tour, Long> id;
	public static volatile SetAttribute<Tour, Tourist> tourists;
	public static volatile SingularAttribute<Tour, TourStatus> tourStatus;
	public static volatile SingularAttribute<Tour, Guide> guide;

	public static final String REPORTS = "reports";
	public static final String CREATION_TIME = "creationTime";
	public static final String CITY = "city";
	public static final String TITLE = "title";
	public static final String TAGS = "tags";
	public static final String APPROX_COST = "approxCost";
	public static final String REVIEWS = "reviews";
	public static final String LAST_UPDATE = "lastUpdate";
	public static final String APPROX_DURATION = "approxDuration";
	public static final String TOUR_STOPS = "TourStops";
	public static final String SUGGESTIONS = "suggestions";
	public static final String THEME = "theme";
	public static final String ID = "id";
	public static final String TOURISTS = "tourists";
	public static final String TOUR_STATUS = "tourStatus";
	public static final String GUIDE = "guide";

}

