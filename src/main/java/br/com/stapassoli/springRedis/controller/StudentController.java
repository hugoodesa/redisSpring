package br.com.stapassoli.springRedis.controller;

import br.com.stapassoli.springRedis.entity.StudentRedis;
import br.com.stapassoli.springRedis.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public StudentRedis createStudent(@RequestBody StudentRedis student) {
        return this.studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public StudentRedis getStudent(@RequestParam(value = "id") String id) {
        return this.studentService.findById(id);
    }

    @GetMapping
    public List<StudentRedis> getAll() {
        return this.studentService.findAll();
    }

    @PostMapping("/updateDataBase")
    public ResponseEntity<Void> updateDataBase() {
        return this.studentService.updateDataBase();
    }

}
