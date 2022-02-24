package com.example.chinook_java_assignment.view;

import com.example.chinook_java_assignment.data.service.MusicRepository;
import com.example.chinook_java_assignment.model.music.Track;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MusicController {
 MusicRepository musicRepository = new MusicRepository();

 /**
  * View for the root page that shows list of artists,tracks and genres from the sqlite database
  * @param model
  * @return
  */
 @GetMapping("/")
 public String view(
         Model model
 ){
 model.addAttribute("artists", musicRepository.getFiveRandomArtists());
  model.addAttribute("tracks", musicRepository.getFiveRandomTracks());
  model.addAttribute("genres", musicRepository.getFiveRandomGenres());
 return "home";
 }


 @GetMapping("search")
 public String search(Model model, String keyword) {

  model.addAttribute("tracks", musicRepository.getSearchMatchingTracks(keyword));
   System.out.println(keyword);
   return "search";

 }

}
