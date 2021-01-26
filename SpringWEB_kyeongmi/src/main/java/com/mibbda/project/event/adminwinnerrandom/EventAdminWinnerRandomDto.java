package com.mibbda.project.event.adminwinnerrandom;

public class EventAdminWinnerRandomDto {
	String user_userId;
	String event_eSeqno;
	String win;
	int result;
	
	
	public EventAdminWinnerRandomDto() {
		// TODO Auto-generated constructor stub
	}


	public EventAdminWinnerRandomDto(String user_userId, String event_eSeqno, String win, int result) {
		super();
		this.user_userId = user_userId;
		this.event_eSeqno = event_eSeqno;
		this.win = win;
		this.result = result;
	}


	public String getUser_userId() {
		return user_userId;
	}


	public void setUser_userId(String user_userId) {
		this.user_userId = user_userId;
	}


	public String getEvent_eSeqno() {
		return event_eSeqno;
	}


	public void setEvent_eSeqno(String event_eSeqno) {
		this.event_eSeqno = event_eSeqno;
	}


	public String getWin() {
		return win;
	}


	public void setWin(String win) {
		this.win = win;
	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}
	
}
