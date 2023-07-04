package service.unittest;

import domain.City;
import domain.Guide;
import domain.Tag;
import domain.Theme;
import domain.Tour;
import domain.softdeletable.SoftDelete;
import dto.CityDTO;
import dto.request.EditTourRequestDTO;
import dto.request.SearchTourRequestDTO;
import dto.request.TagRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import repository.CityRepository;
import repository.GuideRepository;
import repository.SoftDeleteRepository;
import repository.TagRepository;
import repository.ThemeRepository;
import repository.TourRepository;
import elastic.TourRepositoryFullText;
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

        @Autowired
        GuideRepository guideRepository;

        @Autowired
        CityRepository cityRepository;

        @Autowired
        TagRepository tagRepository;

        @Autowired
        ThemeRepository themeRepository;

        @Autowired
        SoftDeleteRepository softDeleteRepository;

        @Autowired
        TourRepositoryFullText tourRepositoryFullText;

        @Bean
        public TourService tourService() {
            return new TourService(tourRepository,
                    guideRepository,
                    cityRepository,
                    tagRepository,
                    themeRepository,
                    softDeleteRepository,
                    tourRepositoryFullText);
        }
    }

    @MockBean
    TourRepository tourRepository;

    @MockBean
    GuideRepository guideRepository;

    @MockBean
    CityRepository cityRepository;

    @MockBean
    TagRepository tagRepository;

    @MockBean
    ThemeRepository themeRepository;

    @MockBean
    SoftDeleteRepository softDeleteRepository;

    @MockBean
    TourRepositoryFullText tourRepositoryFullText;

    @Autowired
    TourService tourService;

    @Test
    public void createTourTest() {
        SoftDelete softDelete = new SoftDelete();
        Tour tour = new Tour();
        tour.setSoftDelete(softDelete);
        City city = new City();
        city.setId(1L);
        tour.setCity(city);
        Theme theme = new Theme();
        theme.setName("theme");
        tour.setTheme(theme);
        Long guideIdMock = 1L;
        Mockito.when(tourRepository.save(any())).thenReturn(null);
        Guide guideMock = new Guide();
        Mockito.when(guideRepository.findById(any())).thenReturn(Optional.of(guideMock));
        Tag mockTag = new Tag();
        Mockito.when(tagRepository.findByName(any())).thenReturn(Optional.of(mockTag));
        Mockito.when(tagRepository.save(any())).thenReturn(Optional.of(mockTag));
        City mockCity = new City();
        Mockito.when(cityRepository.findById(any())).thenReturn(Optional.of(mockCity));
        Theme mockTheme = new Theme();
        Mockito.when(themeRepository.findByName(any())).thenReturn(Optional.of(mockTheme));
        Mockito.when(themeRepository.save(any())).thenReturn(Optional.of(mockTheme));
        SoftDelete mockSoftDelete = new SoftDelete();
        Mockito.when(softDeleteRepository.save(any())).thenReturn(mockSoftDelete);
        assertDoesNotThrow(() -> tourService.create(tour, guideIdMock));
    }

    @Test
    public void editTourTest() {
        Tour mockResult = new Tour();
        Long mockId = 1L;
        String mockTitle = "mockTitle";
        Double mockApproxCost = 20D;
        Integer mockApproxDuration = 20;
        String mockCityName = "mockCityName";
        EditTourRequestDTO mockEditTourRequest = new EditTourRequestDTO(mockTitle,
                mockApproxCost,
                mockApproxDuration,
                new CityDTO(mockCityName));

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
