package service;

import domain.City;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import repository.CityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    /**
     * Method that return all the cities in the db; it leverages the facts that the city list rarely changes and
     * it can be cached, both at the db-level (from Hibernate) and in-memory level (spring cache)
     * @return a list of cities
     */
    @Cacheable(cacheNames = "allCities")
    public List<City> getAll() {
        return cityRepository.findAll();
    }

}
