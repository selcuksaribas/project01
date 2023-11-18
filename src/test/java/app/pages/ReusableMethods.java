package app.pages;
import app.utilities.Driver;
import app.utilities.WaitUtils;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
public class ReusableMethods {
    public ReusableMethods(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //File Upload Robot Class
    public static void uploadFile(String pathOfTheFile) {
        try {
            WaitUtils.waitFor(3);
            StringSelection stringSelection = new StringSelection(pathOfTheFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        } catch (Exception ignored) {
        }
    }

}