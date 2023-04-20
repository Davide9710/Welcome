package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Image.class)
public abstract class Image_ {

	public static volatile SingularAttribute<Image, Byte[]> image;
	public static volatile SingularAttribute<Image, Review> review;
	public static volatile SingularAttribute<Image, TourStop> tourStop;
	public static volatile SingularAttribute<Image, Long> id;

	public static final String IMAGE = "image";
	public static final String REVIEW = "review";
	public static final String TOUR_STOP = "tourStop";
	public static final String ID = "id";

}

