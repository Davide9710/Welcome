package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Report.class)
public abstract class Report_ {

	public static volatile SingularAttribute<Report, String> reason;
	public static volatile SingularAttribute<Report, Tourist> author;
	public static volatile SingularAttribute<Report, Long> id;
	public static volatile SingularAttribute<Report, Tour> tour;

	public static final String REASON = "reason";
	public static final String AUTHOR = "author";
	public static final String ID = "id";
	public static final String TOUR = "tour";

}

