package com.mibbda.project.event.adminModify;

public class EventAdminModifyDto {
	// field
	int eSeqno;
	String eTitle;
	String eContent;
	String eFilename;
	String startDate;
	String endDate;
	
	public EventAdminModifyDto() {
		// TODO Auto-generated constructor stub
	}

	public EventAdminModifyDto(int eSeqno, String eTitle, String eContent, String eFilename, String startDate,
			String endDate) {
		super();
		this.eSeqno = eSeqno;
		this.eTitle = eTitle;
		this.eContent = eContent;
		this.eFilename = eFilename;
		this.startDate = startDate;
		this.endDate = endDate;
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
	
	
}
