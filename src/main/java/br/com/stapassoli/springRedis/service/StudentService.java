package br.com.stapassoli.springRedis.service;

import br.com.stapassoli.springRedis.entity.Student;
import br.com.stapassoli.springRedis.entity.StudentRedis;
import br.com.stapassoli.springRedis.repository.StudentRedisRespository;
import br.com.stapassoli.springRedis.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRedisRespository repository;

    private final StudentRepository studentRepository;


    public StudentRedis saveStudent(StudentRedis student) {
        return repository.save(student);
    }

    public StudentRedis findById(String id) {
        return this.repository.findById(id).orElse(null);
    }

    public List<StudentRedis> findAll() {
        Iterable<StudentRedis> all = this.repository.findAll();
        List<StudentRedis> result = new ArrayList<>();
        all.forEach(result::add);

        return result;
    }

    private List<Student> studentRedisToStudent (List<StudentRedis> studentRedis) {
        return studentRedis.stream().map(Student::new).toList();
    }

    private void cleanDataBaseRedis (List<StudentRedis> studentRedis) {
        this.repository.deleteAll();
    }

    public ResponseEntity<Void> updateDataBase() {

        List<StudentRedis> studentRedis = this.findAll();
        List<Student> students = studentRedisToStudent(studentRedis);

        this.studentRepository.saveAll(students);
        cleanDataBaseRedis(studentRedis);

        return ResponseEntity.ok().build();
    }

    @Scheduled(fixedRate = 60000 * 60)// an hour per time update the postgres with redis
    public void scheduleFixedDelayTask() {
        updateDataBase();
    }


}
