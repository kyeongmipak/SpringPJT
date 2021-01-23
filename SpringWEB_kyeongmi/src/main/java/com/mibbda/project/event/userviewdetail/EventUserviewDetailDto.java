package com.mibbda.project.event.userviewdetail;

public class EventUserviewDetailDto {
	// field
	int eSeqno;
	String eTitle;
	String eContent;
	String eFilename;
	String startDate;
	String endDate;
	
	String user_userId;
	String event_eSeqno;
	String win;
	int result;
	
	public EventUserviewDetailDto() {
		// TODO Auto-generated constructor stub
	}
	
	// event 정보
	public EventUserviewDetailDto(int eSeqno, String eTitle, String eContent, String eFilename, String startDate,
			String endDate) {
		super();
		this.eSeqno = eSeqno;
		this.eTitle = eTitle;
		this.eContent = eContent;
		this.eFilename = eFilename;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	// event 참여
	public EventUserviewDetailDto(String user_userId, String event_eSeqno, String win, int result) {
		super();
		this.user_userId = user_userId;
		this.event_eSeqno = event_eSeqno;
		this.win = win;
		this.result = result;
	}


	public int geteSeqno() {
		return eSeqno;
	}


	public void seteSeqno(int eSeqno) {
		this.eSeqno = eSeqno;
	}


	public String geteTitle() {
		return eTitle;
	}


	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}


	public String geteContent() {
		return eContent;
	}


	public void seteContent(String eContent) {
		this.eContent = eContent;
	}


	public String geteFilename() {
		return eFilename;
	}


	public void seteFilename(String eFilename) {
		this.eFilename = eFilename;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
