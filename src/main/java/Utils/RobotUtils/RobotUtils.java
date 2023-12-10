package Utils.RobotUtils;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class RobotUtils {
    static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void robotSendPathToFileFromClipboard(String pathToFile) {
        File fileAvatarImg = new File("src");
        String pathToAvatarImg = fileAvatarImg.getAbsolutePath() + pathToFile;
        StringSelection filePathTransfer = new StringSelection(pathToAvatarImg);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathTransfer, null);
        robot.delay(4000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
    }
}