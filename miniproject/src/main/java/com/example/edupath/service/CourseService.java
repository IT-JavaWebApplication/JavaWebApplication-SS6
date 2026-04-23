package com.example.edupath.service;

import com.example.edupath.model.Course;
import com.example.edupath.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public List<Course> filterCourses(String level, Double maxFee) {
        return repository.findAll().stream()
                .filter(c -> (level == null || level.isEmpty() || c.getLevel().equalsIgnoreCase(level)))
                .filter(c -> (maxFee == null || c.getFee() <= maxFee))
                .collect(Collectors.toList());
    }

    public Course getDetail(String id) {
        return repository.findById(id);
    }

    public void updateCourse(Course updatedCourse) {
        Course existing = repository.findById(updatedCourse.getId());
        if (existing != null) {
            existing.setFee(updatedCourse.getFee());
            existing.setStartDate(updatedCourse.getStartDate());
        }
    }

    public String deleteCourse(String id) {
        Course c = repository.findById(id);
        if (c != null && c.getStudentCount() > 0) {
            return "Không thể hủy khóa học đã có học viên đăng ký!";
        }
        repository.deleteById(id);
        return null;
    }
}