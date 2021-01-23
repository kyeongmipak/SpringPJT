package com.mibbda.project.event.userparticipate;

public interface EventParticipateDao {
	public void participateInEvent(String eSeqno, String userId);
	public int paricipateResult(String eSeqno, String userId);
}
