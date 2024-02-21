
package br.com.stapassoli.springRedis.entity;

import br.com.stapassoli.springRedis.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer grade;

    public Student(StudentRedis studentRedis) {
        this.studentName = studentRedis.getName();
        this.gender = studentRedis.getGender();
        this.grade = studentRedis.getGrade();
    }

}
