package com.kodzilar.repository;

import com.kodzilar.entity.Caretaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CaretakerRepository extends CrudRepository<Caretaker, Long> {

    public Caretaker findByEmail(String username);
}
