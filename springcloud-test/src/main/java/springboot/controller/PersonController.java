package springboot.controller;

import com.bccoder.springboot.bean.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {
    private List<Person> persons = new ArrayList<Person>();

    @GetMapping
    public List<Person> findAll(){
        return persons;
    }

    @GetMapping("/{id}")
    public Person findById(){
        return persons.stream().filter(
                it -> it.getId().equals("id")).findFirst().get();

    }
    @PostMapping
    public Person add(@RequestBody Person person){
        person.setId((long)(persons.size()+1));
        persons.add(person);
        return person;
    }
    @DeleteMapping("/{id}")
    public void delete(@RequestParam("id")Long id){
        List<Person> personList = persons.stream().filter(
                it -> it.getId().equals("id")).collect(Collectors.toList());
        persons.removeAll(personList);
    }
    @PutMapping
    public void update(@RequestBody Person p){
        Person person = persons.stream().filter(
                it-> it.getId().equals(p.getId())).findFirst().get();
        persons.set(persons.indexOf(person),p);
    }
}
