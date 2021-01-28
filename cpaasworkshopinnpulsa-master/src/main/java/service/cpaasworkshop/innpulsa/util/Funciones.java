/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.util;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author umansilla
 */
public class Funciones {
    
    public void setAccessControlHeadersXML(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", Constants.ACCESS_ORIGIN);
        response.setHeader("Access-Control-Allow-Credentials", Constants.ACCESS_CREDENTIALS);
        response.setHeader("Access-Control-Allow-Methods", Constants.ACCESS_METHODS);
        response.setHeader("Access-Control-Allow-Headers", Constants.ACCESS_HEADERS);
        response.setHeader("Content-Type", Constants.CONTENT_TYPE_XML);
    }
}
