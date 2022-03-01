package com.sakilaDB.TSI.matthew.barker.demo;

import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@CrossOrigin(origins = "*")
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

	@GetMapping("/Language/All")
	public @ResponseBody
	Iterable<Language> getAllLanguages() {
		return languageRepository.findAll();
	}

	@GetMapping("/Category/All")
	public @ResponseBody
	Iterable<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/Category/{category_id}")
	public @ResponseBody
	Optional<Category> getCategoryByID(@PathVariable int category_id) {
		return categoryRepository.findById(category_id);
	}

	@GetMapping("/Actor/All")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("/Actor/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorByID(@PathVariable int actor_id) {
		return actorRepository.findById(actor_id);
	}

	@GetMapping("/Film/All")
	public @ResponseBody
	Iterable<Film> getAllFilms() {
		return filmRepository.findAll();
	}

	@GetMapping("/Film/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id) {
		return filmRepository.findById(film_id);
	}

	@PostMapping("/Language/Add")
	public @ResponseBody
	String addLanguage(@RequestParam String name) {
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	@PostMapping("/Film/Add")
	public @ResponseBody
	String addFilm(@RequestParam String title, String description, int release_year, int length, String rating, int language_id) {
		Film addFilm = new Film(title, description, release_year, length, rating, language_id);
		filmRepository.save(addFilm);
		return save;
	}

	@PostMapping("/Actor/Add")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name) {
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return save;
	}

	@PostMapping("/Review/Add")
	public @ResponseBody
	String addReview(@RequestParam int film_id, String consumer_review) {
		Review addReview = new Review(film_id, consumer_review);
		reviewRepository.save(addReview);
		return save;
	}


	@PutMapping("/Review/Update/{review_id}")
	public @ResponseBody
	String updateActor(@PathVariable int review_id, @RequestParam String consumer_review){
		Review updateReview = reviewRepository.findById(review_id).orElseThrow(() ->new ResourceNotFoundException("Review not found"));;
		updateReview.setConsumer_review(consumer_review);
		final Review updatedReview = reviewRepository.save(updateReview);
		return "updated";
	}

	@DeleteMapping("/Review/Delete/{review_id}")
	public @ResponseBody
	String deleteReviewByID(@PathVariable int review_id) {
		reviewRepository.deleteById(review_id);
		return "deleted";
	}

	@PostMapping("/Film_Actor/Assign")
	public @ResponseBody
	String assignFilm_Actor(@RequestParam int film_id, int actor_id) {
		Film_Actor assignFilm_Actor = new Film_Actor(film_id, actor_id);
		film_actorRepository.save(assignFilm_Actor);
		return save;
	}
}