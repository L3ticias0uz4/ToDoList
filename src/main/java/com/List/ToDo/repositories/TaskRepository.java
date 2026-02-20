package com.List.ToDo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.List.ToDo.entities.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}