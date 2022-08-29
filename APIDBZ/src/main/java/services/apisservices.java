
package services;

import java.io.IOException;
import modelo.persona;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public class apisservices {

    public static JSONObject consumiendoAPI(persona per)throws Exception{

        String token = "387b744d65398896962dd65bf19786bfe8386f98ec9c433950f8bb90d7c25ee0";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://apiperu.dev/api/dni/"+ per.getDNI())
//                .method("GET", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();
        Response response = client.newCall(request).execute();
        
        //lineas añadidas al OKhttp
        JSONObject cadenaJson = new JSONObject(response.body().string());
        JSONObject cadena = cadenaJson.getJSONObject("data");
        
        return cadena;
    }
    
    public static void main(String[] args) throws IOException ,Exception{
        persona per = new persona();
        per.setDNI("71134330");
        JSONObject json = apisservices.consumiendoAPI(per);
        System.out.println("nombre completo " + json.getString("nombre_completo"));
               
    }
}
