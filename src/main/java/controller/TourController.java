package controller;


import domain.Tour;
import dto.CreateTourRequestDTO;
import dto.CreateTourResponseDTO;
import dto.EditTourRequestDTO;
import dto.EditTourResponseDTO;
import dto.SearchTourRequestDTO;
import dto.SearchTourResponseDTO;
import dto.TourResponseDTO;
import lombok.extern.slf4j.Slf4j;
import mapper.CreateTourRequestDTOMapper;
import mapper.CreateTourResponseDTOMapper;
import mapper.EditTourResponseDTOMapper;
import mapper.TourResponseDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TourService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tour",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TourController {
    private final TourService tourService;

    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/{id}")
    public TourResponseDTO get(@PathVariable("id") Long id){
        log.info("get tour, id {}", id);
        Tour tour = tourService.getTour(id);
        log.info("tour retreived {}", tour);
        return TourResponseDTOMapper.INSTANCE.convert(tour);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateTourResponseDTO> create(@RequestBody @Valid CreateTourRequestDTO createTourRequestDTO){
        log.info("create tour, request {}", createTourRequestDTO);
        Tour tour = CreateTourRequestDTOMapper.INSTANCE.convert(createTourRequestDTO);
        log.info("request converted into tour {}", tour);
        Tour savedTour = tourService.create(tour);
        log.info("tour create successfully, saved tour {}", savedTour);
        return ResponseEntity.ok(CreateTourResponseDTOMapper.INSTANCE.convert(savedTour));
    }

    @PatchMapping("/{id}")
    public EditTourResponseDTO edit(@PathVariable("id") Long id, @RequestBody EditTourRequestDTO editTourRequestDTO){
        log.info("edit tour, id {}, edit request {}", id, editTourRequestDTO);
        Tour editedTour = tourService.edit(id, editTourRequestDTO);
        log.info("edited tour {}", editedTour);
        return EditTourResponseDTOMapper.INSTANCE.convert(editedTour);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        log.info("delete tour, id {}", id);
        tourService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public SearchTourResponseDTO search(@RequestBody SearchTourRequestDTO searchTourRequestDTO){
        log.info("search tour, request {}", searchTourRequestDTO);
        List<Tour> tours = tourService.search(searchTourRequestDTO);
        log.info("found tours {}", tours);
        List<TourResponseDTO> tourDTOList = TourResponseDTOMapper.INSTANCE.convert(tours);
        return new SearchTourResponseDTO(tourDTOList);
    }
}