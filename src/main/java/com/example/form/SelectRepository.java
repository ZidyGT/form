package com.example.form;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectRepository extends CrudRepository<Select, Long> {

}
