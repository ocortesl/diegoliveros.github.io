/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

/**
 *
 * @author umansilla
 */
public class EscribirEnLog {

    private FileWriter archivo; //nuestro archivo log

    public void crearLog(String operacion, String url) throws IOException {

        File file = new File(url + "log.txt");

        try (FileOutputStream fos = new FileOutputStream(file, true);
                OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.ISO_8859_1);
                BufferedWriter writer = new BufferedWriter(osw)) {
            Calendar fechaActual = Calendar.getInstance(); //Para poder utilizar el paquete calendar
            writer.append((String.valueOf(fechaActual.get(Calendar.DAY_OF_MONTH))
                    + "/" + String.valueOf(fechaActual.get(Calendar.MONTH) + 1)
                    + "/" + String.valueOf(fechaActual.get(Calendar.YEAR))
                    + ";" + String.valueOf(fechaActual.get(Calendar.HOUR_OF_DAY))
                    + ":" + String.valueOf(fechaActual.get(Calendar.MINUTE))
                    + ":" + String.valueOf(fechaActual.get(Calendar.SECOND))) + " - " + operacion + "\r\n");
            //writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: al escribir log " + e.toString() );
        }

    }//Fin del metodo crearLog

}
