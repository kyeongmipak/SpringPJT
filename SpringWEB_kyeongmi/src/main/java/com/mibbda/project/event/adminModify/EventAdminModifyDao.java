package com.mibbda.project.event.adminModify;

public interface EventAdminModifyDao {
	public void eventModify(String eTitle, String eContent, String eFilename, String startDate, String endDate, String eSeqno);
}
