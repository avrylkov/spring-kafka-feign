package com.example.repo;

import com.example.model.Queue;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface QueueRepository extends CrudRepository<Queue, Long> {

    @Modifying
    @Query("update Queue set responseText = ?1, active = false where id = ?2")
    @Transactional
    void setActiveState(String responseText, Long id);

}
