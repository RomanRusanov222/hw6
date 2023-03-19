package org.example;

import java.util.HashMap;
import java.util.Map;

public class Notebook {

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    private Map<String,Object> params = new HashMap<>();
    public Notebook(String marka, String model, String color, double diagonal, double ozu, double hdd, String operationSystem) {
        params.put("marka", marka);
        params.put("model", model);
        params.put("color", color);
        params.put("diagonal", diagonal);
        params.put("ozu", ozu);
        params.put("hdd", hdd);
        params.put("os", operationSystem);
    }
    public String toString () {
        String r = "";
        for (String key : params.keySet()) {
            r = r+key + " "+ params.get(key)+";";
        }
        return r;
    }


}