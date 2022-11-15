package email_request;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class Icon {
    ImageIcon icon;

    /**
     * Returns class variable icon
     * @return
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Creates an ImageIcon by reading image from the provided filepath
     * @param iconFilePath
     */
    public void createIcon(String iconFilePath) {
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(iconFilePath)));
        icon.getImage();
    }

}
