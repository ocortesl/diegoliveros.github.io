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
public class ConferenceStatusModel {

    private String accountSid;
    private String apiVersion;
    private String callSid;
    private String callStatus;
    private String callerName;
    private String conferenceAction;
    private String conferenceName;
    private String conferenceParticipantCount;
    private String conferenceSid;
    private String deaf;
    private String digits;
    private String direction;
    private String from;
    private String muted;
    private String participantSid;
    private String to;

    public ConferenceStatusModel(HttpServletRequest request) {
        this.accountSid = request.getParameter("AccountSid");
        this.apiVersion = request.getParameter("ApiVersion");
        this.callSid = request.getParameter("CallSid");
        this.callStatus = request.getParameter("CallStatus");
        this.callerName = request.getParameter("CallerName");
        this.conferenceAction = request.getParameter("ConferenceAction");
        this.conferenceName = request.getParameter("ConferenceName");
        this.conferenceParticipantCount = request.getParameter("ConferenceParticipantCout");
        this.conferenceSid = request.getParameter("ConferenceSid");
        this.deaf = request.getParameter("Deaf");
        this.digits = request.getParameter("Digits");
        this.direction = request.getParameter("Direction");
        this.from = request.getParameter("From");
        this.muted = request.getParameter("Muted");
        this.participantSid = request.getParameter("ParticipantSid");
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

    public String getConferenceAction() {
        return conferenceAction;
    }

    public void setConferenceAction(String conferenceAction) {
        this.conferenceAction = conferenceAction;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getConferenceParticipantCount() {
        return conferenceParticipantCount;
    }

    public void setConferenceParticipantCount(String conferenceParticipantCount) {
        this.conferenceParticipantCount = conferenceParticipantCount;
    }

    public String getConferenceSid() {
        return conferenceSid;
    }

    public void setConferenceSid(String conferenceSid) {
        this.conferenceSid = conferenceSid;
    }

    public String getDeaf() {
        return deaf;
    }

    public void setDeaf(String deaf) {
        this.deaf = deaf;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
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

    public String getMuted() {
        return muted;
    }

    public void setMuted(String muted) {
        this.muted = muted;
    }

    public String getParticipantSid() {
        return participantSid;
    }

    public void setParticipantSid(String participantSid) {
        this.participantSid = participantSid;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "ConferenceStatusModel{" + "accountSid=" + accountSid + ", apiVersion=" + apiVersion + ", callSid=" + callSid + ", callStatus=" + callStatus + ", callerName=" + callerName + ", conferenceAction=" + conferenceAction + ", conferenceName=" + conferenceName + ", conferenceParticipantCount=" + conferenceParticipantCount + ", conferenceSid=" + conferenceSid + ", deaf=" + deaf + ", digits=" + digits + ", direction=" + direction + ", from=" + from + ", muted=" + muted + ", participantSid=" + participantSid + ", to=" + to + '}';
    }

}
