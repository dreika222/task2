package Andrew_Kuznichenko;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class PersonList {
   private List<Person> people;

    public PersonList() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person){
        people.add(person);
    }

    //Вывод списка людей отсортированных по имени
    public void output() {
        people.sort(Comparator.comparing(Person::getName));
        for (Person p: people) {
            System.out.println(p);
        }
    }

    //Вывод списка людей младше 35 лет и не содержищих буквы е в фамилии
    public void secondOutput(){
        people.stream()
                .filter( person -> person.getAge() < 35 || person.getAge() > 0)
                .filter(person ->  (!person.getSurname().contains("е")))
                .filter(person ->  (!person.getSurname().contains("Е")))
                .filter(person ->  (!person.getSurname().contains("e")))
                .filter(person ->  (!person.getSurname().contains("E")))
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }


    //Вывод мужчин и людей у которых в имени есть две буквы А
    public void thirdOutput(){
        people.stream()
                .filter(person -> person.getSex().equals(Sex.M))
                .filter(person -> {
                    char[] array = person.getName().toCharArray();
                    int counter = 0;
                    for (char i: array) {

                        if(i == 'a') {
                            counter ++;
                        } else if (i == 'A'){
                            counter ++;
                        } else if (i == 'а'){
                            counter ++;
                        } else if (i == 'А'){
                            counter ++;
                        }
                        if(counter == 2){
                            return true;
                        }
                    }
                    return false;
                }).forEach(System.out::println);

    }

    //Вывод списка людей у которых фамилия и имя начинаются с одной буквы
    public void fourthOutput(){
        people.stream()
                .filter(person -> {
                    char[] name = person.getName().toCharArray();
                    char[] surname = person.getSurname().toCharArray();
                    return (name[0] == surname[0]);
                }).forEach(System.out::println);
    }

}
