package be.ucll.sandwichbar.web.controller;

import be.ucll.sandwichbar.domain.Sandwich;
import be.ucll.sandwichbar.domain.SandwichService;
import be.ucll.sandwichbar.domain.SandwichUpdater;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/ajax")
public class AjaxController {
    private SandwichService service;

    public AjaxController(@Autowired SandwichService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
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
    @RequestMapping(method = RequestMethod.POST, value="/sandwich")
    public String updateAmount(@RequestBody SandwichUpdater data){
        Sandwich s = service.getSandwich(data.getName());
        s.setAmount(data.getAmount());
        service.updateSandwich(s);
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value="/temp")
    public String updateTemp(@RequestBody String data){
        //TODO
        return null;
    }

    private String toJson(List<Sandwich> aList) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(aList);
    }
}

