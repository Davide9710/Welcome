package domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Message.class)
public abstract class Message_ {

	public static volatile SingularAttribute<Message, PlatformUser> receiver;
	public static volatile SingularAttribute<Message, Instant> creationTime;
	public static volatile SingularAttribute<Message, PlatformUser> sender;
	public static volatile SingularAttribute<Message, Long> id;
	public static volatile SingularAttribute<Message, String> content;

	public static final String RECEIVER = "receiver";
	public static final String CREATION_TIME = "creationTime";
	public static final String SENDER = "sender";
	public static final String ID = "id";
	public static final String CONTENT = "content";

}

