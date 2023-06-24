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

    /**
     * a Back Office method that allows the developers to add new cities, cleaning up the city cache
     * @param request name of the city to be created
     */
    @CacheEvict(cacheNames = "allCities", allEntries = true)
    public void create(CreateCityRequestBO request){
        City city = City.builder().name(request.name()).build();
        cityRepository.save(city);
    }
}
