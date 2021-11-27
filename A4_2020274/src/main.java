import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class main {
    public static void main(String[] args) {

        String s = "abc";
        String t = "cba";
        ArrayList<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("cba");
        list.add("aaa");
        Collections.sort(list);
        System.out.println(list);
    }
}
