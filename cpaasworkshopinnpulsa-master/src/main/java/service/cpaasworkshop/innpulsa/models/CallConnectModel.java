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
public class CallConnectModel {
    private String accountSid;
    private String answeredBy;
    private String apiVersion;
    private String callDuration;
    private String callSid;
    private String callStatus;
    private String callerName;
    private String direction;
    private String from;
    private String to;
    private String urlBase;

    public CallConnectModel(HttpServletRequest request) {
        this.accountSid = request.getParameter("AccountSid");
        this.answeredBy = request.getParameter("AnsweredBy");
        this.apiVersion = request.getParameter("ApiVersion");
        this.callDuration = request.getParameter("CallDuration");
        this.callSid = request.getParameter("CallSid");
        this.callStatus = request.getParameter("CallStatus");
        this.callerName = request.getParameter("CallerName");
        this.direction = request.getParameter("Direction");
        this.from = request.getParameter("From");
        this.to = request.getParameter("To");
        this.urlBase = request.getParameter("UrlBase");
    }
    
    

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAnsweredBy() {
        return answeredBy;
    }

    public void setAnsweredBy(String answeredBy) {
        this.answeredBy = answeredBy;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    public String getCallSid() {
        return callSid;
    }

    public void setCallSid(String callSid) {
        this.callSid = callSid;
    }

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }

    @Override
    public String toString() {
        return "CallConnectModel{" + "accountSid=" + accountSid + ", answeredBy=" + answeredBy + ", apiVersion=" + apiVersion + ", callDuration=" + callDuration + ", callSid=" + callSid + ", callStatus=" + callStatus + ", callerName=" + callerName + ", direction=" + direction + ", from=" + from + ", to=" + to + ", urlBase=" + urlBase + '}';
    }
    
    
}
