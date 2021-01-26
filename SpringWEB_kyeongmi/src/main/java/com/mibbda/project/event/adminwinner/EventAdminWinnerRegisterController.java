package com.mibbda.project.event.adminwinner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mibbda.project.event.userviewdetail.EventUserviewDetailDao;

@Controller
public class EventAdminWinnerRegisterController {
	@Autowired 
	private SqlSession sqlSession;
	
	
	/// 당첨자 입력 상세페이지
	@RequestMapping("insertWinEventViewdetail")
	public String insertWinEventView(HttpServletRequest request, Model model, HttpSession session) {
		
	
		EventUserviewDetailDao dao = sqlSession.getMapper(EventUserviewDetailDao.class);
		
		// 당첨 명단 출력
		model.addAttribute("eventResultView", dao.WinnerList(request.getParameter("eSeqno")));
		model.addAttribute("eSeqno", request.getParameter("eSeqno"));
		
		return "event_admin/insertWinEventView";
	}
}
