package zhugaru.dcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import zhugaru.dcl.entity.ArtistEntity;
import zhugaru.dcl.mapsctruct.dto.ArtistDto;
import zhugaru.dcl.service.ArtistService;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class ArtistController {
    private final ArtistService artistService;

    @PostMapping("/addArtist/add")
    public String addArtist(@ModelAttribute ArtistEntity artist) {
        artistService.saveArtist(artist);
        return "redirect:/catalog";
    }

    @GetMapping("/addArtist")
    public String addArtist(Model model, HttpSession session) {
        model.addAttribute("artist", new ArtistDto());
        return "addArtist";
    }
}
