package be.ucll.sandwichbar.web.controller;

import be.ucll.sandwichbar.domain.Sandwich;
import be.ucll.sandwichbar.domain.SandwichService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
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

//    @ResponseBody
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<Sandwich>>getAmountOfSandwiches(){
//        return ResponseEntity.ok(service.getSandwiches());
//    }

    private String toJson(List<Sandwich> aList) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(aList);

    }
}

