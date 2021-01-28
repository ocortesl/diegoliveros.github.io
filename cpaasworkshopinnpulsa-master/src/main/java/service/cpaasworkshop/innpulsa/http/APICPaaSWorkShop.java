/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

/**
 *
 * @author umansilla
 */
public class APICPaaSWorkShop {

    public JSONObject editarUsuarioPorNumeroDeCuenta(String cuenta, JSONObject jsonObjectUsuario, String cuentaAPI, String tokenCuenta) throws IOException {
        final String URI = "https://breeze2-197.collaboratory.avaya.com/services/AAADEVCPaaSWorkShopAPI/ws/usuarios/" + cuenta;
        final CloseableHttpClient client = HttpClients.createDefault();
        final HttpPut putMethod = new HttpPut(URI);
        putMethod.setHeader("Content-Type", "application/json");
        putMethod.setHeader("Authorization", "Bearer " + tokenCuenta);
        JSONObject payLoad = new JSONObject();
        payLoad.put("nombre", jsonObjectUsuario.getString("nombre"));
        payLoad.put("email", jsonObjectUsuario.getString("email"));
        payLoad.put("telefonomovil", jsonObjectUsuario.getString("telefonomovil"));
        payLoad.put("telefonofijo", jsonObjectUsuario.getString("telefonofijo"));
        payLoad.put("saldoactual", jsonObjectUsuario.getString("saldoactual"));
        payLoad.put("creditopromocion", jsonObjectUsuario.getString("creditopromocion"));
        payLoad.put("pinautorizacion", "1");
        StringEntity entity = new StringEntity(payLoad.toString(), StandardCharsets.UTF_8);
        putMethod.setEntity(entity);
        final CloseableHttpResponse response = client.execute(putMethod);
        final BufferedReader inputStream = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        String line = "";
        final StringBuilder result = new StringBuilder();
        while ((line = inputStream.readLine()) != null) {
            result.append(line);
        }
        return new JSONObject(result.toString());
    }

    public JSONObject obtenerUsuarioPorNumeroDeCuenta(String numeroDeCuenta, String cuentaAPI) throws IOException {
        final String URI = "https://breeze2-197.collaboratory.avaya.com/services/AAADEVCPaaSWorkShopAPI/ws/usuarios/" + numeroDeCuenta + "/numerodecuenta?cuenta=" + cuentaAPI;
        final CloseableHttpClient client = HttpClients.createDefault();
        final HttpGet getMethod = new HttpGet(URI);
        final CloseableHttpResponse response = client.execute(getMethod);
        final BufferedReader inputStream = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        String line = "";
        final StringBuilder result = new StringBuilder();
        while ((line = inputStream.readLine()) != null) {
            result.append(line);
        }
        return new JSONObject(result.toString());
    }
}
