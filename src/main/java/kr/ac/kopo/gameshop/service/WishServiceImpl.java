package kr.ac.kopo.gameshop.service;

import kr.ac.kopo.gameshop.dao.WishDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishServiceImpl implements WishService{

    @Autowired
    WishDao dao;

    @Override
    public boolean add(int gameId, String memberId) {
        if(dao.add(gameId, memberId) > 0)
            return true;

        return false;
    }

    @Override
    public boolean delete(int gameId, String memberId) {
        if(dao.delete(gameId, memberId) > 0)
            return true;

        return false;
    }
}
