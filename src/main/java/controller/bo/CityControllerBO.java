package controller.bo;

import aspects.logging.Log;
import dto.bo.CreateCityRequestBO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.bo.CityServiceBO;

/**
 * BO controller with utility endpoint about the city; it authorizes request only from the ADMIN role
 */
@RestController
@RequestMapping(value = "/bo/city", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class CityControllerBO {
    private final CityServiceBO cityServiceBO;

    /**
     * Post Endpoint that create a new city
     * @param request city data
     * @return Response Entity indicating the operation result
     */
    @PostMapping("/create")
    @Log
    public ResponseEntity<?> create(@RequestBody CreateCityRequestBO request){
        cityServiceBO.create(request);
        return ResponseEntity.ok().build();
    }
}
