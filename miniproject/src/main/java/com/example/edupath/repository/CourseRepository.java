package com.example.edupath.repository;

import com.example.edupath.model.Course;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init() {
        courses.add(new Course("IELTS-6.5", "IELTS Master", "Advanced", 8500000.0, "Lộ trình tinh gọn đạt 6.5+", "Mr. Anh", "6 tháng", true, 20, LocalDate.of(2023, 12, 1)));
        courses.add(new Course("TOEIC-500", "TOEIC Basic", "Beginner", 3200000.0, "Nền tảng cho người mới", "Ms. Hoa", "3 tháng", false, 10, LocalDate.of(2023, 11, 15)));
        courses.add(new Course("COMM-01", "Giao tiếp cơ bản", "Beginner", 4500000.0, "Phản xạ tự nhiên", "Mr. John", "4 tháng", false, 0, LocalDate.of(2023, 12, 10)));
        courses.add(new Course("BUS-02", "Business English", "Intermediate", 6000000.0, "Tiếng Anh văn phòng", "Ms. Linh", "5 tháng", false, 5, LocalDate.of(2024, 1, 5)));
        courses.add(new Course("SAT-PRO", "SAT Conqueror", "Advanced", 12000000.0, "Luyện đề chuyên sâu", "Mr. Smith", "8 tháng", false, 0, LocalDate.of(2024, 2, 1)));
    }

    public List<Course> findAll() { return courses; }

    public Course findById(String id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(String id) {
        courses.removeIf(c -> c.getId().equals(id));
    }
}