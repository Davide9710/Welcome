package elastic;

import domain.elastic.TourDocument;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface TourRepositoryFullText extends ElasticsearchRepository<TourDocument, String> {

    @Query("{\"match\": {\"title\": {\"query\": \"?0\"}}}")
    List<TourDocument> searchByTitleFullText(String title);

    @Query("{\"match\": {\"tourstopnames\": {\"query\": \"?0\"}}}")
    List<TourDocument> searchByTourStopNames(String tourStopName);
}
