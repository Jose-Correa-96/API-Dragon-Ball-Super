/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import modelo.persona;
import org.json.JSONObject;

/**
 *
 * @author Lab 25
 */
public class apiUnirest {

    public static JSONObject consumiendoAPI2 (persona per) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://apiperu.dev/api/dni/" + per.getDNI())
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 387b744d65398896962dd65bf19786bfe8386f98ec9c433950f8bb90d7c25ee0")
                .asString();
        
                //lineas añadidas al OKhttp
        JSONObject cadenaJson = new JSONObject(response.getBody());
        JSONObject cadena = cadenaJson.getJSONObject("data");
        
        return cadena;
    }
    
    public static void main(String[] args) throws Exception {
        persona per = new persona();
        per.setDNI("70782063");
        JSONObject json = apisservices.consumiendoAPI(per);
        System.out.println("nombre completo " + json.getString("nombre_completo"));
    }
}
