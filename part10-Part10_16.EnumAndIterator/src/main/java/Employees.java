import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        this.employees.addAll(peopleToAdd);
    }

    public void print() {
        this.employees.forEach(System.out::println);
    }

    public void print(Education education) {

        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Person currPerson = iterator.next();
            if (currPerson.getEducation() == education) {
                System.out.println(currPerson);
            }
        }
    }

    public void fire(Education education) {

        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Person currPerson = iterator.next();
            if (currPerson.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
