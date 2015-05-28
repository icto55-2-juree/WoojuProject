package com.sds.icto.WoojuProject.domain;

public class PollVo {
	private int pno;
	private String mid;
	private int bno;
	private int ppro;
	private int pcon;
	public PollVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PollVo(int pno, String mid, int bno, int ppro, int pcon) {
		super();
		this.pno = pno;
		this.mid = mid;
		this.bno = bno;
		this.ppro = ppro;
		this.pcon = pcon;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
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
	public int getPpro() {
		return ppro;
	}
	public void setPpro(int ppro) {
		this.ppro = ppro;
	}
	public int getPcon() {
		return pcon;
	}
	public void setPcon(int pcon) {
		this.pcon = pcon;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PollVo [pno=");
		builder.append(pno);
		builder.append(", mid=");
		builder.append(mid);
		builder.append(", bno=");
		builder.append(bno);
		builder.append(", ppro=");
		builder.append(ppro);
		builder.append(", pcon=");
		builder.append(pcon);
		builder.append("]");
		return builder.toString();
	}
	
	
}
