package service.userstrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import value.Role;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This factory method design pattern help the client to create the desired strategy using a map
 */
@Component
public class UserStrategyFactory {
    private Map<Role, UserStrategy> strategies;

    /**
     * This constructor leverage the Dependency Injection from Spring, the Set of Strategies are injected
     * @param strategies set of user strategies
     */
    @Autowired
    public UserStrategyFactory(Set<UserStrategy> strategies){
        createStrategies(strategies);
    }

    /**
     * Method that from a set of strategies populates a map
     * @param strategies set of user strategies
     */
    private void createStrategies(Set<UserStrategy> strategies) {
        this.strategies = new HashMap<>();
        strategies.forEach(strategy -> this.strategies.put(strategy.getRole(), strategy));
    }

    /**
     * Method that query the created map field
     * @param role the role of the wanted strategy
     * @return the user strategy found, if not found it returns null
     */
    public UserStrategy findStrategy(Role role){
        return this.strategies.get(role);
    }
}
