package com.mibbda.project.event.adminlist;

import java.util.ArrayList;

public interface EventAdminListDao {
	
	public ArrayList<EventAdminListDto> listDao(int page, int pageSize);
	public int getBoardCount();
	
}
