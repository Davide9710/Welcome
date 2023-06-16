package controller;

import domain.City;
import dto.CityResponseDTO;
import dto.GetAllCityResponseDTO;
import lombok.RequiredArgsConstructor;
import mapper.CityResponseDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CityService;

import java.util.List;

@RestController
@RequestMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public GetAllCityResponseDTO getAll(){
        List<City> cities = cityService.getAll();
        return new GetAllCityResponseDTO(CityResponseDTOMapper.INSTANCE.convert(cities));
    }

}
