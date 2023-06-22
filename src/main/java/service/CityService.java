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

    @Cacheable(cacheNames = "allCities")
    public List<City> getAll() {
        return cityRepository.findAll();
    }

}
