/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.lang.reflect.Array;
import lombok.Data;

@Data
public class personajes {
    int id;
    String name;
    String specie;
    String role;
    String imagen;
    String status;
    String universe;
    Array tranformacion;
    
}
