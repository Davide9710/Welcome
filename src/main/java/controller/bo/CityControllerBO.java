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

@RestController
@RequestMapping(value = "/bo/city", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class CityControllerBO {
    private final CityServiceBO cityServiceBO;

    @PostMapping("/create")
    @Log
    public ResponseEntity<?> create(@RequestBody CreateCityRequestBO request){
        cityServiceBO.create(request);
        return ResponseEntity.ok().build();
    }
}
