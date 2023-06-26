package service.unittest;

import domain.Tour;
import domain.Tourist;
import dto.request.EditTouristRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import repository.TourRepository;
import repository.TouristRepository;
import service.TouristService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class TouristServiceUnitTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Autowired
        TouristRepository touristRepository;

        @Autowired
        TourRepository tourRepository;

        @Bean
        public TouristService touristService() {
            return new TouristService(touristRepository, tourRepository);
        }
    }

    @MockBean
    TouristRepository touristRepository;

    @MockBean
    TourRepository tourRepository;

    @Autowired
    TouristService touristService;

    @Test
    public void markAsCompleteTest(){
        //given
        Tourist mockTourist = new Tourist();
        String mockEmail = "mockEmail";
        mockTourist.setEmail(mockEmail);
        Mockito.when(touristRepository.findById(anyLong())).thenReturn(Optional.of(mockTourist));
        Tour mockTour = new Tour();
        String mockTitle = "mockTitle";
        mockTour.setTitle(mockTitle);

        Mockito.when(tourRepository.findById(anyLong())).thenReturn(Optional.of(mockTour));
        Mockito.when(touristRepository.save(any())).thenReturn(null);
        Mockito.when(tourRepository.save(any())).thenReturn(null);

        Long mockTouristId = 1L;
        Long mockTourId = 1L;

        //when, then
        assertDoesNotThrow(() -> touristService.markAsComplete(mockTouristId, mockTourId));
    }

    @Test
    public void editTest(){
        //given
        Tourist mockTourist = new Tourist();
        String mockEmail = "mockEmail";
        Long mockTouristId = 1L;
        mockTourist.setId(mockTouristId);
        mockTourist.setEmail(mockEmail);

        Mockito.when(touristRepository.findById(anyLong())).thenReturn(Optional.of(mockTourist));
        Mockito.when(tourRepository.save(any())).thenReturn(null);

        String newLastName = "newLastName";
        String newFirstName = "newFirstName";
        EditTouristRequestDTO editTouristRequestDTO = new EditTouristRequestDTO(newFirstName, newLastName);

        //when
        Tourist tourist = touristService.edit(mockTouristId, editTouristRequestDTO);

        //then
        assertNotNull(tourist);
        assertEquals(tourist.getId(), mockTouristId);
        assertEquals(tourist.getEmail(), mockEmail);
        assertEquals(tourist.getEmail(), mockEmail);
        assertEquals(tourist.getFirstName(), newFirstName);
        assertEquals(tourist.getLastName(), newLastName);
    }

    @Test
    public void getAllMarkedTourTest(){
        //given
        Tour mockTour = new Tour();
        String mockTitle = "mockTitle";
        mockTour.setTitle(mockTitle);

        Tourist mockTourist = new Tourist();
        String mockEmail = "mockEmail";
        Long mockTouristId = 1L;
        mockTourist.setId(mockTouristId);
        mockTourist.setEmail(mockEmail);
        mockTourist.setTours(List.of(mockTour));

        Mockito.when(touristRepository.findById(anyLong())).thenReturn(Optional.of(mockTourist));

        //when
        List<Tour> allMarkedTour = touristService.getAllMarkedTour(mockTouristId);

        //then
        assertNotNull(allMarkedTour);
        assertEquals(allMarkedTour.size(), 1);
        assertNotNull(allMarkedTour.get(0));
        assertEquals(allMarkedTour.get(0).getTitle(), mockTitle);
    }
}
