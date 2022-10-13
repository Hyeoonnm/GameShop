package kr.ac.kopo.gameshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.gameshop.dao.PublisherDao;
import kr.ac.kopo.gameshop.model.Publisher;
import kr.ac.kopo.gameshop.pager.Pager;

@Service
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	PublisherDao dao;

	@Override
	public List<Publisher> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Publisher item) {
		dao.add(item);
	}

	@Override
	public Publisher item(int id) {		
		return dao.item(id);
	}

	@Override
	public void update(Publisher item) {
		dao.update(item);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

}
