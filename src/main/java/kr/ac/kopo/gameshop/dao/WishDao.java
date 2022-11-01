package kr.ac.kopo.gameshop.dao;

public interface WishDao {
    int add(int gameId, String memberId);

    int delete(int gameId, String memberId);
}
