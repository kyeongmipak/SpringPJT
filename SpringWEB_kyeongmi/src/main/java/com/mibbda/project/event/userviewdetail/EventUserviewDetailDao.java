package com.mibbda.project.event.userviewdetail;

import java.util.ArrayList;


public interface EventUserviewDetailDao {
	public EventUserviewDetailDto eventViewDetail(String streSeqno);
	public int participant(String eSeqno, String userId);
	public ArrayList<EventUserviewDetailDto> WinnerList(String eSeqno);
	
}
