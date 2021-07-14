package com.example.db;

import com.example.domain.Form;
import org.springframework.data.repository.CrudRepository;


public interface FormRepository extends CrudRepository<Form, Long> {
}
