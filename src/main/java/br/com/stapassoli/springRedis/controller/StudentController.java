package br.com.stapassoli.springRedis.controller;

import br.com.stapassoli.springRedis.entity.Student;
import br.com.stapassoli.springRedis.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@RequestParam(value = "id") String id) {
        return this.studentService.findById(id);
    }

    @GetMapping
    public List<Student> getAll() {
        return this.studentService.findAll();
    }

}
