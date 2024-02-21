package br.com.stapassoli.springRedis.repository;

import br.com.stapassoli.springRedis.entity.StudentRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRedisRespository extends CrudRepository<StudentRedis, String> {

}
