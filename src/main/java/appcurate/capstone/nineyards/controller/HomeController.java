package appcurate.capstone.nineyards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        model.addAttribute("name", "This is Home Page");
        return "/demo/view";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    @ResponseBody
    public String getErrorPage() {
        return "System error";
    }

}
