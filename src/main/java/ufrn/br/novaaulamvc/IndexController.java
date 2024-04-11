package ufrn.br.novaaulamvc;


import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index.html"}, method = RequestMethod.GET)
    public String getIndexPage(Model model){

        List<Pessoa> nomes = new ArrayList<>();
        nomes.add(new Pessoa("Pessoa 1", 30));
        nomes.add(new Pessoa("Pessoa 2", 20));
        nomes.add(new Pessoa("Pessoa 3", 40));


        String nome = "Taniro";

        model.addAttribute("objeto", nome);
        model.addAttribute("pessoas", nomes);

        return "index";
    }


    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editarPage(@PathVariable Integer id, Model model){

        model.addAttribute("size", id);

        return "editar";
    }

    @GetMapping("/cadastrar")
    public String getCadastroPage(Model model){

        Pessoa p = new Pessoa("pessoa", 20);
        model.addAttribute("p", p);
        return "cadastrar";
    }
    @PostMapping("/salvar")
    public String doSalvar(@ModelAttribute Pessoa p){

        System.out.println(p.toString());
        return "redirect:/";
    }

}
