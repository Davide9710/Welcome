package dto;

import domain.Tag;

import java.util.List;

public record SearchTourRequestDTO(Long cityId, Integer duration, String themeName, List<Tag> tagNames) {
}
