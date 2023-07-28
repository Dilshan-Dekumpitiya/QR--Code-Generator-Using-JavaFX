package qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
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
        path =  "C:\\Users\\dilsh\\Downloads\\" + data + "-qr.png"; //C:\\Users\\dilsh\\Downloads\\ --> path you want to download qr png file
        BitMatrix encode = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 200, 200);
        Path path1 = Paths.get(path);
        MatrixToImageWriter.writeToPath(encode, path.substring(path.lastIndexOf('.') + 1), path1);
        new Alert(Alert.AlertType.INFORMATION,data+": QR Successfully Generated").show();
    }
}

