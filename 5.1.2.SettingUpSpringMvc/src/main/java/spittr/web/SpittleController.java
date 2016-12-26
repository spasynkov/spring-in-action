package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping("/add")
    public String addSpittle(Model model) {
        model.addAttribute(new Spittle());
        return "addSpittle";
    }

    @RequestMapping(method = GET)
    public String spittles(
            Model model,
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        model.addAttribute(spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    @RequestMapping(method = POST)
    public String saveSpittle(Model model,
                              @Valid Spittle spittle,
                              Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute(spittle);
            return "addSpittle";
        }
        spittleRepository.save(spittle);
        return "redirect:/spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = GET)
    public String spittle(
            Model model,
            @PathVariable long spittleId) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
