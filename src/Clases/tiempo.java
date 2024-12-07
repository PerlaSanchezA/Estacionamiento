/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Vanessa
 */
public class tiempo {
    // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Obtener la hora actual
        LocalTime horaActual = LocalTime.now();

        // Formatear la fecha y la hora por separado
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
         public String fechaFormateada = fechaActual.format(formatterFecha);
        public String horaFormateada = horaActual.format(formatterHora);
}
