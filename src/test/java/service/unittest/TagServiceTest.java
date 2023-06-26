package service.unittest;

import domain.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import repository.TagRepository;
import service.TagService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TagServiceTest {
    @SpringBootConfiguration
    static class TestConfig {
        @Autowired
        TagRepository tagRepository;

        @Bean
        public TagService tagService() {
            return new TagService(tagRepository);
        }
    }

    @MockBean
    TagRepository tagRepository;

    @Autowired
    TagService tagService;

    @Test
    public void getAllTest(){
        //given
        Tag mockTag = new Tag();
        String mockTagName = "mockTagName";
        mockTag.setName(mockTagName);
        Mockito.when(tagRepository.findAll()).thenReturn(List.of(mockTag));

        //when
        List<Tag> allTags = tagService.getAll();

        //then
        assertNotNull(allTags);
        assertEquals(allTags.size(), 1);
        assertNotNull(allTags.get(0));
        assertEquals(allTags.get(0).getName(), mockTagName);

    }
}
