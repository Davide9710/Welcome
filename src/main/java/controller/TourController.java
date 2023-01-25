package controller;


import com.google.common.base.Preconditions;
import domain.Tour;
import dto.CreateTourRequestDTO;
import dto.CreateTourResponseDTO;
import dto.TourResponseDTO;
import mapper.CreateTourRequestDTOMapper;
import mapper.CreateTourResponseDTOMapper;
import mapper.TourResponseDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TourService;

@RestController
@RequestMapping(value = "/tour", produces = MediaType.APPLICATION_JSON_VALUE)
public class TourController {
    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/{id}")
    public TourResponseDTO get(@PathVariable("id") Long id){
        Preconditions.checkNotNull(id);

        Tour tour = tourService.getTour(id);
        return TourResponseDTOMapper.INSTANCE.convert(tour);
    }

    @PostMapping("/create")
    public CreateTourResponseDTO create(@RequestBody CreateTourRequestDTO createTourRequestDTO){
        Tour tour = CreateTourRequestDTOMapper.INSTANCE.convert(createTourRequestDTO);
        Tour savedTour = tourService.create(tour);
        return CreateTourResponseDTOMapper.INSTANCE.convert(savedTour);
    }
}
