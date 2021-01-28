/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.cpaasworkshop.innpulsa.log.EscribirEnLog;
import service.cpaasworkshop.innpulsa.models.CallConnectModel;
import service.cpaasworkshop.innpulsa.util.Funciones;

/**
 *
 * @author umansilla
 */
public class OutBoundCallURL extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new Funciones().setAccessControlHeadersXML(response);
        try {
            CallConnectModel callConnect = new CallConnectModel(request);
            new EscribirEnLog().crearLog(callConnect.toString(), request.getServletContext().getRealPath(""));
            String result = "<Response>\n"
                    + "    <Say voice=\"man\" language=\"es-us\" loop=\"10\">Hola Mundo</Say>\n"
                    + "</Response>";
            response.getWriter().println(result);

        } catch (IOException e) {
            new EscribirEnLog().crearLog("Error: " + e.toString(), request.getServletContext().getRealPath(""));
            System.out.println("Error: " + e.toString());
        }
    }

}
