package com.mibbda.project.event.admindelete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mibbda.project.event.adminlist.EventAdminListDao;

@Controller
public class EventAdminDeleteController {
	@Autowired 
	private SqlSession sqlSession;
	
	
	// 이벤트 삭제
	@RequestMapping("deleteEvent")
	public String deleteEvent(HttpServletRequest request, Model model, HttpSession session) {

		EventAdminDeleteDao dao = sqlSession.getMapper(EventAdminDeleteDao.class);
		dao.eventDelete((String)request.getParameter("eSeqno"));
		
		return "redirect:eventListAdmin";
	}
}
