package com.lab4;


import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;


public class Main {

    /**
     * Verifica daca un rezident este primul in lista de preferinte a unui spital
     * @param residentsPreferenceList lista cu preferintele unui spital in materie de rezidenti
     * @param resident un anume rezident
     * @return true daca este primul, false altfel
     */
    public static boolean hospitalTopPreference(List<Resident> residentsPreferenceList, Resident resident) {
        return residentsPreferenceList.get(0).equals(resident);
    }

    public static void main(String[] args) {
        /**
         * Se creeaza un Array de tip Resident[] in care fiecare obiect de tip Resident apeleaza constructorul cu parametru
         * de tip String si primeste un nume Ri unde 0 <= i <= 3
         */
        var residents = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R" + i) ).toArray(Resident[]::new);
        /**
         * Se creeaza un Array de tip Hospital[] in care fiecare obiect de tip Hospital apeleaza constructorul cu parametru
         * de tip String si primeste un nume Hi unde 0 <= i <= 2
         */
        var hospitals = IntStream.rangeClosed(0, 2).mapToObj(i -> new Hospital("H" + i) ).toArray(Hospital[]::new);

        hospitals[0].setCapacity(1);
        hospitals[1].setCapacity(2);
        hospitals[2].setCapacity(2);

        List<Resident> residentList = new ArrayList<>(Arrays.asList(residents));

        /**
         * Se creaza o varianta sortata a Array-ului residentList folosindu-se un comparator pe baza metodei publice getName
         * din clasa Resident
         */
        List<Resident> newResidentSortedList = residentList.stream().sorted(Comparator.comparing(Resident::getName)).collect(Collectors.toList());

        Set<Hospital> hospitalSet = new TreeSet<>(Arrays.asList(hospitals));

        Map<Resident, List<Hospital>> residentsPreferenceMap = new HashMap<>();
        residentsPreferenceMap.put(residents[0], Arrays.asList(hospitals[0], hospitals[1], hospitals[2]));
        residentsPreferenceMap.put(residents[1], Arrays.asList(hospitals[0], hospitals[1], hospitals[2]));
        residentsPreferenceMap.put(residents[2], Arrays.asList(hospitals[0], hospitals[1]));
        residentsPreferenceMap.put(residents[3], Arrays.asList(hospitals[0], hospitals[2]));

        /**
         * Se afiseaza perechi de forma (key = value) unde key este numele unui obiect de tip Resident si value este o lista
         * de nume ale obiectelor de tip Hospital
         */
        residentsPreferenceMap.entrySet().stream().forEach(System.out::println);
        System.out.println("\n");

        Map<Hospital, List<Resident>> hospitalsPreferenceMap = new LinkedHashMap<>();
        hospitalsPreferenceMap.put(hospitals[0], Arrays.asList(residents[3], residents[0], residents[1], residents[2]));
        hospitalsPreferenceMap.put(hospitals[1], Arrays.asList(residents[0], residents[2], residents[1]));
        hospitalsPreferenceMap.put(hospitals[2], Arrays.asList(residents[0], residents[1], residents[2]));

        /**
         * Se afiseaza perechi de forma (key = value) unde key este numele unui obiect de tip Hospital si value este o lista
         * de nume ale obiectelor  de tip Resident
         */
        hospitalsPreferenceMap.entrySet().stream().forEach(System.out::println);
        System.out.println();

        List<Hospital> target = Arrays.asList(hospitals[0], hospitals[2]);
        List<Resident> result = residentList.stream().filter(res -> residentsPreferenceMap.get(res).containsAll(target)).collect(Collectors.toList());

        System.out.println("Rezidentii care prefera spitalele H0 si H2 sunt:");
        result.stream().forEach(System.out::println);
        System.out.println();

        System.out.println("Spitalele care au ca top preferinta rezidentul R0 sunt:");
        hospitalSet.stream().filter(res -> hospitalTopPreference(hospitalsPreferenceMap.get(res), residents[0])).forEach(System.out::println);
        System.out.println();
    }
}
