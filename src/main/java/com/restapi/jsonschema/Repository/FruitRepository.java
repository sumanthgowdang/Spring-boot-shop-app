package com.restapi.jsonschema.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.restapi.jsonschema.domain.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Long>{

	List<Fruit> findByName(String name);

	void deleteUsersByName(String name);
	@Query("FROM Fruit Where name=:name")
	Fruit getByName(String name);

}
