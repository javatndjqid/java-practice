package com.ubuntu.data;

public class Member {
	private String m_user_name;
	private String m_user_id;
	private String m_user_pw;
	private String m_user_role;
	public String getM_user_name() {
		return m_user_name;
	}
	public void setM_user_name(String m_user_name) {
		this.m_user_name = m_user_name;
	}
	public String getM_user_id() {
		return m_user_id;
	}
	public void setM_user_id(String m_user_id) {
		this.m_user_id = m_user_id;
	}
	public String getM_user_pw() {
		return m_user_pw;
	}
	public void setM_user_pw(String m_user_pw) {
		this.m_user_pw = m_user_pw;
	}
	public String getM_user_role() {
		return m_user_role;
	}
	public void setM_user_role(String m_user_role) {
		this.m_user_role = m_user_role;
	}
	@Override
	public String toString() {
		return "Member [m_user_name=" + m_user_name + ", m_user_id=" + m_user_id
				+ ", m_user_pw=" + m_user_pw + ", m_user_role=" + m_user_role
				+ "]";
	}	
	
}
