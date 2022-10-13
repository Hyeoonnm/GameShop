package kr.ac.kopo.gameshop.service;

import java.util.List;

import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.pager.Pager;

public interface GameService {

	List<Game> list(Pager pager);

	void add(Game item);

	void delete(int id, String memberId);

	Game item(int id);

	void update(Game item);

	void dummy(String memberId);

	void init();

    boolean deleteAttach(int id);
}
