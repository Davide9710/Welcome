package service.unittest;

import domain.Guide;
import domain.Tour;
import dto.request.EditGuideRequestDTO;
import dto.SelectedCityDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import repository.GuideRepository;
import service.GuideService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
public class GuideServiceTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Autowired
        GuideRepository guideRepository;

        @Bean
        public GuideService guideService() {
            return new GuideService(guideRepository);
        }
    }

    @MockBean
    GuideRepository guideRepository;

    @Autowired
    GuideService guideService;

    @Test
    public void getToursByGuideIdTest() {
        //given
        Tour mockTour = new Tour();
        String mockTitle = "mockTitle";
        mockTour.setTitle(mockTitle);
        Mockito.when(guideRepository.findTourByGuideId(anyLong(), any())).thenReturn(
                List.of(mockTour)
        );
        Mockito.when(guideRepository.existsById(any())).thenReturn(true);
        Long mockGuideId = 1L;
        int mockPage = 0;
        int mockSize = 10;

        //when
        List<Tour> toursByGuideId = guideService.getToursByGuideId(mockGuideId, mockPage, mockSize);

        //then
        assertNotNull(toursByGuideId);
        assertEquals(toursByGuideId.size(), 1);
        assertNotNull(toursByGuideId.get(0));
        assertEquals(toursByGuideId.get(0).getTitle(), mockTitle);
    }

    @Test
    public void editTest(){
        //given
        Guide mockGuide = new Guide();
        String mockEmail = "mockEmail";
        mockGuide.setEmail(mockEmail);
        Mockito.when(guideRepository.findById(anyLong())).thenReturn(Optional.of(mockGuide));
        String mockOrgName = "mockOrgName";
        Long mockCityId = 1L;
        String mockCityName = "mockCityName";
        SelectedCityDTO mockSelectedCity = new SelectedCityDTO(mockCityId, mockCityName);
        EditGuideRequestDTO editGuideRequestDTO = new EditGuideRequestDTO(
                mockOrgName,
                mockSelectedCity
        );
        Long mockGuideId = 1L;

        //when
        Guide guide = guideService.edit(mockGuideId, editGuideRequestDTO);

        //then
        assertNotNull(guide);
        assertEquals(guide.getOrganizationName(), mockOrgName);
        assertEquals(guide.getCity().getId(), mockCityId);
        assertEquals(guide.getCity().getName(), mockCityName);
    }
}
