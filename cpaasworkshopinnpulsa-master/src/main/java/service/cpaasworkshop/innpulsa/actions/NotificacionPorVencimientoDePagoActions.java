/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.actions;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import service.cpaasworkshop.innpulsa.http.APICPaaSWorkShop;
import service.cpaasworkshop.innpulsa.log.EscribirEnLog;
import service.cpaasworkshop.innpulsa.models.GatherStatusModel;
import service.cpaasworkshop.innpulsa.util.Constants_Attributes;

/**
 *
 * @author umansilla
 */
public class NotificacionPorVencimientoDePagoActions {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public NotificacionPorVencimientoDePagoActions(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void getInicioXML() throws IOException {
        String usuario = request.getParameter("usuario");
        String cuenta = request.getParameter("cuenta");
        String deuda = request.getParameter("deuda");
        response.getWriter().println("<Response>\n"
                + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_NVP_SALUDO_INICIAL
                + "?nivel=inicio&usuario=" + usuario + "&cuenta=" + cuenta + "&deuda=" + deuda + "</Redirect>\n"
                + "</Response>\n"
                + "");
    }

    public void validarRespuesta(GatherStatusModel gatherStatus) throws IOException {
        String usuario = request.getParameter("usuario");
        String cuenta = request.getParameter("cuenta");
        String deuda = request.getParameter("deuda");
        if (gatherStatus.getDigits().length() != 0) {
            switch (gatherStatus.getDigits()) {
                case "1":
                    JSONObject jsonObjectUsuario = new APICPaaSWorkShop().obtenerUsuarioPorNumeroDeCuenta(cuenta, Constants_Attributes.CUENTA_API);
                    new EscribirEnLog().crearLog(jsonObjectUsuario.toString(2), request.getServletContext().getRealPath(""));
                    if (jsonObjectUsuario.has("usuario")) {
                        JSONObject jsonResponse = new APICPaaSWorkShop().editarUsuarioPorNumeroDeCuenta(cuenta, jsonObjectUsuario.getJSONObject("usuario"), Constants_Attributes.CUENTA_API, Constants_Attributes.TOKEN_CUENTA_API);
                        new EscribirEnLog().crearLog(jsonResponse.toString(2), request.getServletContext().getRealPath(""));
                        if (jsonResponse.has("status") && jsonResponse.getString("status").equals("ok")) {
                            response.getWriter().println("<Response>\n"
                                    + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_NVP_DESPEDIDA + "</Redirect>\n"
                                    + "</Response>\n"
                                    + "");
                        }
                    }
                    break;
                default:
                    response.getWriter().println("<Response>\n"
                            + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_NVP_SALUDO_INICIAL
                            + "?nivel=inicio&usuario=" + usuario + "&cuenta=" + cuenta + "&deuda=" + deuda + "</Redirect>\n"
                            + "</Response>\n"
                            + "");
                    break;
            }
        } else {
            response.getWriter().println("<Response>\n"
                    + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_NVP_SALUDO_INICIAL
                    + "?nivel=inicio&usuario=" + usuario + "&cuenta=" + cuenta + "&deuda=" + deuda + "</Redirect>\n"
                    + "</Response>\n"
                    + "");
        }

    }
}
