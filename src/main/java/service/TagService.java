package service;

import domain.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.TagRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    /**
     * method that return all the tags in the db
     * @return the tags in the db
     */
    public List<Tag> getAll(){
        return tagRepository.findAll();
    }
}
