import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class seminar4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ФИО возраст пол: ");
        String row = in.nextLine();
        ArrayList<String> data = new ArrayList<>();
        int count = 0;
        while (!row.equals("q")){
            String[] check = row.split(" ");
            if (check.length != 5){
                System.out.println("Не все данные введены! ");
            }else {
                data.add(count + " " + row);
                count++;
            }
            System.out.println("Введите ФИО возраст пол: ");
            row = in.nextLine();
        }
        System.out.println("Отсортировать по фамилии нажмите 1, по возрасту 2, по полу 3");
        String chosenSort = in.nextLine();
        switch (chosenSort) {
            case "1" -> {
                System.out.println("Данные отсортированы по фамилии");
                printList(data, indexedList(data, 1, false));
            }
            case "2" -> {
                System.out.println("Данные отсортированы по возрасту");
                printList(data, indexedList(data, 4, true));
            }
            case "3" -> {
                System.out.println("Данные отсортированы по полу");
                printList(data, indexedList(data, 5, false));
            }
            default -> {
                System.out.println("Данные отсортированы по времени записи");
                printList(data, indexedList(data, 0, false));
            }
        }
        }
    public static ArrayList<Integer> indexedList(ArrayList<String> stringArrayList, int column, boolean typeColumn){
        ArrayList<Integer> index = new ArrayList<>();
        if (typeColumn) {stringArrayList.sort(Comparator.comparing(n -> Integer.parseInt(n.split(" ")[column])));
        } else {         stringArrayList.sort(Comparator.comparing(n -> n.split(" ")[column])); }
        for (String d: stringArrayList) index.add(Integer.parseInt(d.split(" ")[0]));
        stringArrayList.sort(Comparator.naturalOrder());
        return index;
    }
    public static void printList(ArrayList<String> arrayList, ArrayList<Integer> indexes){
        for (int i : indexes) {
            String[] s = arrayList.get(i).split(" ");
            System.out.printf("%s %s. %s. %s, %s\n", s[1], s[2].toUpperCase().charAt(0), s[3].toUpperCase().charAt(0), s[4], s[5]);
        }
    }
}
