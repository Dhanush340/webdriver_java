package alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTest {

    @Test
    public void testFileUpload(){

        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\dhanu\\Pictures\\Capture.jpg");

        assertEquals(uploadPage.getUploadedFiles(), "Capture.jpg", "Uploaded files incorrect");
    }
}