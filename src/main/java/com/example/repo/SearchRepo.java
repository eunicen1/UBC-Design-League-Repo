package com.example.repo;

import com.example.entity.Search;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SearchRepo extends CrudRepository<Search, UUID> {

}
