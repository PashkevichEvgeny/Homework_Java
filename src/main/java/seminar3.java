import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class seminar3 {
    public static void main(String[] args) {
//        Задание
//        Пусть дан произвольный список целых чисел.
        ArrayList<Integer> arr = makeList(20, -100, 100);
        System.out.printf("Произвольный список:\n%s\n", arr);
//        1) Нужно удалить из него чётные числа
        deleteEven(arr);
        System.out.printf("Список с удаленными четными числами:\n%s\n", arr);
//        2) Найти минимальное значение
        arr.sort(null);
        int maxInArray = (arr.size() == 0) ? 0 : arr.get(0);
//        3) Найти максимальное значение
        int minInArray = (arr.size() == 0) ? 0 : arr.get(arr.size() - 1);
//        4) Найти среднее значение
        double average = (arr.size() == 0) ? 0 : averageInArray(arr);
        System.out.printf("Максимальное значение - %d\nМинимальное - %d\nСреднее - %.2f", maxInArray, minInArray, average);
    }
    public static ArrayList<Integer> makeList (int len, int from, int to) {
        len = new Random().nextInt(len + 1);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) list.add(new Random().nextInt(from, to));
        return list;
    }
    public static void deleteEven(ArrayList<Integer> array) {
        ListIterator<Integer> listIterator = array.listIterator();
        while (listIterator.hasNext()){
            int i = listIterator.next();
            if (i % 2 == 0) listIterator.remove();
            listIterator.nextIndex();
        }
    }
    public static double averageInArray(ArrayList<Integer> array) {
        double sumOfArray = 0;
        for (Integer n : array) sumOfArray += n;
        return sumOfArray / array.size();
    }
}