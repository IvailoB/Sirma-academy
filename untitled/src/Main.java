import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String nameList1 = "petaraleksandardimitargeorgi";
        String nameList2 = "dimitarivanaleksandarmartingeorgi";
        String expectedResult = "aleksandar";
        String actualResult = findLongestMatchingName(nameList1, nameList2);
        System.out.printf("You matched the correct name: %s", actualResult.equals(expectedResult));
    }


    public static String findLongestMatchingName(String input1, String input2) {
        List<String> list1 = createNameList(input1);
        List<String> list2 = createNameList(input2);

        String longestName = "";
        for (String name1 : list1) {
            for (String name2 : list2) {
                if (name1.equals(name2) && name1.length() > longestName.length()) {
                    longestName = name1;
                }
            }
        }
        return longestName;
    }

    public static List<String> createNameList(String input) {
        List<String> names = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            int j = i + 1;
            while (j <= input.length()) {
                String name = input.substring(i, j);
                names.add(name);
                j++;
            }
            i++;
        }
        return names;
    }
}
