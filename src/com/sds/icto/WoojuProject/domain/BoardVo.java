package com.sds.icto.WoojuProject.domain;

import java.util.Date;

public class BoardVo {
	
	private int bno;
	private String mid;
	private String btitle;
	private String bdate;
	private String bstatus;
	private int bview_cnt;
	private String bimage;
	private String bcontent;
	private int rno_cnt;
	
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardVo(int bno, String mid, String btitle, String bdate,
			String bstatus, int bview_cnt, String bimage, String bcontent, int rno_cnt) {
		super();
		this.bno = bno;
		this.mid = mid;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bstatus = bstatus;
		this.bview_cnt = bview_cnt;
		this.bimage = bimage;
		this.bcontent = bcontent;
		this.rno_cnt = rno_cnt;
		
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBstatus() {
		return bstatus;
	}
	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}
	public int getBview_cnt() {
		return bview_cnt;
	}
	public void setBview_cnt(int bview_cnt) {
		this.bview_cnt = bview_cnt;
	}
	public String getBimage() {
		return bimage;
	}
	public void setBimage(String bimage) {
		this.bimage = bimage;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getRno_cnt() {
		return rno_cnt;
	}
	public void setRno_cnt(int rno_cnt) {
		this.rno_cnt = rno_cnt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardVo [bno=");
		builder.append(bno);
		builder.append(", mid=");
		builder.append(mid);
		builder.append(", btitle=");
		builder.append(btitle);
		builder.append(", bdate=");
		builder.append(bdate);
		builder.append(", bstatus=");
		builder.append(bstatus);
		builder.append(", bview_cnt=");
		builder.append(bview_cnt);
		builder.append(", bimage=");
		builder.append(bimage);
		builder.append(", bcontent=");
		builder.append(bcontent);
		builder.append(", rno_cnt=");
		builder.append(rno_cnt);	
		builder.append("]");
		return builder.toString();
	}
		
}
