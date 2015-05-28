package com.sds.icto.WoojuProject.domain;

public class MemberVo {
	private String mid;
	private String mpassword;
	
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVo(String mid, String mpassword) {
		super();
		this.mid = mid;
		this.mpassword = mpassword;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberVo [mid=");
		builder.append(mid);
		builder.append(", mpassword=");
		builder.append(mpassword);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
