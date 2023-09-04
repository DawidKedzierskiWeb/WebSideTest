package pages;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsPage extends BasePage{
    public void checkUrlCards(){
        assertThat(driver.getCurrentUrl()).isEqualTo(URL_CARDS);
    }

}
