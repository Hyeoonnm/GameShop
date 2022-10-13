package kr.ac.kopo.gameshop.dao;

import java.util.List;

import kr.ac.kopo.gameshop.model.Publisher;
import kr.ac.kopo.gameshop.pager.Pager;

public interface PublisherDao {

	int total(Pager pager);

	List<Publisher> list(Pager pager);

	void add(Publisher item);

	Publisher item(int id);

	void update(Publisher item);

	void delete(int id);

}
