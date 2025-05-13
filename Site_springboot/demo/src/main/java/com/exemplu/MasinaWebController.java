package com.exemplu;

import com.exemplu.entity.Criptare;
import com.exemplu.entity.Masina;
import com.exemplu.entity.Utilizator;
import com.exemplu.repository.MasinaRepository;
import com.exemplu.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MasinaWebController {

    @Autowired
    MasinaRepository repository;
    @Autowired
    private UtilizatorRepository utilizatorRepository;

    @GetMapping("/masini")
    public String getListaMasini(Model model) {
        String s = "Lista masinilor preluare prin repository";
        model.addAttribute("str", s);
        model.addAttribute("lista", repository.findAll());
        return "masini";

    }

    @GetMapping("/formular-masina")
    public String afiseazaFormular(Model model) {
        model.addAttribute("masina", new Masina());
        return "formular-masina";//fisierul html cu formularul
    }

    @PostMapping("/salveaza-masina")
    public String salveazaMasina(@ModelAttribute Masina masina) {
        repository.save(masina);
        return "redirect:/masini";//dupa salvare ne intoarcem la pagina care afiseaza tabelul
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Controller
    public class LoginController {

        @PostMapping("/login")
        public String login(@RequestParam String utilizator,
                            @RequestParam String parola,
                            @RequestParam String action,
                            Model model) {
            if(action.equals("login")) {
                // Aici verifici în baza de date (ex: cu UserRepository)
                Optional<Utilizator> optionalUtilizator = utilizatorRepository.findByUtilizator(utilizator);

                Utilizator utilizator1 = null;
                if (optionalUtilizator.isPresent()) {
                    utilizator1 = optionalUtilizator.get();
                    String parolaCriptatapeloc =Criptare.encryptPassword(parola);//parolaCriptatapeloc e parola criptata din textbox

                    if (utilizator1.getParola().equals(parolaCriptatapeloc))
                        return "redirect:/masini";
                    else {
                        model.addAttribute("error", "Parola incorectă");
                        return "login"; // Pagină de login cu mesaj de eroare
                    }

                } else {
                    model.addAttribute("error", "Utilizatorul nu există");
                    return "login"; // Pagină de login cu mesaj de eroare
                }
            }
            else if(action.equals("register")) {
                if (utilizatorRepository.findByUtilizator(utilizator).isPresent()) {
                    model.addAttribute("error", "Numele de utilizator există deja.");
                    return "login";  // redirecționează înapoi la formularul de înregistrare
                }
                Utilizator user=new Utilizator();
                String parolaCriptata= Criptare.encryptPassword(parola);//preiau parola din textbox si o criptez inainte sa inserez in bd
                user.setUtilizator(utilizator);
                user.setParola(parolaCriptata);
                utilizatorRepository.save(user);
                model.addAttribute("success", "V-ati inregistrat cu succes");
                return "redirect:/login";
            }
            return "login";
        }
    }
}
