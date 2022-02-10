package com.sakilaDB.TSI.matthew.barker.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/Home")
public class SakilaDatabaseApplication {

	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private FilmRepository filmRepository;
	private String save = "Save";


	public SakilaDatabaseApplication(LanguageRepository languageRepository,CategoryRepository categoryRepository, ActorRepository actorRepository, FilmRepository filmRepository){

		this.languageRepository = languageRepository;
		this.categoryRepository = categoryRepository;
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaDatabaseApplication.class, args);
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable <Language> getAllLanguages (){
		return languageRepository.findAll();
	}

	@PostMapping("/addLanguages")
	public @ResponseBody String addLanguage(@RequestParam String name){
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	@GetMapping("/GetLanguage/{language_id}")
	public @ResponseBody
	Optional<Language> getLanguageByID(@PathVariable int language_id){
		return languageRepository.findById(language_id);
	}

	@GetMapping("/AllCategories")
	public @ResponseBody
	Iterable <Category> getAllCategories (){
		return categoryRepository.findAll();
	}

	@GetMapping("/GetCategory/{category_id}")
	public @ResponseBody
	Optional<Category> getCategoryByID(@PathVariable int category_id){
		return categoryRepository.findById(category_id);
	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable <Actor> getAllActors (){
		return actorRepository.findAll();
	}

	@GetMapping("/GetActors/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorByID(@PathVariable int actor_id){
		return actorRepository.findById(actor_id);
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable <Film> getAllFilms (){
		return filmRepository.findAll();
	}

	@PostMapping("/addFilm")
	public @ResponseBody String addFilm(@RequestParam String title, String description, int release_year, int length, String rating, int language_id){
		Film addFilm = new Film(title, description, release_year, length, rating, language_id);
		filmRepository.save(addFilm);
		return save;
	}

	@GetMapping("/GetFilm/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id){
		return filmRepository.findById(film_id);
	}

}