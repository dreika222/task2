package Andrew_Kuznichenko;

public class Person {
    private String name;
    private String surname;
    private int age;
    private Sex sex;

    public Person(String name, String surname, int age, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        if(this.age == -1){
            return "Имя: " + name + ", " +
                    "Фамилия: " + surname + ", " +
                    "Пол: " + sex + ";";
        } else {
            return "Имя: " + name + ", " +
                    "Фамилия: " + surname + ", " +
                    "Возраст: " + age + ", " +
                    "Пол: " + sex + ";";
        }
    }
}


