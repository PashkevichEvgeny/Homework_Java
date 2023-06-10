import java.io.*;
import java.util.Random;

public class seminar2 {
    public static void main(String[] args) throws IOException {
//        Задание
//      Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
//      Данные для фильтрации приведены ниже в виде json-строки.
//      Если значение null, то параметр не должен попадать в запрос.
//      Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
        create_sql_filter();
//        Дополнительное задание
//      Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//      Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
//        Студент [фамилия] получил [оценка] по предмету [предмет].
//      Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
        write_json();
        templateChange();
//         Дополнительное задание
//      Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов
//      средствами String и StringBuilder.
        compareExecutionTime(10000);
    }
    public static void create_sql_filter() {
        String query = "select * from students where ";
        String filterData = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        filterData = filterData.replace("{", "");
        filterData = filterData.replace("}", "");
        String[] queryArray = filterData.replaceAll(":", " = ").split(",");
        StringBuilder sb = new StringBuilder();
        sb.append(query);
        for (int i = 0; i < queryArray.length; i++) {
            if (!queryArray[i].contains("null"))
                sb.append(queryArray[i].replaceFirst("\"", "").replaceFirst("\"", ""));
            if (i < queryArray.length - 2) sb.append(" and ");
        }
        System.out.println(sb);
    }

    public static void write_json() throws IOException {
//      Запись json файла
        FileWriter fileWriter = new FileWriter("data.json", false);
        fileWriter.write("[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
        fileWriter.flush();
        fileWriter.close();
    }

    public static void templateChange() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.json"));
        String[] initialText = bufferedReader.readLine().split("},\\{");
        String[] insertText = new String[] {"Студент", "получил", "по предмету"};
        StringBuilder newString = new StringBuilder();
        for (String valueInitial: initialText) {
            int start = 0;
            int end;
            for (String valueInsert : insertText) {
                start = valueInitial.indexOf(":", start) + 2;
                end = valueInitial.indexOf("\"", start);
                newString.append(valueInsert);
                newString.append(" ");
                newString.append(valueInitial, start, end);
                newString.append((valueInsert.equals(insertText[insertText.length - 1])) ? "\n": " ");
            }
        }
        System.out.println(newString.deleteCharAt(newString.lastIndexOf("\n")));
    }
    public static void compareExecutionTime(int size) {
        StringBuilder sb = new StringBuilder();       // Генерация случайного набора символов заданного размера - size
        for (int i = 0; i < size; i++) {
            if (i % 150 == 0) sb.append("\n");
            sb.append((char) new Random().nextInt(97,123));
        }

        long startTime = System.currentTimeMillis();  // Измерение работы StringBuilder
        int firstCharIndex = sb.indexOf("a", 0);
        int charIndex;
        for (int i = 0; i < sb.length(); i++) {
            sb.replace(firstCharIndex, firstCharIndex + 1, "A");
            charIndex = sb.indexOf("a", firstCharIndex + 1);
            if ( charIndex > 0) firstCharIndex = charIndex;
        }
        System.out.printf("%s миллисекунд для StringBuilder\n", System.currentTimeMillis() - startTime);

        String s = sb.toString();
        startTime = System.currentTimeMillis();     // Измерение работы String
        for (int i = 0; i < s.length(); i++) {
            s = s.replace("a", "A");
        }
        System.out.printf("%s миллисекунд для String\n", System.currentTimeMillis() - startTime);
    }
}