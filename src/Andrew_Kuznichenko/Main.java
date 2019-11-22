package Andrew_Kuznichenko;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static PersonList list = new PersonList();

    public static void main(String[] args) {
        int navigation = 0;
        boolean error = true;
        Scanner input = new Scanner(System.in);
        do{
            input();
            do{
                try{
                    System.out.println("Чтобы добавить человека введите 1");
                    System.out.println("Чтобы выйти из добавление введите любую другую цифру");
                    navigation = input.nextInt();
                    error = false;
                } catch (InputMismatchException e){
                    System.out.println("Вы ввели не цифру");
                    input.next();
                    error = true;
                }
            } while (error);
        } while (navigation == 1);
        System.out.println("======================");
        System.out.println("Вывод всех из списка");
        list.output();
        System.out.println("======================");
        System.out.println("Вывод у кого в фамилии нет буквы е и возраст меньше 35");
        list.secondOutput();
        System.out.println("======================");
        System.out.println("Вывод у кого в имени две буквы А и пол мужской");
        list.thirdOutput();
        System.out.println("======================");
        System.out.println("Вывод у кого одна первая буква имени и фамилии");
        list.fourthOutput();
        System.out.println("======================");
    }

   // Метод ввода человека
    private static void input(){
        String data;
        String surname;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите имя, фамилию, возраст(целое число) " +
                "и пол(M/F) человека через пробел");
        data = input.nextLine(); // Ввод строки с данными через пробел
        String[] strings = data.split(" "); //Разделение строки на другие строки

        //Валидация на наличие имени в строке
        if(strings[0].equals("")){
            System.out.println("Не было введено поле имя");
            return;
        }

        //Валидация на наличие фамилии в строке
        try {
            surname = strings[1];
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Фамилия не была введена");
            return;
        }

        int age = ageValidation(strings);
        Sex sex = sexValidation(strings);

        Person person = new Person(strings[0], strings[1], age, sex);
        list.addPerson(person);
        System.out.println(person);
    }


    //Метод валидации возраста
    private static int ageValidation(String[] strings){
        int age;
        try {
            age = Integer.parseInt(strings[2]);
            if(age < 0){
                System.out.println("Поле возраст должно быть положительным");
                age = -1;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели возраст");
            age = -1;
        } catch (NumberFormatException e){
            System.out.println("Возраст был указан как символ");
            age = -1;
        }
        return age;
    }

    //Метод валидации пола человека
    private static Sex sexValidation(String[] strings){
        Sex sex;
        try{
            if(strings[3].equals("M")){
                sex = Sex.M;
            } else if(strings[3].equals("F")){
                sex = Sex.F;
            } else {
                System.out.println("Вы ввели не правильный пол");
                sex = Sex.Unknown;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Вы не ввели пол");
            sex = Sex.Unknown;
        }
        return sex;
    }
}
