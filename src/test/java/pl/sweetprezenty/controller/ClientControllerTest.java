package pl.sweetprezenty.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.sweetprezenty.v1.controller.ClientController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
@SpringBootTest
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenInvalidEmail_whenValidateEmail_thenReturnBadRequest() throws Exception {
        String invalidEmail = "invalid_email";

        mockMvc.perform(post("/order/create")
                        .param("email", invalidEmail))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenValidEmail_whenValidateEmail_thenReturnOk() throws Exception {
        String validEmail = "valid_email@example.com";

        mockMvc.perform(post("/order/create")
                        .param("email", validEmail))
                .andExpect(status().isOk());
    }
}
