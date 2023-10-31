import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        String nameList1 = "petaraleksandarblagoevgrddimitargeorgi";
        String nameList2 = "petardimitarivanaleksandarmartingeorgiblagoevgrd";
        String expectedResult = "aleksandar";
        String actualResult = findLongestMatchingName(nameList1, nameList2);
        System.out.printf("You matched the correct name: %s and %s", actualResult,expectedResult);


//        1. обикаляме целия стинг и правим лист от имена, комбинация от всеки символ и ги запазваме.
//        2. същото и за nameList2
//        3. обикаляме запазените имена и ги сравняваме дали са еднакви и тяхната дължина.
//        4. запазваме и връщаме желаното име.
    }


    private static String findLongestMatchingName(String nameList1, String nameList2) {

        List<String> names1 = new ArrayList<>();
        List<String> names2 = new ArrayList<>();
        AtomicReference<String> longestName = new AtomicReference<>("");

//        за да намерим най- дългото име, трябва да намерим всяка възможна комбинация на символите,
//        образуват име. Това ще рече да направим име със всеки един символ.

//          ПРИМЕР:
//        String nameList1 = "petar";
//        String nameList2 = "petar";
//        образува име със всички символи.
//        Примерен изход: names = "p","pe","pet"... "e","et","eta"... "t","ta","tar"
        for (int i = 0; i < nameList1.length(); i++) {
            for (int j = i + 1; j <= nameList1.length(); j++) {
                names1.add(nameList1.substring(i, j));  //създава се ново име и се запазва в лист като нова стойност
            }
        }

        for (int i = 0; i < nameList2.length(); i++) {
            for (int j = i + 1; j <= nameList2.length(); j++) {
                names2.add(nameList2.substring(i, j));  //създава се ново име и се запазва в лист като нова стойност
            }
        }

//      Проверка в дали има съвпадащи имена и тяхната дължина, като се взима най- дългата
//      Взимаме първото име от листа names1 и го сравняваме със всяко име от names2.
//      най-дългото име се променя ако дължината на равните имета е различна.
//     ----------- Но ако име 2 имена с равна дължина?--------

//     Взима първото име, което се сраща в names1
        names1.forEach(name -> {
            names2.forEach(name2 -> {
                if (name.equals(name2) && name.length() > longestName.get().length()) {
                    longestName.set(name);
                }
            });
        });

//        За да взима последно срещаното

//        names1.forEach(name -> {
//            names2.forEach(name2 -> {
//                if (name.equals(name2) && name.length() >= longestName.get().length()) {
//                    longestName.set(name);
//                }
//            });
//        });


        return longestName.get();

    }
}