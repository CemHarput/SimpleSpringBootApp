package MaviDevStudyCase.demo.Info;


import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "")
public class InfoController {

    private final InfoService infoService;

    @Autowired
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }


    @GetMapping("/list")
    public String getInfos(Model model) {

        model.addAttribute("infos",infoService.getInfos());
        return "list";
    }

    @GetMapping("/form")
    public String SaveForm(Model model){
        Info info = new Info();
        model.addAttribute("info",info);
        return "form";
    }

    @PostMapping("/save")
    public String AddInfo(@ModelAttribute("info") Info info){



         infoService.addInfo(info);

         return "redirect:/list";

    }

    @GetMapping()
    public String getText(Model model){

        return "index";

    }

    @GetMapping("/login")
    public String Info_Login(){

        return "login";

    }
    @GetMapping("/register")
    public String Info_Register(){

        return "register";

    }








}



