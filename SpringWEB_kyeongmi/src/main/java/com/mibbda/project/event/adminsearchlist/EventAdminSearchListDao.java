package com.mibbda.project.event.adminsearchlist;

import java.util.ArrayList;

public interface EventAdminSearchListDao {
	
	public ArrayList<EventAdminSearchListDto> searchQuery(String query, String content, int page, int pageSize);
	public int getBoardCount(String query, String content);
	
}
