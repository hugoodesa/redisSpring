package br.com.stapassoli.springRedis.repository;

import br.com.stapassoli.springRedis.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRespository extends CrudRepository<Student, String> {

}
