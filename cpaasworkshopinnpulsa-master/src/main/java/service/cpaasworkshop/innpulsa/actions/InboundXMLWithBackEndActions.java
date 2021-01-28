/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.actions;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import service.cpaasworkshop.innpulsa.http.APICPaaSWorkShop;
import service.cpaasworkshop.innpulsa.models.GatherStatusModel;
import service.cpaasworkshop.innpulsa.util.Constants_Attributes;

/**
 *
 * @author umansilla
 */
public class InboundXMLWithBackEndActions {

    private final HttpServletResponse response;

    public InboundXMLWithBackEndActions(HttpServletResponse response) {
        this.response = response;
    }

    public void getBienvenida() throws IOException {
        response.getWriter().println("<Response>\n"
                + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACKEND_BIENVENIDA + "</Redirect>\n"
                + "</Response>\n"
                + "");
    }

    public void getMenuAction(GatherStatusModel gatherStatus) throws IOException {
        if (gatherStatus.getDigits().length() != 0) {
            switch (gatherStatus.getDigits()) {
                case "0":
                    response.getWriter().println("<Response>\n"
                            + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACK_END_AGENTE + "</Redirect>\n"
                            + "</Response>\n"
                            + "");
                    break;
                case "1":
                    response.getWriter().println("<Response>\n"
                            + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACK_END_PROMOCIONES + "</Redirect>\n"
                            + "</Response>\n"
                            + "");
                    break;
                case "2":
                    response.getWriter().println("<Response>\n"
                            + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACK_END_NUMERO_DE_CUENTA + "</Redirect>\n"
                            + "</Response>\n"
                            + "");

                    break;
                case "3":
                    response.getWriter().println("<Response>\n"
                            + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACKEND_HANGUP + "</Redirect>\n"
                            + "</Response>\n"
                            + "");
                    break;
                default:
                    response.getWriter().println("<Response>\n"
                            + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACKEND_BIENVENIDA + "</Redirect>\n"
                            + "</Response>\n"
                            + "");
                    break;
            }
        }
    }

    public void getNumeroDeCuentaValidacion(GatherStatusModel gatherStatus) throws IOException {
        if (gatherStatus.getDigits().length() != 0) {
            if (gatherStatus.getDigits().length() == 6) {
                JSONObject json = new APICPaaSWorkShop().obtenerUsuarioPorNumeroDeCuenta(gatherStatus.getDigits().replaceAll(" ", "").trim(), Constants_Attributes.CUENTA_API);
                if (json.has("status") && json.has("message") && json.has("usuario")) {
                    String nombreUsuario = json.getJSONObject("usuario").getString("nombre");
                    String saldoActual = json.getJSONObject("usuario").getString("saldoactual");
                    String deudaActual = json.getJSONObject("usuario").getString("creditopromocion");
                    response.getWriter().println("<Response>\n"
                            + " <Say voice=\"female\" language=\"es-us\">Estimado " + nombreUsuario + " su saldo actual es de " + saldoActual + ". Actualmente tiene una deuda vigente de " + deudaActual + "</Say>\n"
                            + " <Pause length=\"1\"/> \n"
                            + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACKEND_BIENVENIDA + "</Redirect>\n"
                            + "</Response>\n"
                            + "");
                } else {
                    response.getWriter().println("<Response>\n"
                            + " <Say voice=\"female\" language=\"es-us\">El número de cuenta no exite</Say>\n"
                            + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACKEND_BIENVENIDA + "</Redirect>\n"
                            + "</Response>\n"
                            + "");
                }

            } else {
                response.getWriter().println("<Response>\n"
                        + " <Say voice=\"female\" language=\"es-us\">El número de cuenta no cumple con la longitud indicada.</Say>\n"
                        + "    <Redirect method=\"POST\">" + Constants_Attributes.INNPULSA_IVR_WITH_BACKEND_BIENVENIDA + "</Redirect>\n"
                        + "</Response>\n"
                        + "");
            }
        }
    }
}
