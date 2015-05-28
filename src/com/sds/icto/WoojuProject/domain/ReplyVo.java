package com.sds.icto.WoojuProject.domain;

import java.sql.Date;

public class ReplyVo {
	private int rno;
	private String mid;
	private int bno;
	private Date rdate;
	private String rcontent;
	public ReplyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReplyVo(int rno, String mid, int bno, Date rdate, String rcontent) {
		super();
		this.rno = rno;
		this.mid = mid;
		this.bno = bno;
		this.rdate = rdate;
		this.rcontent = rcontent;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyVo [rno=");
		builder.append(rno);
		builder.append(", mid=");
		builder.append(mid);
		builder.append(", bno=");
		builder.append(bno);
		builder.append(", rdate=");
		builder.append(rdate);
		builder.append(", rcontent=");
		builder.append(rcontent);
		builder.append("]");
		return builder.toString();
	}
	
	
}
