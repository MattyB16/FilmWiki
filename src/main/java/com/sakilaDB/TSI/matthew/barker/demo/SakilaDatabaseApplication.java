package com.sakilaDB.TSI.matthew.barker.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
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
	@Autowired
	private Film_ActorRepository film_actorRepository;
	@Autowired
	private ReviewRepository reviewRepository;
	private String save = "Save";


	public SakilaDatabaseApplication(LanguageRepository languageRepository, CategoryRepository categoryRepository, ActorRepository actorRepository, FilmRepository filmRepository, Film_ActorRepository film_actorRepository,ReviewRepository reviewRepository) {

		this.languageRepository = languageRepository;
		this.categoryRepository = categoryRepository;
		this.actorRepository = actorRepository;
		this.filmRepository = filmRepository;
		this.film_actorRepository = film_actorRepository;
		this.reviewRepository = reviewRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaDatabaseApplication.class, args);
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language> getAllLanguages() {
		return languageRepository.findAll();
	}

	@PostMapping("/addLanguage")
	public @ResponseBody
	String addLanguage(@RequestParam String name) {
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	@GetMapping("/AllCategories")
	public @ResponseBody
	Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/GetCategory/{category_id}")
	public @ResponseBody
	Optional<Category> getCategoryByID(@PathVariable int category_id) {
		return categoryRepository.findById(category_id);
	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@PostMapping("/addActor")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name) {
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return save;
	}

	@GetMapping("/GetActors/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorByID(@PathVariable int actor_id) {
		return actorRepository.findById(actor_id);
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@PostMapping("/addFilm")
	public @ResponseBody
	String addFilm(@RequestParam String title, String description, int release_year, int length, String rating, int language_id) {
		Film addFilm = new Film(title, description, release_year, length, rating, language_id);
		filmRepository.save(addFilm);
		return save;
	}

	@GetMapping("/GetFilm/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id) {
		return filmRepository.findById(film_id);
	}


	@GetMapping("/GetReview/{film_id}")
	public @ResponseBody
	Optional<Review> getReviewByID(@PathVariable int film_id) {
		return reviewRepository.findById(film_id);
	}

	@PostMapping("/addReview")
	public @ResponseBody
	String addReview(@RequestParam int film_id, String consumer_review) {
		Review addReview = new Review(film_id, consumer_review);
		reviewRepository.save(addReview);
		return save;
	}

	@PostMapping("/assignFilm_Actor")
	public @ResponseBody
	String addFilm_Actor(@RequestParam int film_id, int actor_id) {
		Film_Actor addFilm_Actor = new Film_Actor(film_id, actor_id);
		film_actorRepository.save(addFilm_Actor);
		return save;
	}

//	@DeleteMapping("/removeLanguage/{language_id}")
//	public @ResponseBody
//	String removeLanguageByID(@PathVariable int language_id) {
//		languageRepository.deleteById(language_id);
//		return "The language with ID " + language_id + " has been deleted";
//	}

}