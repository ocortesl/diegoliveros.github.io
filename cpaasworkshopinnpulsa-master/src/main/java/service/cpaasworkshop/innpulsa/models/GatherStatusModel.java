/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.cpaasworkshop.innpulsa.models;

import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author umansilla
 */
public class GatherStatusModel {

    private String accountSID;
    private String answeredBy;
    private String apiVersion;
    private String callDuration;
    private String callSid;
    private String callStatus;
    private String callerName;
    private String confidence;
    private String direction;
    private String from;
    private String playStatus;
    private String speechResult;
    private String speechResultError;
    private String to;
    private String ulrBase;
    private String digits;

    public GatherStatusModel(HttpServletRequest request) {
        this.accountSID = request.getParameter("AccountSid");
        this.answeredBy = request.getParameter("AnsweredBy");
        this.apiVersion = request.getParameter("ApiVersion");
        this.callDuration = request.getParameter("CallDuration");
        this.callSid = request.getParameter("CallSid");
        this.callStatus = request.getParameter("CallStatus");
        this.callerName = request.getParameter("CallerName");
        this.confidence = request.getParameter("Confidence");
        this.direction = request.getParameter("Direction");
        this.from = request.getParameter("From");
        this.playStatus = request.getParameter("PlayStatus");
        this.speechResult = request.getParameter("SpeechResult");
        this.speechResultError = request.getParameter("SpeechResultError");
        this.to = request.getParameter("To");
        this.ulrBase = request.getParameter("UrlBase");
        this.digits = request.getParameter("Digits");
    }

    public String getAccountSID() {
        return accountSID;
    }

    public void setAccountSID(String accountSID) {
        this.accountSID = accountSID;
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

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
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

    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        this.playStatus = playStatus;
    }

    public String getSpeechResult() {
        return speechResult;
    }

    public void setSpeechResult(String speechResult) {
        this.speechResult = speechResult;
    }

    public String getSpeechResultError() {
        return speechResultError;
    }

    public void setSpeechResultError(String speechResultError) {
        this.speechResultError = speechResultError;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getUlrBase() {
        return ulrBase;
    }

    public void setUlrBase(String ulrBase) {
        this.ulrBase = ulrBase;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }

    @Override
    public String toString() {
        return "CallBackGatherStatus{" + "accountSID=" + accountSID + ", answeredBy=" + answeredBy + ", apiVersion=" + apiVersion + ", callDuration=" + callDuration + ", callSid=" + callSid + ", callStatus=" + callStatus + ", callerName=" + callerName + ", confidence=" + confidence + ", direction=" + direction + ", from=" + from + ", playStatus=" + playStatus + ", speechResult=" + speechResult + ", speechResultError=" + speechResultError + ", to=" + to + ", ulrBase=" + ulrBase + ", digits=" + digits + '}';
    }

}
