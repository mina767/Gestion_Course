package com.example.gestion_panier.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    private Map<Long, Map<String, Object>> courses = new HashMap<>();
    private Long nextId = 1L;

    public List<Map<String, Object>> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    public Map<String, Object> getCourseById(Long id) {
        return courses.get(id);
    }

    public Map<String, Object> saveCourse(Map<String, Object> course) {
        Long id = (Long) course.get("id");
        if (id == null) {
            id = nextId++;
            course.put("id", id);
        }
        courses.put(id, course);
        return course;
    }

    public void deleteCourse(Long id) {
        courses.remove(id);
    }
}