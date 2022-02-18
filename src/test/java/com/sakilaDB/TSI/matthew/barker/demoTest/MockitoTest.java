package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    private SakilaDatabaseApplication sakilaDatabaseApplication;
    @Mock
    private LanguageRepository languageRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private Film_ActorRepository film_actorRepository;
    @Mock
    private ReviewRepository reviewRepository;


    @BeforeEach
    void Setup(){
        sakilaDatabaseApplication = new SakilaDatabaseApplication(languageRepository,categoryRepository,actorRepository,filmRepository,film_actorRepository,reviewRepository);
    }

    @Test
    public void testGetLanguage(){
        Language testLanguage = new Language("name");
        List<Language> languageList = new ArrayList<>();
        languageList.add(testLanguage);
        when(sakilaDatabaseApplication.getAllLanguages()).thenReturn(languageList);
        Assertions.assertEquals(languageList, sakilaDatabaseApplication.getAllLanguages(), "This Language getting test has failed");
    }

    @Test
    public void testGetFilm(){
        Film testFilm = new Film("title", "description", 2022, 202, "rating", 3);
        List<Film> filmList = new ArrayList<>();
        filmList.add(testFilm);
        when(sakilaDatabaseApplication.getAllFilms()).thenReturn(filmList);
        Assertions.assertEquals(filmList, sakilaDatabaseApplication.getAllFilms(), "This film getting test has failed");
    }

    @Test
    public void testGetActor(){
        Actor testActor = new Actor("firstName","lastName");
        List<Actor> actorList = new ArrayList<>();
        actorList.add(testActor);
        when(sakilaDatabaseApplication.getAllActors()).thenReturn(actorList);
        Assertions.assertEquals(actorList, sakilaDatabaseApplication.getAllActors(), "This Actor getting test has failed");
    }

    @Test
    public void testGetCategory(){
        Category testCategory = new Category("Name");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(testCategory);
        when(sakilaDatabaseApplication.getAllCategories()).thenReturn(categoryList);
        Assertions.assertEquals(categoryList, sakilaDatabaseApplication.getAllCategories(), "This Category getting test has failed");
    }

    @Test
    public void testGetFilmById(){
        Film testFilm = new Film("title", "description", 2022, 202, "rating", 3);
        when(sakilaDatabaseApplication.getFilmByID(0)).thenReturn(Optional.of(testFilm));
        Assertions.assertEquals(Optional.of(testFilm), sakilaDatabaseApplication.getFilmByID(0), "This Film Id getting test has failed");
    }

    @Test
    public void testGetActorById(){
        Actor testActor = new Actor("firstName","lastName");
        when(sakilaDatabaseApplication.getActorByID(0)).thenReturn(Optional.of(testActor));
        Assertions.assertEquals(Optional.of(testActor), sakilaDatabaseApplication.getActorByID(0), "This Actor Id getting test has failed");
    }

    @Test
    public void testGetCategoryById(){
        Category testCategory = new Category("name");
        when(sakilaDatabaseApplication.getCategoryByID(0)).thenReturn(Optional.of(testCategory));
        Assertions.assertEquals(Optional.of(testCategory), sakilaDatabaseApplication.getCategoryByID(0), "This Category Id getting test has failed");
    }

    @Test
    public void testAddLanguage(){

        Language saveLanguage = new Language("testLanguage");
        String expected = "Save";
        String actual = sakilaDatabaseApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Language)");
    }

    @Test
    public void testAddActor(){

        Actor saveActor = new Actor("testActorFirstName","testActorLastName");
        String expected = "Save";
        String actual = sakilaDatabaseApplication.addActor(saveActor.getFirstName(), saveActor.getLastName());
        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        verify(actorRepository).save(actorArgumentCaptor.capture());
        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Actor)");
    }

    @Test
    public void testAddFilm(){

        Film saveFilm = new Film("testTitle", "testDescription", 2022, 200, "testRating", 1);
        String expected = "Save";
        String actual = sakilaDatabaseApplication.addFilm(saveFilm.getTitle(), saveFilm.getDescription(), saveFilm.getRelease_year(),saveFilm.getLength(), saveFilm.getRating(), saveFilm.getLanguage_id());
        ArgumentCaptor<Film>filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Film)");
    }

    @Test
    public void testAddReview(){

        Review saveReview = new Review(1,"Review");
        String expected = "Save";
        String actual = sakilaDatabaseApplication.addReview(saveReview.getFilm_id(), saveReview.getConsumer_review());
        ArgumentCaptor<Review>reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewRepository).save(reviewArgumentCaptor.capture());
        reviewArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Review)");
    }

    @Test
    public void testAssignFilmActor(){

        Film_Actor saveFilm_Actor = new Film_Actor(1,1);
        String expected = "Save";
        String actual = sakilaDatabaseApplication.addFilm_Actor(saveFilm_Actor.getFilm_id(), saveFilm_Actor.getActor_id());
        ArgumentCaptor<Film_Actor>film_actorArgumentCaptor = ArgumentCaptor.forClass(Film_Actor.class);
        verify(film_actorRepository).save(film_actorArgumentCaptor.capture());
        film_actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Review)");
    }

}
