package controller;

import domain.Tag;
import dto.GetAllTagDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import mapper.tag.TagResponseDTOMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TagService;

import java.util.List;

/**
 * Controller of tag endpoints, it requires GUIDE or TOURIST role
 */
@RestController
@RequestMapping(value = "/tag", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('GUIDE', 'TOURIST')")
public class TagController {
    private final TagService tagService;

    /**
     * Get endpoint that return all the tags in the db
     * @return the tags in the db
     */
    @GetMapping
    @Operation(summary = "get all cities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    public ResponseEntity<GetAllTagDTO> getAll(){
        List<Tag> tagList = tagService.getAll();
        return ResponseEntity.ok(new GetAllTagDTO(TagResponseDTOMapper.INSTANCE.convert(tagList)));
    }
}
