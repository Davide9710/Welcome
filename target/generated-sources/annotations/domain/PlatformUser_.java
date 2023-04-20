package domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PlatformUser.class)
public abstract class PlatformUser_ extends domain.User_ {

	public static volatile SingularAttribute<PlatformUser, String> firstName;
	public static volatile SingularAttribute<PlatformUser, String> lastName;
	public static volatile ListAttribute<PlatformUser, Message> messagesReceived;
	public static volatile ListAttribute<PlatformUser, Message> messagesSend;
	public static volatile SingularAttribute<PlatformUser, Long> id;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String MESSAGES_RECEIVED = "messagesReceived";
	public static final String MESSAGES_SEND = "messagesSend";
	public static final String ID = "id";

}

