package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){
        //create an actor
        Actor actor1 = new Actor();
        actor1.setName("Sandra Bullock");
        actor1.setRealname("Sandra Mae Bullowski");

        Actor actor2 = new Actor();
        actor2.setName("Sam Adams");
        actor2.setRealname("Adam Sandler");

        //create a movie
        Movie movieEmoji = new Movie();
        movieEmoji.setTitle("Emoji Movie");
        movieEmoji.setYear(2017L);
        movieEmoji.setDescription("About Emojies...");

        Movie movieTitanic = new Movie();
        movieTitanic.setTitle("Titanic Movie");
        movieTitanic.setYear(2017L);
        movieTitanic.setDescription("About Titanic...");

        //add the movie to an empty list
        Set<Movie> movies1 = new HashSet<Movie>();
        movies1.add(movieEmoji);
        movies1.add(movieTitanic);

        //add the list of movies to the actor's movie list
        actor1.setMovies(movies1);

        //save the actor to the database
        actorRepository.save(actor1);


        Set<Movie> movies2 = new HashSet<Movie>();
        movies2.add(movieTitanic);

        //add the list of movies to the actor's movie list
        actor2.setMovies(movies2);

        //save the actor to the database
        actorRepository.save(actor2);




        //Grad all the actors to the database and send them to the template
        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}
