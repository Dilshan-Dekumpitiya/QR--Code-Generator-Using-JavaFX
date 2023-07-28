package qr;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QRGenerator {
    private String data;
    private String path;
    public void setData(String data) {
        this.data = data;
    }
    public String getPath() {
        return path;
    }

    public void getGenerator() throws IOException, WriterException {
        path = "C:\\Users\\dilsh\\Downloads" + data + ".png"; //path you want to download ong file
        BitMatrix encode = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 200, 200);
        Path path1 = Paths.get(path);
        MatrixToImageWriter.writeToPath(encode, path.substring(path.lastIndexOf('.') + 1), path1);
        new Alert(Alert.AlertType.INFORMATION,data+": QR Successfully Generated").show();
    }
}
