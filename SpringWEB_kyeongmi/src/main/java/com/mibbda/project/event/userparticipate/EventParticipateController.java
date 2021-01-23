package com.mibbda.project.event.userparticipate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class EventParticipateController {
	@Autowired 
	private SqlSession sqlSession;
	
	@RequestMapping("participateInEvent")
	public String participateInEvent(HttpServletRequest request, Model model, HttpSession session) {
		session = request.getSession();
		
		//String userId = "wldms";
		
		String userId = (String)session.getAttribute("userId");
		String eSeqno = request.getParameter("eSeqno");
		System.out.println("seqno : " + eSeqno);
		
		EventParticipateDao dao = sqlSession.getMapper(EventParticipateDao.class);
		
		if(dao.paricipateResult(eSeqno, userId) == 0) {
			dao.participateInEvent(eSeqno, userId);
		}

		model.addAttribute("participateResult", dao.paricipateResult(eSeqno, userId));
		model.addAttribute("eSeqno", eSeqno);
		return "redirect:eventViewUserDetail";
	}
}
