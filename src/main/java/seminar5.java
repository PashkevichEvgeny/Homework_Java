import java.util.*;
public class seminar5 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> db = new HashMap<>();
        String name, number;
        name = "Ivanov"; number = "214434"; phonebook(db, name, number);
        number = "214434"; phonebook(db, name, number);
        name = "Petrov"; number = "112450"; phonebook(db, name, number);
        name = "Testov"; number = "112450"; phonebook(db, name, number);
        number = "167646"; phonebook(db, name, number);
        number = "354987"; phonebook(db, name, number);
        var phoneLength = new ArrayList<String>();
        db.forEach((key, value) -> phoneLength.add(String.valueOf(value)));
        phoneLength.sort((str, str1) -> str1.length() - str.length());
        for (String str : phoneLength)
            db.forEach((key, value) -> {
                if (String.valueOf(value).equals(str))
                    System.out.printf("name: %s, phones: %s\n", key, String.join(", ", value));
            });
    }
        public static void phonebook(HashMap<String, ArrayList<String>> db, String name, String number) {
            var list = new ArrayList<String>();
            if (db.containsKey(name)) list.addAll(db.get(name));
            list.add(number);
            db.put(name, list);
        }
}