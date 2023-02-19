package controller;

import domain.Tag;
import dto.TagListResponseDTO;
import dto.TagResponseDTO;
import mapper.TagResponseDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TagService;

import java.util.List;

@RestController
@RequestMapping(value = "/tag", produces = MediaType.APPLICATION_JSON_VALUE)
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/")
    public List<TagResponseDTO> getAll(){
        List<Tag> tagList = tagService.getAll();
        return TagResponseDTOMapper.INSTANCE.convert(tagList);
    }
}