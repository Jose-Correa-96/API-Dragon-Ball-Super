package controlador;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;
import modelo.personajes;
import services.apiDBS;

@Named(value = "ApiC")
@Data
@SessionScoped
public class ApiC implements Serializable {

    personajes per;


    public ApiC() {
        per = new personajes();
    }

    public void consumiendo(){
        try {
//            per.setName("Awamo");
            apiDBS.consumiendoAPI(per);
        } catch (Exception e) {
            System.out.println("problemas en conumiendoC " + e.getMessage());
        }

    }
}
