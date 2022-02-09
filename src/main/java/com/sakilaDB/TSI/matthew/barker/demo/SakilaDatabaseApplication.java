package com.sakilaDB.TSI.matthew.barker.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/AllCategories")
	public @ResponseBody
	Iterable <Category> getAllCategories (){
		return categoryRepository.findAll();
	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable <Actor> getAllActors (){
		return actorRepository.findAll();
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable <Film> getAllFilms (){
		return filmRepository.findAll();
	}

}
