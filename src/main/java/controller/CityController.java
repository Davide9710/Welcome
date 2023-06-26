package controller;

import domain.City;
import dto.GetAllCityResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import mapper.CityResponseDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CityService;

import java.util.List;

/**
 * Controller that defined city's endpoint, reachable by platform users
 */
@RestController
@RequestMapping(value = "/city", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('GUIDE', 'TOURIST')")
public class CityController {

    private final CityService cityService;

    /**
     * Get Endpoint that return all the cities in the db
     * @return a list of cities
     */
    @GetMapping
    @Operation(summary = "get all cities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<GetAllCityResponseDTO> getAll() {
        List<City> cities = cityService.getAll();
        return ResponseEntity.ok(new GetAllCityResponseDTO(CityResponseDTOMapper.INSTANCE.convert(cities)));
    }
}
