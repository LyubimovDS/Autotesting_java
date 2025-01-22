package Testing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Builder
@Getter
@Setter
public class DataPet {
    private Integer id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    @Builder
    @Getter
    @Setter
    public static class Category{
        private Integer id;
        private String name;
    }

    @Builder
    @Getter
    @Setter
    public static class Tag{
        private Integer id;
        private String name;
    }
}
