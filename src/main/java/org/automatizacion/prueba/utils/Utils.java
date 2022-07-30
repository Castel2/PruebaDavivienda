package org.automatizacion.prueba.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> prices() {
        List<String> listPrices = new ArrayList<>();
        listPrices.add("29.99");
        listPrices.add("9.99");
        listPrices.add("15.99");
        listPrices.add("49.99");
        listPrices.add("7.99");
        return listPrices;
    }

    public static void Eliminarprices(List<String> listPrices, String price) {
        for (int i = 0; i < listPrices.size(); i++) {
            if(listPrices.get(i).trim().equals(price.trim())){
                listPrices.remove(i);
                break;
            }
        }
    }

    public static float CompraTotal(List<String> listPrices) {
        float total = 0;
        for (int i = 0; i < listPrices.size(); i++) {
            total = total + Float.parseFloat(listPrices.get(i));
        }
        return total;
    }

}
