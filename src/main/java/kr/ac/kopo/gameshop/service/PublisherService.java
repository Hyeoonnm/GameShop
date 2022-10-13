package kr.ac.kopo.gameshop.service;

import java.util.List;

import kr.ac.kopo.gameshop.model.Publisher;
import kr.ac.kopo.gameshop.pager.Pager;

public interface PublisherService {

	List<Publisher> list(Pager pager);

	void add(Publisher item);

	Publisher item(int id);

	void update(Publisher item);

	void delete(int id);

}
