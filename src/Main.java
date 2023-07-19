import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
// Операции сведения

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));
        System.out.println(names.stream().count());  // 4

        // количество элементов с длиной не больше 3 символов
        System.out.println(names.stream().filter(n->n.length()<=3).count());  // 3
        System.out.println();


        ArrayList<String> names2 = new ArrayList<String>();
        names2.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));

        Optional<String> first = names2.stream().findFirst();
        System.out.println(first.get());    // Tom

        Optional<String> any = names2.stream().findAny();
        System.out.println(first.get());    // Tom
        System.out.println();


        ArrayList<String> names3 = new ArrayList<String>();
        names3.addAll(Arrays.asList(new String[]{"Tom", "Sam", "Bob", "Alice"}));

        // есть ли в потоке строка, длина которой больше 3
        boolean any3 = names3.stream().anyMatch(s->s.length()>3);
        System.out.println(any3);    // true

        // все ли строки имеют длину в 3 символа
        boolean all = names3.stream().allMatch(s->s.length()==3);
        System.out.println(all);    // false

        // НЕТ ЛИ в потоке строки "Bill". Если нет, то true, если есть, то false
        boolean none = names3.stream().noneMatch(s->s=="Bill");
        System.out.println(none);   // true
        System.out.println();


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.addAll(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));

        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println(min.get());  // 1
        System.out.println(max.get());  // 9
        System.out.println();


        ArrayList<Phone> phones = new ArrayList<Phone>();
        phones.addAll(Arrays.asList(new Phone[]{
                new Phone("iPhone 8", 52000),
                new Phone("Nokia 9", 35000),
                new Phone("Samsung Galaxy S9", 48000),
                new Phone("HTC U12", 36000)
        }));

        Phone min2 = phones.stream().min(Phone::compare).get();
        Phone max2 = phones.stream().max(Phone::compare).get();
        System.out.printf("MIN Name: %s Price: %d \n", min2.getName(), min2.getPrice());
        System.out.printf("MAX Name: %s Price: %d \n", max2.getName(), max2.getPrice());
/* Консольный вывод:
MIN Name: Nokia 9 Price: 35000
MAX Name: iPhone 8 Price: 52000 */
    }
}