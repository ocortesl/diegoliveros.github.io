/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.util;

/**
 *
 * @author umansilla
 */
public class Constants_Attributes {
    //CUENTA API
    public final static String CUENTA_API = System.getenv("CUENTA_API");
    public final static String TOKEN_CUENTA_API = System.getenv("TOKEN_CUENTA_API");
    
    //EJEMPLO NOTIFICACION POR VENCIMIENTO DE PAGO
    public final static String INNPULSA_NVP_SALUDO_INICIAL = System.getenv("INNPULSA_NVP_SALUDO_INICIAL");
    public final static String INNPULSA_NVP_DESPEDIDA = System.getenv("INNPULSA_NVP_DESPEDIDA");
    
    
    //EJEMPLO INBOUND XML CON BACKEND
    public final static String INNPULSA_IVR_WITH_BACKEND_BIENVENIDA = System.getenv("INNPULSA_IVR_WITH_BACKEND_BIENVENIDA");
    public final static String INNPULSA_IVR_WITH_BACKEND_HANGUP = System.getenv("INNPULSA_IVR_WITH_BACKEND_HANGUP");
    public final static String INNPULSA_IVR_WITH_BACK_END_PROMOCIONES = System.getenv("INNPULSA_IVR_WITH_BACK_END_PROMOCIONES");
    public final static String INNPULSA_IVR_WITH_BACK_END_AGENTE = System.getenv("INNPULSA_IVR_WITH_BACK_END_AGENTE");
    public final static String INNPULSA_IVR_WITH_BACK_END_NUMERO_DE_CUENTA = System.getenv("INNPULSA_IVR_WITH_BACK_END_NUMERO_DE_CUENTA");
    
    //EJEMPLO CONFERENCIA
    public final static String CONFERENCE_INBOUND_XML_URL = "https://cloud.zang.io/data/inboundxml/09ba72abff63383141aef3c114ff7c050eb95040";
}
