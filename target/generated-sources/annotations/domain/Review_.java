package domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Review.class)
public abstract class Review_ {

	public static volatile ListAttribute<Review, Image> images;
	public static volatile SingularAttribute<Review, Tourist> author;
	public static volatile SingularAttribute<Review, Instant> creationTimestamp;
	public static volatile SingularAttribute<Review, Long> id;
	public static volatile SingularAttribute<Review, Integer> stars;
	public static volatile SingularAttribute<Review, String> title;
	public static volatile SingularAttribute<Review, String> content;
	public static volatile SingularAttribute<Review, Tour> tour;

	public static final String IMAGES = "images";
	public static final String AUTHOR = "author";
	public static final String CREATION_TIMESTAMP = "creationTimestamp";
	public static final String ID = "id";
	public static final String STARS = "stars";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String TOUR = "tour";

}

