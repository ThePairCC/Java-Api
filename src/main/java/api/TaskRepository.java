package api;

import org.springframework.data.repository.CrudRepository;

import api.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {}

