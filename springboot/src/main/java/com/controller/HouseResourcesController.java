package com.controller;

import com.model.House;
import com.service.HouseResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "house")
public class HouseResourcesController {

    @Autowired
    private HouseResourcesService houseResourcesService;

    @RequestMapping(value = "/toHouseResorces")
    public ModelAndView toHouseResorces() {
        ModelAndView mv = new ModelAndView("house");
        List<House> houses = houseResourcesService.findAll();
        mv.addObject("houses", houses);
        mv.addObject("totalCount", houses.size());
        if (houses.size() % 10 == 0) {
            mv.addObject("totalPages", houses.size() / 10);
        } else {
            mv.addObject("totalPages", (houses.size() / 10) + 1);
        }
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public List<House> page(Integer pageSize) {
        List<House> houses = houseResourcesService.findHouse((pageSize - 1) * 10, 10);
        return houses;
    }
}
