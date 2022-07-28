package hover;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTest extends BaseTest{

    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(3);
        assertTrue(caption.isCaptionDisplayed(), "Caption is not Displayed");
        assertEquals(caption.getTitle(), "name: user3", "Caption title incorrect");
        assertEquals(caption.getLinkText(),"View profile","Caption link text is incorrect");
        assertTrue(caption.getLink().endsWith("/users/3"),"Link Incorrect");
    }

}
