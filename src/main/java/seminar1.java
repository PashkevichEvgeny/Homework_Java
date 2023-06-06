import java.util.Random;
import java.util.Arrays;
public class seminar1{
    public static void main(String[] args) {
//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        int i = new Random().nextInt(2000);
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = msb(i);
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int[] m1 = multiples(i,n);
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int[] m2 = not_multiples(i,n);
    }
    public static int msb(int i){
        int n = 0;
        while (i > 1){
            i >>= 1;
            n++;
        }
        return n;
    }
    public static int[] multiples(int i, int n){
        int size = 0;
        if (n == 0) return new int[0];  // если номер старшего бита ноль, возвращаем пустой массив
        for (int j = i; j < Short.MAX_VALUE; j++) if (j % n == 0) size++;
        int[] multiples_array = new int[size];
        int index = 0;
        for (int k = i; k < Short.MAX_VALUE; k++) {
            if (k % n == 0){
                multiples_array[index] = k;
                index++;
            }
        }
        return multiples_array;
    }
    public static int[] not_multiples(int i, int n){
        int size = 0;
        if (n == 0) return new int[0];  // если номер старшего бита ноль, возвращаем пустой массив
        for (int j = Short.MIN_VALUE; j < i; j++) if (j % n != 0) size++;
        int[] not_multiples_array = new int[size];
        int index = 0;
        for (int k = Short.MIN_VALUE; k < i; k++) {
            if (k % n != 0){
                not_multiples_array[index] = k;
                index++;
            }
        }
        return not_multiples_array;
    }
}