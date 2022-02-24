package com.example.chinook_java_assignment.view;

import com.example.chinook_java_assignment.data.service.MusicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {
 MusicRepository musicRepository = new MusicRepository();

 @GetMapping("/")
 public String view(
         Model model
 ){
 model.addAttribute("artists", musicRepository.getFiveRandomArtists());
  model.addAttribute("tracks", musicRepository.getFiveRandomTracks());
  model.addAttribute("genres", musicRepository.getFiveRandomGenres());
 return "home";
 }
}
