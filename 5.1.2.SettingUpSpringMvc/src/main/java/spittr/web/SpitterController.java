package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import spittr.Spitter;
import spittr.data.SpitterRepository;
import spittr.exceptions.SpitterNotFoundException;

import javax.servlet.http.Part;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            Model model,
            @RequestPart("profilePicture") Part profilePicture,
            @Valid Spitter spitter,
            Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute(spitter);
            return "registerForm";
        }

        try {
            if (profilePicture.getInputStream().available() > 0) {
                profilePicture.write(
                        System.getProperty("java.io.tmpdir")
                        + File.separator + "spittr" + File.separator + "data" + File.separator
                        + profilePicture.getSubmittedFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping("/{username}")
    public String showSpitter(
            Model model,
            @PathVariable String username) {

        Spitter spitter = spitterRepository.findByUsername(username);
        if (spitter == null) throw new SpitterNotFoundException(username);
        model.addAttribute(spitter);
        return "profile";
    }
}