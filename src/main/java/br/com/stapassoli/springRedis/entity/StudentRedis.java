package br.com.stapassoli.springRedis.entity;

import br.com.stapassoli.springRedis.enums.Gender;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash(value = "Student", timeToLive = 30) // timeToLive the data in be in 30 MINUTES IN DATA BASE , is also known as TTL(time to live)
public class StudentRedis implements Serializable {

    @Id
    @Indexed
    private String id;
    private String name;
    private Gender gender;
    private Integer grade;

}
