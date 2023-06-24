package service.unittest;

import domain.City;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import repository.CityRepository;
import service.CityService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CityServiceTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Autowired
        CityRepository cityRepository;

        @Bean
        public CityService cityService() {
            return new CityService(cityRepository);
        }
    }

    @MockBean
    CityRepository cityRepository;

    @Autowired
    CityService cityService;

    @Test
    public void getAll(){
        //given

        City mockCity = new City();
        String mockCityName = "mockCityName";
        mockCity.setName(mockCityName);
        Mockito.when(cityRepository.findAll()).thenReturn(List.of(mockCity));

        //when
        List<City> allCities = cityService.getAll();

        //then
        assertNotNull(allCities);
        assertEquals(allCities.size(), 1);
        assertNotNull(allCities.get(0));
        assertEquals(allCities.get(0).getName(), mockCityName);
    }
}
