package controller;

import domain.City;
import dto.CityListResponseDTO;
import dto.CityResponseDTO;
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
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping
    public CityListResponseDTO getAll(){
        List<City> cities = cityService.getAll();
        List<CityResponseDTO> convert = CityResponseDTOMapper.INSTANCE.convert(cities);
        return new CityListResponseDTO(convert);
    }

}
