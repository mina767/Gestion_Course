package com.example.gestion_panier;

import com.example.gestion_panier.controller.CourseController;
import com.example.gestion_panier.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CourseControllerTest {

    @MockBean
    private CourseService courseService;  // Utilisez @MockBean ici pour que Spring gère le mock

    @Autowired
    private CourseController courseController;  // Injectez le contrôleur via Spring

    @BeforeEach
    void setUp() {
        // Spring se charge de l'initialisation du contexte, donc cette méthode n'est plus nécessaire
    }

    @Test
    void testGetCourseById() {
        // Simuler un cours
        Map<String, Object> mockCourse = Map.of("id", 1L, "name", "Test Course");

        // Définir le comportement attendu du service
        when(courseService.getCourseById(1L)).thenReturn(mockCourse);

        // Appeler le contrôleur
        ResponseEntity<Map<String, Object>> response = courseController.getCourseById(1L);

        // Vérifications
        assertNotNull(response.getBody(), "Le corps de la réponse ne doit pas être nul");
        assertEquals("Test Course", response.getBody().get("name"), "Le nom du cours ne correspond pas");
        assertEquals(200, response.getStatusCodeValue(), "Le code de statut devrait être 200");
        verify(courseService, times(1)).getCourseById(1L);  // Vérification que la méthode a été appelée une seule fois
    }
}
