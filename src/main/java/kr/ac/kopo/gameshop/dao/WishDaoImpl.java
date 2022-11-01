package kr.ac.kopo.gameshop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class WishDaoImpl implements WishDao{

    @Autowired
    SqlSession sql;


    @Override
    public int add(int gameId, String memberId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("gameId", gameId);
        map.put("memberId", memberId);

        return sql.insert("game.wish_add", map);
    }

    @Override
    public int delete(int gameId, String memberId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("gameId", gameId);
        map.put("memberId", memberId);

        return sql.delete("game.wish_delete", map);
    }
}
