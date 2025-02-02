package br.com.bruno.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bruno.Exceptions.NotFoundException;
import br.com.bruno.Model.Person;
import br.com.bruno.Service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public List<Person> getAllPersons() {
		return personService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id) throws NotFoundException {
		Person person = personService.findById(id);
		if (person != null) {
			return ResponseEntity.ok(person);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return personService.save(person);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
		Person updatedPerson = personService.update(id, personDetails);
		if (updatedPerson != null) {
			return ResponseEntity.ok(updatedPerson);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable Long id) {
		if (personService.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
