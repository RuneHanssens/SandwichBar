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
        //RANDOM VALUES
        for (Sandwich s:service.getSandwiches()) {
            s.setRandomAmount();
            service.updateSandwich(s);
        }
        //END


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
    @RequestMapping(method = RequestMethod.GET, value="/barGraph")
    public String getBarGraph(){
        try {
            ArrayList<SandwichGraphData> list = service.getSandwichGraphData();
            String result = toJson(list);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value="/sandwich")
    public String updateAmount(@RequestBody SandwichUpdater data){
        Sandwich s = service.getSandwich(data.getName());
        s.setAmount(data.getAmount());
        service.updateSandwich(s);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value="/temp")
    public String updateTemp(@RequestBody TemperatureUpdater data){
        System.out.println(data.getTemp());
        service.setTemp(data.getTemp());
        return null;
    }

    private String toJson(Object o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }


}

