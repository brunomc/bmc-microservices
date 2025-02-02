package br.com.bruno.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.Exceptions.NotFoundException;
import br.com.bruno.Model.Person;
import br.com.bruno.Repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) throws NotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person not found with id: " + id));
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person update(Long id, Person personDetails) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());
            person.setAddress(personDetails.getAddress());
            person.setGender(personDetails.getGender());
            person.setBirthDate(personDetails.getBirthDate());
            person.setPhone(personDetails.getPhone());
            person.setEmail(personDetails.getEmail());
            return personRepository.save(person);
        }
        return null;
    }

    public boolean delete(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            personRepository.delete(person);
            return true;
        }
        return false;
    }
}
