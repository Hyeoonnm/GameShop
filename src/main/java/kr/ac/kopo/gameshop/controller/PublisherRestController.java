package kr.ac.kopo.gameshop.controller;

import kr.ac.kopo.gameshop.model.Publisher;
import kr.ac.kopo.gameshop.pager.Pager;
import kr.ac.kopo.gameshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherRestController {

    @Autowired
    PublisherService service;

    @GetMapping
    public List<Publisher> list(Pager pager) {
        return service.list(pager);
    }

    @PostMapping
    public Publisher add(@RequestBody Publisher item) {
        service.add(item);

        return item;
    }

    @PutMapping
    public Publisher update(@RequestBody Publisher item) {
        service.update(item);

        return item;
    }

    @DeleteMapping
    public Publisher delete(@RequestBody Publisher item) {
        service.delete(item.getId());

        return item;
    }
}
