//AUTHOR: Srivedaa Chinthalapani
//jpa repository where default db properties are implemented from crud repository methods

package com.example.swe642;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByStdid(String stdid);
}