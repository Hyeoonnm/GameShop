package kr.ac.kopo.gameshop.service;

import kr.ac.kopo.gameshop.model.Member;

public interface MemberService {

	boolean login(Member member);

	void signup(Member item);

	boolean checkId(String id);

}
