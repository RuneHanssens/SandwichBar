package be.ucll.sandwichbar.web.controller;

import be.ucll.sandwichbar.domain.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {
    private SandwichService service;

    public AjaxController(@Autowired SandwichService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value="/sandwich")
    public String getAmountOfSandwiches(){
        try {
            String result = toJson(service.getSandwiches());
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value="/temp")
    public String getTemp(){
        try {
            TemperatureUpdater test = new TemperatureUpdater(service.getTemp());
            String result = toJson(test);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value="/amount")
    public String getAmount(){
        try {
            AmountUpdater test = new AmountUpdater("broodje1", service.getSandwich("broodje1").getAmount());
            String result = toJson(test);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value="/barGraph")
    public String getBarGraph(){
        try {
            List<Sandwich> list = service.getSandwiches();
            String result = toJson(list);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value="/sandwich")
    public void updateAmount(@RequestBody SandwichUpdater data){
        Sandwich s = service.getSandwich(data.getName());
        s.setAmount(data.getAmount());
        service.updateSandwich(s);

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value="/temp")
    public void updateTemp(@RequestBody TemperatureUpdater data){
        service.setTemp(data.getTemp());
    }

    private String toJson(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value="/amount")
    public void updateAmount(@RequestBody AmountUpdater data){
        System.out.println(data.getAmount());
        service.updateAmount(data.getName(),data.getAmount());
    }

}

