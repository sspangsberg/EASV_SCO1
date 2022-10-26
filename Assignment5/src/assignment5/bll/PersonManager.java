package assignment5.bll;

// Project imports
import assignment5.be.Person;
import assignment5.be.Student;
import assignment5.be.Teacher;

// Java imports
import java.util.ArrayList;
import java.util.List;

public class PersonManager
{
    private List<Person> persons;

    /**
     *
     */
    public PersonManager()
    {
        persons = new ArrayList<>();
    }

    /**
     *
     * @param id
     * @return
     */
    public Person getPerson(int id)
    {
        for (Person person : persons)
        {
            if (person.getId() == id)
            {
                return person;
            }
        }
        return null;
    }


    /**
     *
     * @param id
     */
    public void removePerson(int id)
    {
        for (int i = 0; i < persons.size(); i++)
        {
            if (persons.get(i).getId() == id)
            {
                persons.remove(i);
                return;
            }
        }
    }


    /**
     *
     * @return
     */
    public List<Person> getAllPersons()
    {
        return persons;
    }


    /**
     *
     * @return
     */
    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList<>();
        for (Person person : persons)
        {
            if (person instanceof Student)
            {
                students.add((Student) person);
            }
        }
        return students;
    }

    /**
     *
     * @return
     */
    public List<Teacher> getAllTeachers()
    {
        List<Teacher> teachers = new ArrayList<>();
        for (Person person : persons)
        {
            if (person instanceof Teacher)
            {
                teachers.add((Teacher) person);
            }
        }
        return teachers;
    }

    /**
     *
     * @param p
     */
    public void addPerson(Person p)
    {
        if (!persons.contains(p))
        {
            persons.add(p);
        }
    }
}