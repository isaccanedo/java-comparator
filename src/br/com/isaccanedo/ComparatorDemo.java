package br.com.isaccanedo;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author Isac Canedo
 */

public class ComparatorDemo {

    public static void main(String[] args) {
        Comparator<String> cmp = new MyCmp();
        Comparator<String> othercmp = new MyCmp2();
        TreeMap<String, Double> aMap = new TreeMap<>(cmp.thenComparing(othercmp));
        aMap.put("John Doe", 1234.22);
        aMap.put("Tom Smith", 100.00);
        aMap.put("Jane Baler", 5678.22);
        aMap.put("Todd Doe", 444.20);
        aMap.put("Ralph Dine", 6756.0);
        System.out.println(aMap);

        // Mapa reverso usando comparador lambda
        Comparator<String> rev = (s1, s2) -> s2.compareTo(s1);
        TreeMap<String, Double> bMap = new TreeMap<>(rev);
        bMap.put("John Doe", 1234.22);
        bMap.put("Tom Smith", 100.00);
        bMap.put("Jane Baler", 5678.22);
        bMap.put("Todd Doe", 444.20);
        bMap.put("Ralph Dine", 6756.0);
        System.out.println(bMap);

        TreeMap<String, Double> cMap = new TreeMap<>((o1, o2) -> {
            int i = o1.lastIndexOf(" ");
            int j = o2.lastIndexOf(" ");
            String surname1 = o1.substring(i);
            String surname2 = o2.substring(j);
            int k = surname1.compareTo(surname2);
            if (k == 0)
                return o1.compareTo(o2);
            return surname1.compareTo(surname2);
        });
        cMap.put("John Doe", 1234.22);
        cMap.put("Tom Smith", 100.00);
        cMap.put("Jane Baler", 5678.22);
        cMap.put("Todd Doe", 444.20);
        cMap.put("Ralph Dine", 6756.0);
        System.out.println(cMap);

    }

}

class MyCmp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int i = o1.lastIndexOf(" ");
        int j = o2.lastIndexOf(" ");
        String surname1 = o1.substring(i);
        String surname2 = o2.substring(j);
        //int k = surname1.compareTo(surname2);
        /*
         * if (k == 0) return o1.compareTo(o2);
         */
        return surname1.compareTo(surname2);
    }

}

class MyCmp2 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

}