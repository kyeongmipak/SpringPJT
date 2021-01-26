package com.mibbda.project.event.adminwinnerrandom;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public class RegisterRandomCommand implements RandomCommand {


	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String eSeqno = request.getParameter("eSeqno");
		System.out.println("eSeqno : " + eSeqno);
		
		EventAdminWinnerRandomDao dao = new EventAdminWinnerRandomDao();
		
		if(dao.getEventAllCount(eSeqno) != 0) {
		
			String[] winnerName = new String[10];
			for(int i =0 ; i<10;i++) {
				winnerName[i]=null;
			}
			
			// 참여 인원 명단
			ArrayList<EventAdminWinnerRandomDto> lists = new ArrayList<EventAdminWinnerRandomDto>();
			lists = dao.AllParticipant(eSeqno);
			
			Random random = new Random();
			int[] randomNumber = new int [10];
			int participant = dao.getEventAllCount(eSeqno);
			System.out.println("범위 값 : " + participant);
			
			for(int i = 0 ; i<10 ; i++) {								// 범위 받아오기
				randomNumber[i] = random.nextInt(participant);
				
				for(int l =0 ;l<i;l++) {
					if(randomNumber[i] == randomNumber[l]) {
						i--;
					}
				}
			}
			
			System.out.println("범위 값 : " + participant);
			for(int i=0; i<10;i++) {
				
				winnerName[i]=lists.get(randomNumber[i]).getUser_userId();
				System.out.println("당첨 : " + winnerName[i]);
			}
			
			dao.insertWinner(eSeqno, winnerName);
		} else {
			
			model.addAttribute("result", 0);
		}
		
	}

}
