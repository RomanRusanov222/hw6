package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Notebook> priceList = new ArrayList<>();
        priceList.add(new Notebook("Sony", "vaio", "white", 15.6, 4, 500, "windows 10"));
        priceList.add(new Notebook("Lenovo", "v", "black", 14.1, 6, 1000, "windows 9"));
        priceList.add(new Notebook("Samsung", "a", "grey", 17.3, 8, 1200, "Linux"));
        priceList.add(new Notebook("Apple", "o", "white", 15.6, 4, 600, "MacOs"));
        priceList.add(new Notebook("Asus", "t", "red", 17, 4, 800, "windows 8"));
        priceList.add(new Notebook("Acer", "k", "green", 15.6, 4, 900, "windows 7"));
        priceList.add(new Notebook("HP", "n", "black", 15.4, 4, 250, "windows 11"));
        priceList.add(new Notebook("Dell", "v", "white", 15, 4, 400, "windows 12"));
        priceList.add(new Notebook("MSI", "p", "white", 19, 4, 500, "windows 8"));
        priceList.add(new Notebook("Sony", "b", "white", 14,1, 500, "windows 9"));

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        Map<String,String> searchParams = new HashMap<>();
        while (!exit) {
            System.out.println("“Введите цифру, соответствующую необходимому критерию:\n" +
                    "1 - Марка\n" +
                    "2 - Модель\n" +
                    "3 - Цвет\n" +
                    "4 - Диагональ\n" +
                    "5 - ОЗУ\n" +
                    "6 - HDD\n" +
                    "7 - Операционная система\n" +
                    "8 - Выход");
            int select = sc.nextInt();
            if(select==8){
                exit=true;
            } else {
                System.out.println("Введите значение");
                String value = sc.next();
                String key = "";
                if (select == 1) {
                    key = "marka";
                }
                if (select == 2) {
                    key = "model";
                }
                if (select == 3) {
                    key = "color";
                }
                if (select == 4) {
                    key = "diagonal";
                }
                if (select == 5) {
                    key = "ozu";
                }
                if (select == 6) {
                    key = "hdd";
                }
                if (select == 7) {
                    key = "os";
                }
                searchParams.put(key, value);
            }

        }
        List<Notebook> result = new ArrayList<>();
        for (Notebook current : priceList) {
            int matches = 0;
            for (String key : searchParams.keySet()) {
                if (key.equals("marka") || key.equals("model") || key.equals("color") || key.equals("os")) {
                    String value = (String) current.getParams().get(key);
                    if (value.equalsIgnoreCase(searchParams.get(key))) {
                        matches++;
                    }
                } else {
                    double value = (double) current.getParams().get(key);
                    if (value >= Double.parseDouble(searchParams.get(key))) {
                        matches++;
                    }
                }
            }
            if (matches == searchParams.size()) {
                result.add(current);
            }

        }
        if (result.isEmpty()) {
            System.out.println("Нет результата");
        }
        for (Notebook a : result) {
            System.out.println(a);
        }



    }
}