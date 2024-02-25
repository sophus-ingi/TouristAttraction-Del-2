import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private List<String> tags;

    public TouristAttraction() {}

    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public List<String> getTags() {
        return tags;
    }

    // Setters for additional properties

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
