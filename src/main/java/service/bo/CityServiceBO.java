package service.bo;

import domain.City;
import dto.bo.CreateCityRequestBO;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import repository.CityRepository;

@Service
@RequiredArgsConstructor
public class CityServiceBO {
    private final CityRepository cityRepository;

    @CacheEvict(cacheNames = "allCities", allEntries = true)
    public void create(CreateCityRequestBO request){
        City city = City.builder().name(request.name()).build();
        cityRepository.save(city);
    }
}
