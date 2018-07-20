package com.jspstudy.dto;

import java.sql.Timestamp;

public class tDto {
	
	int tId;
	String tContent;
	int tComplete;
	Timestamp sDate;

	public tDto() {
	}
	
	public tDto(int tId, String tContent, int tComplete, Timestamp sDate) {
		this.tId = tId;
		this.tContent = tContent;
		this.tComplete = tComplete;
		this.sDate = sDate;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettContent() {
		return tContent;
	}

	public void settContent(String tContent) {
		this.tContent = tContent;
	}

	public int gettComplete() {
		return tComplete;
	}

	public void settComplete(int tComplete) {
		this.tComplete = tComplete;
	}

	public Timestamp getsDate() {
		return sDate;
	}

	public void setsDate(Timestamp sDate) {
		this.sDate = sDate;
	}
	
	
}
