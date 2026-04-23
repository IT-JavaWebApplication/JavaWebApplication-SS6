package com.example.edupath.controller;

import com.example.edupath.model.Course;
import com.example.edupath.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/list")
    public String list(@RequestParam(required = false) String level,
                       @RequestParam(required = false) Double maxFee, Model model) {
        model.addAttribute("courses", service.filterCourses(level, maxFee));
        model.addAttribute("selectedLevel", level);
        model.addAttribute("selectedMaxFee", maxFee);
        return "course/list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable String id, Model model) {
        model.addAttribute("course", service.getDetail(id));
        return "course/detail";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        model.addAttribute("course", service.getDetail(id));
        return "course/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Course course, RedirectAttributes ra) {
        service.updateCourse(course);
        ra.addFlashAttribute("message", "Cập nhật thành công khóa học " + course.getId());
        return "redirect:/course/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes ra) {
        String error = service.deleteCourse(id);
        if (error != null) {
            ra.addFlashAttribute("error", error);
        } else {
            ra.addFlashAttribute("message", "Đã hủy khóa học thành công!");
        }
        return "redirect:/course/list";
    }
}