import java.io.File;
import java.util.*;

public class Main {

    static List<File> fileList;

    public static void main(String[] args) {
        task7();
        task4();
    }


    private static void task4() {
        File dir = new File("/home/den/IdeaProjects");
        fileList = new ArrayList<>();
        forTask4(dir);
        fileList.forEach(file -> System.out.println(file.getName()));
    }

    private static void forTask4(File file) {
        if (file.isDirectory()) {
            List<File> files = Arrays.asList(file.listFiles());
            fileList.addAll(files);
            files.stream().filter(File::isDirectory).forEach(Main::forTask4);
        }
    }


    private static void task7() {
        Queue<Integer> linkedList1 = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Queue<Integer> linkedList2 = new LinkedList<Integer>(Arrays.asList(7, 8, 9, 10));
        List<Integer> buffer = new LinkedList<Integer>();
        buffer.addAll(linkedList2);
        linkedList2.clear();
        linkedList2.addAll(linkedList1);
        linkedList1.clear();
        linkedList1.addAll(buffer);

        //out
        System.out.println("ll1");
        linkedList1.forEach(System.out::print);
        System.out.println("");
        System.out.println("ll2");
        linkedList2.forEach(System.out::print);
    }
}