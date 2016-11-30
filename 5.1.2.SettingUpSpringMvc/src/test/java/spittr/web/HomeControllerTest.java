package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class HomeControllerTest {

    @Test
    public void simpleTestHomePage() {
        HomeController controller = new HomeController();
        assertEquals("home", controller.home());
    }

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();

        // setting up MockMvc
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))                   // performing GET
                .andExpect(view().name("home"));    // expect home view

        mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
    }
}
