import java.util.HashMap;
import java.util.Iterator;

//Вам нужно написать класс имитирующий работу hashset и хранящий int
public class seminar6 {
    public static void main(String[] args) {
        MySet map = new MySet();
        System.out.println(map.isEmpty());
        System.out.println(map.add(1));
        System.out.println(map.add(2));
        System.out.println(map.add(1));
        System.out.println(map.add(3));
        System.out.println(map.contains(2));
        System.out.println(map.delete(2));
        System.out.println(map.delete(2));
        System.out.println(map.isEmpty());
        System.out.println(map.contains(2));
        System.out.println(map.get(1));
        Iterator<Integer> iterator = map.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class MySet {
    private final HashMap<Integer, Object> myDB = new HashMap<>();
    private static final Object MYOBJ = new Object();
    public boolean add(int elem) {
        return myDB.put(elem, MYOBJ) == null;
     }
    public boolean delete(int elem) {
        return myDB.remove(elem)==MYOBJ;
    }
    public boolean isEmpty() {
        return myDB.size()==0;
    }
    public boolean contains(int elem){
        return myDB.containsKey(elem);
    }
    public int get(int index){
        return (int) myDB.keySet().toArray()[index];
    }
    public Iterator<Integer> iterator (){
        return myDB.keySet().iterator();
    }
}
