package br.com.stapassoli.springRedis.service;

import br.com.stapassoli.springRedis.entity.Student;
import br.com.stapassoli.springRedis.repository.StudentRespository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRespository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student findById(String id) {
        return this.repository.findById(id).orElse(null);
    }

    public List<Student> findAll() {
        Iterable<Student> all = this.repository.findAll();
        List<Student> result = new ArrayList<>();
        all.forEach(result::add);

        return result;
    }
}
