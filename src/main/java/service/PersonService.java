package service;

import dao.PersonDao;
import module.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService{

    private final PersonDao personDao;
    //the anotations are used to instantiate beans
    //allows injection to happen
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }
    public int addPerson(Person person)
    {
        //get a reference of the actual person created
        return personDao.insertPerson (person);
    }
    public List<Person> getAllPeople()
    {
        return  personDao.selectAllPeople();
    }
}
