package domain.elastic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "tours_index")
@Builder
@AllArgsConstructor
@Setter
@Getter
public class TourDocument {

    @Id
    private String elasticId;

    @Field(name = "title", type = FieldType.Text)
    private String title;

    @Field(name = "tourstopnames", type = FieldType.Text)
    private List<String> tourStopNames;
}
