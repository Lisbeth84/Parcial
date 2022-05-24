
package com.example.autor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Lisbeth
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    private int	idautor ;
    private String nombres ;
    private String apellidos;
    private String correo;
    
}
