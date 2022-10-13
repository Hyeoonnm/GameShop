
package kr.ac.kopo.gameshop.controller;

import kr.ac.kopo.gameshop.model.Attach;
import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.model.Member;
import kr.ac.kopo.gameshop.model.Publisher;
import kr.ac.kopo.gameshop.pager.Pager;
import kr.ac.kopo.gameshop.service.GameService;
import kr.ac.kopo.gameshop.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {
    final String path = "game/";
    final String uploadPath = "d://upload/";

    @Autowired
    GameService service;

    @Autowired
    PublisherService publisherService;

    @RequestMapping("/delete_attach/{id}")
    @ResponseBody
    public String deleteAttach(@PathVariable int id) {
        if (service.deleteAttach(id))
            return "OK";

        else
            return "FAIL";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Game item = service.item(id);

        model.addAttribute("item", item);

        return path + "detail";
    }

    @RequestMapping("/list")
    public String list(Model model, Pager pager) {
        List<Game> list = service.list(pager);

        model.addAttribute("list", list);

        return path + "list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Pager pager = new Pager();

        List<Publisher> list = publisherService.list(pager);

        model.addAttribute("list", list);

        return path + "add";
    }

    @PostMapping("/add")
    public String add(Game item, @SessionAttribute Member member) {
        item.setMemberId(member.getId());

        try {
            List<Attach> list = new ArrayList<Attach>(); // 이미지를 담을 list

            for (MultipartFile attach : item.getAttach()) {
                if (attach != null && !attach.isEmpty()) {
                    String filename = attach.getOriginalFilename();

                    attach.transferTo(new File(uploadPath + filename));

                    Attach attachItem = new Attach();
                    attachItem.setFilename(filename);

                    list.add(attachItem);
                }
            }

            item.setAttachs(list);

            service.add(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id, @SessionAttribute Member member) {
        service.delete(id, member.getId());

        return "redirect:../list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model, @SessionAttribute Member member) {
        Game item = service.item(id);

        if (member.getId().equals(item.getMemberId())) {
            model.addAttribute("item", item);

            Pager pager = new Pager();

            List<Publisher> list = publisherService.list(pager);

            model.addAttribute("list", list);

            return path + "update";
        } else
            return "redirect:../list";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, Game item, @SessionAttribute Member member) {
        item.setMemberId(member.getId());
        item.setId(id);

        service.update(item);

        return "redirect:../list";
    }

    @RequestMapping("/dummy")
    public String dummy(@SessionAttribute Member member) {
        service.dummy(member.getId());

        return "redirect:list";
    }

    @RequestMapping("/init")
    public String init() {
        service.init();

        return "redirect:list";
    }
}