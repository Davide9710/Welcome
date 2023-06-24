package service;

import domain.Tour;
import dto.EditTourRequestDTO;
import dto.SearchTourRequestDTO;
import exception.notfound.TourNotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.EditTourRequestDTOMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.TourRepository;
import specification.SearchTourSpecification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;

    public Tour getTour(Long id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new TourNotFoundException(id));
    }

    public Tour create(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour edit(Long id, EditTourRequestDTO editTourRequestDTO) throws TourNotFoundException {
        Tour byId = tourRepository.findById(id).orElseThrow(() -> new TourNotFoundException(id));
        byId = EditTourRequestDTOMapper.INSTANCE.updateTourFromDto(editTourRequestDTO, byId);
        return tourRepository.save(byId);
    }

    public void delete(Long id) {
        tourRepository.deleteById(id);
    }

    public List<Tour> search(SearchTourRequestDTO searchTourRequestDTO) {
        SearchTourSpecification specification = new SearchTourSpecification(searchTourRequestDTO);
        PageRequest of = PageRequest.of(searchTourRequestDTO.pageNumber(),
                searchTourRequestDTO.pageSize(),
                Sort.by("rating").descending().and(Sort.by("numberOfReviews")));
        Page<Tour> tours = tourRepository.findAll(specification, of);
        return tours.getContent();
    }
}

