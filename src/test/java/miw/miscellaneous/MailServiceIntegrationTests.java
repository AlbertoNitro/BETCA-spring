package miw.miscellaneous;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import miw.miscellaneous.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceIntegrationTests {

    @Autowired
    private MailService mailService;

    // @Test
    public void testSendMail() {
        mailService.from("miw.betca").to("miwupm@gmail.com").subject("Saludos").msg("Mail Service test").send();
    }

    // @Test
    public void testEmailPassword() {
        System.out.println(">>>>>>>" + System.getenv("EMAIL_PASSWORD"));
    }
}
