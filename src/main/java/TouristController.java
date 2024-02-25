import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/attractions")
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        return ResponseEntity.ok(touristService.getAllAttractions());
    }

    @GetMapping("/{attractionName}")
    @ResponseBody
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String attractionName) {
        Optional<TouristAttraction> attraction = touristService.getAttractionByName(attractionName);
        return attraction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{attractionName}")
    @ResponseBody
    public ResponseEntity<Void> deleteAttractionByName(@PathVariable String attractionName) {
        touristService.deleteAttraction(attractionName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/attractionList")
    public String getAttractionList(Model model) {
        model.addAttribute("attractions", touristService.getAllAttractions());
        return "attractionList";
    }

    @GetMapping("/{attractionName}/tags")
    public String getAttractionTags(@PathVariable String attractionName, Model model) {
        Optional<TouristAttraction> attraction = touristService.getAttractionByName(attractionName);
        attraction.ifPresent(value -> model.addAttribute("tags", value.getTags()));
        return "tags";
    }

    @GetMapping("/add")
    public String getAddAttractionForm(Model model) {
        model.addAttribute("attraction", new TouristAttraction());
        model.addAttribute("cities", touristService.getCities());
        model.addAttribute("tags", touristService.getTags());
        return "addAttraction";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return "redirect:/attractions/attractionList";
    }

    @GetMapping("/{attractionName}/edit")
    public String getEditAttractionForm(@PathVariable String attractionName, Model model) {
        Optional<TouristAttraction> attraction = touristService.getAttractionByName(attractionName);
        attraction.ifPresent(value -> model.addAttribute("attraction", value));
        model.addAttribute("cities", touristService.getCities());
        model.addAttribute("tags", touristService.getTags());
        return "updateAttraction";
    }

    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return "redirect:/attractions/attractionList";
    }

    @GetMapping("/{attractionName}/delete")
    public String getDeleteAttractionForm(@PathVariable String attractionName, Model model) {
        model.addAttribute("attractionName", attractionName);
        return "deleteAttraction";
    }

    @PostMapping("/delete")
    public String deleteAttraction(@RequestParam String attractionName) {
        touristService.deleteAttraction(attractionName);
        return "redirect:/attractions/attractionList";
    }
}
