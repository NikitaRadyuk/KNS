package diploma.progis.progis.services;

import com.aspose.imaging.Image;
import com.aspose.imaging.imageoptions.DxfOptions;
import com.aspose.imaging.imageoptions.SvgRasterizationOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class DXFSaver {
    public byte[] toDXF(byte[] bytes){
        try (Image image = Image.load(new ByteArrayInputStream(bytes))) {
            DxfOptions exportOptions = new DxfOptions();
            SvgRasterizationOptions vectorOptions = new SvgRasterizationOptions();
            vectorOptions.setPageWidth(image.getWidth());
            vectorOptions.setPageHeight(image.getHeight());
            exportOptions.setVectorRasterizationOptions(vectorOptions);

            // Save svg to dxf
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            image.save(outputStream, exportOptions);
            return outputStream.toByteArray();
        }
    }
}
