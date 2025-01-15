import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3,4,3,1));


        Set<Integer> set = new HashSet<Integer>();
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();


        for (int i = 0; i < list.size(); i++) {
            if (set.contains(list.get(i))) {
                sb.append(1);

            }else {
                set.add(list.get(i));
                sb.append(0);
            }

            int current = list.get(i);
            int freq = Collections.frequency(list, current);

            if (freq>1) {
                sb2.append(1);
                list.remove(i);
                i--;
            } else {
                sb2.append(0);
            }
        }

    










        System.out.println(sb);
        System.out.println(sb2);
    }
}