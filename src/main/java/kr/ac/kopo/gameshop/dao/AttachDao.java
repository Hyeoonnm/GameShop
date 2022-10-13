package kr.ac.kopo.gameshop.dao;

import kr.ac.kopo.gameshop.model.Attach;

public interface AttachDao {

    void add(Attach attach);

    void deleteByGameId(int id);

    boolean delete(int id);
}
