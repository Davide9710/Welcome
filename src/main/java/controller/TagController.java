package controller;

import domain.Tag;
import dto.GetAllTagDTO;
import lombok.RequiredArgsConstructor;
import mapper.TagResponseDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TagService;

import java.util.List;

@RestController
@RequestMapping(value = "/tag", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping
    public ResponseEntity<GetAllTagDTO> getAll(){
        List<Tag> tagList = tagService.getAll();
        return ResponseEntity.ok(new GetAllTagDTO(TagResponseDTOMapper.INSTANCE.convert(tagList)));
    }
}
