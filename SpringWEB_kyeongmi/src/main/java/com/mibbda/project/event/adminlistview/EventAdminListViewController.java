package com.mibbda.project.event.adminlistview;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventAdminListViewController {
	@Autowired 
	private SqlSession sqlSession;
	
	
	// 관리자화면_이벤트 상세페이지
	@RequestMapping("eventViewAdminDetail")
	public String eventViewAdmin(HttpServletRequest request, Model model) {
	
		EventAdminListViewDao dao = sqlSession.getMapper(EventAdminListViewDao.class);
		System.out.println("eseqno : " + request.getParameter("eSeqno"));
		model.addAttribute("eventListView", dao.eventView((String)request.getParameter("eSeqno")));

		return "event_admin/eventViewAdmin";
	}

	
}
