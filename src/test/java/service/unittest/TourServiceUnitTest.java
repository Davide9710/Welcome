package service.unittest;

import domain.Tour;
import domain.softdeletable.SoftDelete;
import dto.CityDTO;
import dto.EditTourRequestDTO;
import dto.SearchTourRequestDTO;
import dto.TagRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import repository.TourRepository;
import service.TourService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class TourServiceUnitTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Autowired
        TourRepository tourRepository;

        @Bean
        public TourService tourService() {
            return new TourService(tourRepository);
        }
    }

    @MockBean
    TourRepository tourRepository;

    @Autowired
    TourService tourService;

    @Test
    public void createTourTest() {
        SoftDelete softDelete = new SoftDelete();
        Tour tour = new Tour();
        tour.setSoftDelete(softDelete);
        Mockito.when(tourRepository.save(any())).thenReturn(null);
        assertDoesNotThrow(() -> tourService.create(tour));
    }

    @Test
    public void editTourTest() {
        Tour mockResult = new Tour();
        Long mockId = 1L;
        String mockTitle = "mockTitle";
        Double mockApproxCost = 20D;
        Integer mockApproxDuration = 20;
        String mockCityName = "mockCityName";
        Long mockTagId = 1L;
        String mockTagName = "mockTagName";
        EditTourRequestDTO mockEditTourRequest = new EditTourRequestDTO(mockTitle,
                mockApproxCost,
                mockApproxDuration,
                new CityDTO(mockCityName),
                List.of(new TagRequestDTO(mockTagId, mockTagName)));

        Mockito.when(tourRepository.save(any())).thenReturn(mockResult);
        Mockito.when(tourRepository.findById(anyLong())).thenReturn(Optional.of(mockResult));

        Tour tourEdited = tourService.edit(mockId, mockEditTourRequest);
        //Tour fields
        assertEquals(tourEdited.getTitle(), mockTitle);
        assertEquals(tourEdited.getApproxCost(), mockApproxCost);
        assertEquals(tourEdited.getApproxDuration(), mockApproxDuration);
        //City
        assertNotNull(tourEdited.getCity());
        assertEquals(tourEdited.getCity().getName(), mockCityName);
        //Tags
        assertNotNull(tourEdited.getTags());
        assertEquals(tourEdited.getTags().size(), 1);
        assertNotNull(tourEdited.getTags().get(0));
        assertEquals(tourEdited.getTags().get(0).getId(), mockId);
        assertEquals(tourEdited.getTags().get(0).getName(), mockTagName);
    }

    @Test
    public void deleteTourTest() {
        Long mockId = 1L;
        Mockito.doNothing().when(tourRepository).deleteById(anyLong());
        assertDoesNotThrow(() -> tourService.delete(mockId));
    }

    @Test
    public void searchTourTest() {
        Tour tour = new Tour();
        String mockTitle = "mockTitle";
        tour.setTitle("mockTitle");
        SoftDelete softDelete = new SoftDelete();
        tour.setSoftDelete(softDelete);
        Page<Tour> mockPage = new PageImpl<>(List.of(tour));
        Mockito.when(tourRepository.findAll((Specification<Tour>) any(), (Pageable) any()))
                .thenReturn(mockPage);
        List<Tour> tours = tourService.search(new SearchTourRequestDTO(null,
                null,
                null,
                null,
                0,
                10));
        assertNotNull(tours);
        assertEquals(tours.size(), 1);
        assertNotNull(tours.get(0));
        assertEquals(tours.get(0).getTitle(), mockTitle);
    }
}
