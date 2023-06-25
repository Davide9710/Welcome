package controller;

import domain.Tour;
import dto.CreateTourRequestDTO;
import dto.CreateTourResponseDTO;
import dto.EditTourRequestDTO;
import dto.EditTourResponseDTO;
import dto.SearchTourRequestDTO;
import dto.SearchTourResponseDTO;
import dto.TourResponseDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mapper.CreateTourRequestDTOMapper;
import mapper.CreateTourResponseDTOMapper;
import mapper.EditTourResponseDTOMapper;
import mapper.TourResponseDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TourService;

import java.util.List;

/**
 * Tour Controller that contains tour related endpoints, it requires GUIDE role
 */
@RestController
@RequestMapping(value = "/tour",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
@PreAuthorize("hasRole('TOURIST')")
public class TourController {
    private final TourService tourService;

    /**
     * Get endpoint that return a tour by its id
     * @param id the tour id
     * @return the Tour object from the db
     */
    @GetMapping("/{id}")
    public ResponseEntity<TourResponseDTO> get(@PathVariable("id") @NotNull Long id) {
        Tour tour = tourService.getTour(id);
        log.info("tour retrieved {}", tour);
        return ResponseEntity.ok(TourResponseDTOMapper.INSTANCE.convert(tour));
    }

    /**
     * Post Endpoint that save the tour object to the db
     * @param createTourRequestDTO tour projection object
     * @return a prohection of the saved tour
     */
    @PostMapping("/create")
    public ResponseEntity<CreateTourResponseDTO> create(@RequestBody @Valid CreateTourRequestDTO createTourRequestDTO) {
        Tour tour = CreateTourRequestDTOMapper.INSTANCE.convert(createTourRequestDTO);
        log.info("request converted into tour {}", tour);
        Tour savedTour = tourService.create(tour);
        log.info("tour create successfully, saved tour {}", savedTour);
        return ResponseEntity.ok(CreateTourResponseDTOMapper.INSTANCE.convert(savedTour));
    }

    /**
     * Patch Endpoint that allows the guide to partially edit a tour
     * @param tourId the is of the tour to be changed
     * @param editTourRequestDTO data to be updated
     * @return a projection of the updated tour
     */
    @PatchMapping("/{tourId}")
    public ResponseEntity<EditTourResponseDTO> edit(@PathVariable("tourId") @NotNull Long tourId,
                                                    @RequestBody @Valid EditTourRequestDTO editTourRequestDTO) {
        Tour editedTour = tourService.edit(tourId, editTourRequestDTO);
        log.info("edited tour {}", editedTour);
        return ResponseEntity.ok(EditTourResponseDTOMapper.INSTANCE.convert(editedTour));
    }

    /**
     * Delete endpoint that deletes a Tour
     * @param id id of the tour to be deleted
     * @return Response Entity indicating the operation result
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") @NotNull Long id) {
        tourService.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Post endpoint that filter tour by optional params
     * @param searchTourRequestDTO optional params
     * @return a list of tour projections
     */
    @PostMapping("/search")
    public ResponseEntity<SearchTourResponseDTO> search(@RequestBody @Valid SearchTourRequestDTO searchTourRequestDTO) {
        List<Tour> tours = tourService.search(searchTourRequestDTO);
        log.info("found tours {}", tours);
        List<TourResponseDTO> tourDTOList = TourResponseDTOMapper.INSTANCE.convert(tours);
        return ResponseEntity.ok(new SearchTourResponseDTO(tourDTOList));
    }
}