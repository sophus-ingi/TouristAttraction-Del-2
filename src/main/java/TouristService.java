import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public Optional<TouristAttraction> getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    public void addAttraction(TouristAttraction attraction) {
        touristRepository.addAttraction(attraction);
    }

    public void deleteAttraction(String name) {
        touristRepository.deleteAttraction(name);
    }

    //Work in procress
    public List<String> getCities() {
        return touristRepository.getCities();
    }

    //Work in procress
    public List<String> getTags() {
        return touristRepository.getTags();
    }
}
