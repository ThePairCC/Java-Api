package api;

import org.springframework.data.repository.CrudRepository;

import api.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {}
