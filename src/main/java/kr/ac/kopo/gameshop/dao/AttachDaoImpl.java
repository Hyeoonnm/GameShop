package kr.ac.kopo.gameshop.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.gameshop.model.Attach;

import java.util.HashMap;

@Repository
public class AttachDaoImpl implements AttachDao {

    @Autowired
    SqlSession sql;

    @Override
    public void add(Attach attach) {
        sql.insert("attach.add", attach);

    }

    @Override
    public void deleteByGameId(int id) {

        sql.delete("attach.delete_gameid", id);
    }

    @Override
    public boolean delete(int id) {
        if (sql.delete("attach.delete", id) == 1)
            return true;

        else
            return false;
    }

}
