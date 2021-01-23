package com.mibbda.project.event.userviewdetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EventUserviewDetailController {

	@Autowired 
	private SqlSession sqlSession;
	
	@RequestMapping("eventViewUserDetail")
	public String eventList(HttpServletRequest request, Model model, HttpSession session) {
	
		////////////////
		String userId = (String) session.getAttribute("userId");
		String eSeqno = request.getParameter("eSeqno");
		////////////////
		System.out.println("eseqno : " + request.getParameter("eSeqno"));
		
		EventUserviewDetailDao dao = sqlSession.getMapper(EventUserviewDetailDao.class);
		model.addAttribute("eventList", dao.eventViewDetail(eSeqno));
		System.out.println("eseqno : " + dao.eventViewDetail(eSeqno).geteFilename());
		
		
		model.addAttribute("participant", dao.participant(request.getParameter("eSeqno"), userId));
		System.out.println("eseqno : " + dao.participant(request.getParameter("eSeqno"), userId));

		
		model.addAttribute("eventResultView", dao.WinnerList(request.getParameter("eSeqno")));

		
		return "event_user/eventViewUser";
		
	}
	
	
}
