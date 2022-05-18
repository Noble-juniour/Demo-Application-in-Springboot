package dao;

import module.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//multiple implementations
// the class needs to be instantiated as a bean to allow access to othe classes
@Repository("fakeDao")
//this is a class that implements the interface created by the dao package
public class FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }
}
