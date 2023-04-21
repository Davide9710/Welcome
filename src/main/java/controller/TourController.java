package controller;


import domain.Tour;
import dto.CreateTourRequestDTO;
import dto.CreateTourResponseDTO;
import dto.EditTourRequestDTO;
import dto.EditTourResponseDTO;
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

import javax.validation.Valid;

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
        Tour tour = tourService.getTour(id);
        System.out.println("DEBUG: tour: " + tour.toString());
        return TourResponseDTOMapper.INSTANCE.convert(tour);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateTourResponseDTO> create(@RequestBody @Valid CreateTourRequestDTO createTourRequestDTO){
        log.info("create, request {}", createTourRequestDTO);
        Tour tour = CreateTourRequestDTOMapper.INSTANCE.convert(createTourRequestDTO);
        Tour savedTour = tourService.create(tour);
        return ResponseEntity.ok(CreateTourResponseDTOMapper.INSTANCE.convert(savedTour));
    }

    @PatchMapping("/{id}")
    public EditTourResponseDTO edit(@PathVariable("id") Long id, @RequestBody EditTourRequestDTO editTourRequestDTO){
        Tour editedTour = tourService.edit(id, editTourRequestDTO);
        return EditTourResponseDTOMapper.INSTANCE.convert(editedTour);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id){
        tourService.delete(id);
    }
}