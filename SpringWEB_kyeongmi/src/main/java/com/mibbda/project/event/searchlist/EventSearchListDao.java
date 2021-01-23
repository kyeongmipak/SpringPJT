package com.mibbda.project.event.searchlist;

import java.util.ArrayList;

public interface EventSearchListDao {
	
	public ArrayList<EventSearchListDto> searchQuery(String query, String content, int page, int pageSize);
	public int getBoardCount(String query, String content);
}
