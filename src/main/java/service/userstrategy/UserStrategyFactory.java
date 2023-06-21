package service.userstrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import value.Role;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class UserStrategyFactory {
    private Map<Role, UserStrategy> strategies;

    @Autowired
    public UserStrategyFactory(Set<UserStrategy> strategies){
        createStrategies(strategies);
    }

    private void createStrategies(Set<UserStrategy> strategies) {
        this.strategies = new HashMap<>();
        strategies.forEach(strategy -> this.strategies.put(strategy.getRole(), strategy));
    }

    public UserStrategy findStrategy(Role role){
        return this.strategies.get(role);
    }
}
