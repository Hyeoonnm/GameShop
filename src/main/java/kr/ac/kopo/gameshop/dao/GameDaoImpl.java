package kr.ac.kopo.gameshop.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.pager.Pager;

@Repository
public class GameDaoImpl implements GameDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Game> list(Pager pager) {		
		return sql.selectList("game.list", pager);
	}

	@Override
	public void add(Game item) {
		sql.insert("game.add", item);
	}

	@Override
	public void delete(int id) {
		sql.delete("game.delete", id);		
	}

	@Override
	public Game item(int id) {		
		return sql.selectOne("game.item", id);
	}

	@Override
	public void update(Game item) {
		sql.update("game.update", item);
	}

	@Override
	public int total(Pager pager) {		
		return sql.selectOne("game.total", pager);
	}

	@Override
	public void delete(int id, String memberId) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("id", id);
		map.put("memberId", memberId);
		
		sql.delete("game.delete_member", map);
	}

}
