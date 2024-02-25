import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractions = new ArrayList<>();

    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public Optional<TouristAttraction> getAttractionByName(String name) {
        return attractions.stream()
                .filter(attraction -> attraction.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public void deleteAttraction(String name) {
        attractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }

    public List<String> getCities() {
        //Work in procress-Test
        List<String> cities = Arrays.asList("City1", "City2", "City3");
        return cities;
    }

    public List<String> getTags() {
        //Work in procress-Test
        List<String> tags = Arrays.asList("Tag1", "Tag2", "Tag3");
        return tags;
    }
}
