package kr.ac.kopo.gameshop.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.gameshop.dao.AttachDao;
import kr.ac.kopo.gameshop.dao.GameDao;
import kr.ac.kopo.gameshop.model.Attach;
import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.pager.Pager;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameDao dao;
	
	@Autowired
	AttachDao attachDao;

	@Override
	public List<Game> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	@Transactional
	public void add(Game item) {
		dao.add(item);
		
		for(Attach attach : item.getAttachs()) {
			attach.setGameId(item.getId());
	
			attachDao.add(attach);
		}
	}

	@Override
	@Transactional
	public void delete(int id, String memberId) {
		attachDao.deleteByGameId(id);

		dao.delete(id, memberId);
	}

	@Override
	public Game item(int id) {		
		return dao.item(id);
	}

	@Transactional
	@Override
	public void update(Game item) {
		dao.update(item);

		for(Attach attach : item.getAttachs()) {
			attach.setGameId(item.getId());

			attachDao.add(attach);
		}
	}

	@Override
	public void dummy(String memberId) {
		for(int count=1; count < 100; count++) {
			Game item = new Game();
			
			item.setTitle("게임명 " + count);			
			item.setPrice(count * 1000);
			item.setPubDate(new Date());
			item.setMemberId(memberId);
			
			dao.add(item);
		}
	}

	@Override
	public void init() {
		List<Game> list;
		
		Pager pager = new Pager();
		pager.setPerPage(9999);
		
		do {
			list = dao.list(pager);
						
			for(Game item : list)
				dao.delete(item.getId());
		} while(list.size() > 0);
	}

    @Override
    public boolean deleteAttach(int id) {
        if(attachDao.delete(id))
			return true;

		else
			return false;
    }
}
