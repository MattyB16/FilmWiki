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

//    @Test
//    public void testAddLanguage(){
//
//        Language saveLanguage = new Language("testLanguage");
//        String expected = "Save";
//        String actual = sakilaDatabaseApplication.addLanguage(saveLanguage.getName());
//        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
//        verify(languageRepository).save(languageArgumentCaptor.capture());
//        languageArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Language)");
//    }
//
//    @Test
//    public void testAddActor(){
//
//        Actor saveActor = new Actor("testActorFirstName","testActorLastName");
//        String expected = "Save";
//        String actual = sakilaDatabaseApplication.addActor(saveActor.getFirstName(), saveActor.getLastName());
//        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
//        verify(actorRepository).save(actorArgumentCaptor.capture());
//        actorArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Actor)");
//    }
//
//    @Test
//    public void testAddFilm(){
//
//        Film saveFilm = new Film("testTitle", "testDescription", 2022, 200, "testRating", 1);
//        String expected = "Save";
//        String actual = sakilaDatabaseApplication.addFilm(saveFilm.getTitle(), saveFilm.getDescription(), saveFilm.getRelease_year(),saveFilm.getLength(), saveFilm.getRating(), saveFilm.getLanguage_id());
//        ArgumentCaptor<Film>filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
//        verify(filmRepository).save(filmArgumentCaptor.capture());
//        filmArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,actual,"Data hasn't been entered into the mock database (Film)");
//    }
//
//    @Test
//    public void testGetFilm(){
//        Film testFilm = new Film("title", "description", 2022, 202, "rating", 3);
//        List<Film> filmList = new ArrayList<>();
//        filmList.add(testFilm);
//        when(sakilaDatabaseApplication.getAllFilms()).thenReturn(filmList);
//        Assertions.assertEquals(filmList, sakilaDatabaseApplication.getAllFilms(), "This film getting test has failed");
//    }
//




}
