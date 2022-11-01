package kr.ac.kopo.gameshop.service;

public interface WishService {
    boolean add(int gameId, String memberId);

    boolean delete(int gameId, String memberId);
}
