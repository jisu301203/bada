package com.ezen.bada.inquire;

import java.util.ArrayList;

import com.ezen.bada.member.MemberDTO;

public interface Service {

	ArrayList<MemberDTO> inquire_input(String loginid);

	void inquire_save(String title, String category, String name, String id, String pic1, String pic2, String pic3,
			String pic4, String pic5, String content, String secret, String secret_pw);

}