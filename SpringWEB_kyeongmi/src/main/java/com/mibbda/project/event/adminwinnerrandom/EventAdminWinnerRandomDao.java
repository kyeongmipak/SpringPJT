package com.mibbda.project.event.adminwinnerrandom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class EventAdminWinnerRandomDao {
	DataSource dataSource;
	
	public EventAdminWinnerRandomDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/team_five");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<EventAdminWinnerRandomDto> AllParticipant(String eSeqno) {
		ArrayList<EventAdminWinnerRandomDto> dtos = new ArrayList<EventAdminWinnerRandomDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		StringBuffer sql=new StringBuffer();
		sql.append("select * from participate where event_eSeqno = ?");
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println("여기 오나요?");
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, eSeqno);
			System.out.println("여기 오나요?" +eSeqno);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				EventAdminWinnerRandomDto dto = new EventAdminWinnerRandomDto();
				dto.setUser_userId(resultSet.getString("user_userId"));
				
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public int getEventAllCount(String eSeqno) {
		String sql = "select count(*) from participate where event_eSeqno = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		int NoticeCount=0;
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql); // '?'바인드를 사용해서 sql문을 효과 적으로
			preparedStatement.setString(1, eSeqno);
			resultSet = preparedStatement.executeQuery();

			
			if (resultSet.next()) {
				NoticeCount=resultSet.getInt(1); // 전체 글 개수
			} // if

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return NoticeCount;
	}
	
	public void insertWinner(String eSeqno, String[] winnerName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		for(int i = 0 ; i<10;i++) {
			try {
					connection = dataSource.getConnection();
					String query = "update participate set win = ? where user_userId = ? and event_eSeqno = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, "O");
					preparedStatement.setString(2, winnerName[i]);
					preparedStatement.setString(3, eSeqno);
					preparedStatement.executeUpdate();
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	
	public ArrayList<EventAdminWinnerRandomDto> WinnerList(String eSeqno) {
		ArrayList<EventAdminWinnerRandomDto> dtos = new ArrayList<EventAdminWinnerRandomDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		StringBuffer sql=new StringBuffer();
		sql.append("select * from participate where event_eSeqno = ? and win = 'O'");
		SimpleDateFormat sdf = new SimpleDateFormat();
		try {
			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, eSeqno);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				EventAdminWinnerRandomDto dto = new EventAdminWinnerRandomDto();
				dto.setUser_userId(resultSet.getString("user_userId"));
				
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
}
