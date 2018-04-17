package be.ucll.sandwichbar.web.controller;

import be.ucll.sandwichbar.domain.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ComponentScan
@RequestMapping("/sandwich")
public class SandwichController {
    private SandwichService service;

    public SandwichController(@Autowired SandwichService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getActivities(){
        System.out.println(service.getSandwiches());
        return new ModelAndView("sandwichOverview", "sandwiches", service.getSandwiches());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveData(String test){
        System.out.println(test);
    }

}
