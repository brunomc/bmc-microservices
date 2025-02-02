package br.com.bruno.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
