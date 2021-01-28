/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.models;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author umansilla
 */
public class SmsStatusCallBack {
    private String accountSid;
    private String apiVersion;
    private String body;
    private String dirstatus;
    private String errorMessage;
    private String from;
    private String price;
    private String smsSid;
    private String smsStatus;
    private String to;

    public SmsStatusCallBack(HttpServletRequest request) {
        this.accountSid = request.getParameter("AccountSid");
        this.apiVersion = request.getParameter("ApiVersion");
        this.body = request.getParameter("Body");
        this.dirstatus = request.getParameter("DlrStatus");
        this.errorMessage = request.getParameter("ErrorMessage");
        this.from = request.getParameter("From");
        this.price = request.getParameter("Price");
        this.smsSid = request.getParameter("SmsSid");
        this.smsStatus = request.getParameter("SmsStatus");
        this.to = request.getParameter("To");
    }

    
    
    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDirstatus() {
        return dirstatus;
    }

    public void setDirstatus(String dirstatus) {
        this.dirstatus = dirstatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSmsSid() {
        return smsSid;
    }

    public void setSmsSid(String smsSid) {
        this.smsSid = smsSid;
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    
    
}
