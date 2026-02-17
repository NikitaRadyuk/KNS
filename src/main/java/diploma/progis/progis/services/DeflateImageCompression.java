package diploma.progis.progis.services;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class DeflateImageCompression {

        public static byte[] compressImage(byte[] imageBytes) throws IOException {
            Deflater deflater = new Deflater();
            deflater.setInput(imageBytes);
            deflater.finish();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageBytes.length);

            byte[] buffer = new byte[1024];
            while (!deflater.finished()) {
                int compressedLength = deflater.deflate(buffer);
                outputStream.write(buffer, 0, compressedLength);
            }

            deflater.end();
            outputStream.close();

            return outputStream.toByteArray();
        }

        public static byte[] decompressImage(byte[] compressedBytes) throws IOException, DataFormatException {
            Inflater inflater = new Inflater();
            inflater.setInput(compressedBytes);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressedBytes.length);

            byte[] buffer = new byte[1024];
            while (!inflater.finished()) {
                int decompressedLength = inflater.inflate(buffer);
                outputStream.write(buffer, 0, decompressedLength);
            }

            inflater.end();
            outputStream.close();

            return outputStream.toByteArray();
        }

    /*public static long compressImage(byte[] imageBytes) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(imageBytes);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageBytes.length);

        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int compressedLength = deflater.deflate(buffer);
            outputStream.write(buffer, 0, compressedLength);
        }

        deflater.end();
        outputStream.close();

        long totalOut = outputStream.toByteArray().length;

        return totalOut;
    }

    public static String decompressImage(File file) throws IOException, DataFormatException {
        Inflater inflater = new Inflater();
        byte[] compressedBytes = new byte[4];
        inflater.setInput(compressedBytes);

        if(file == null){
            return "" + (int)file.length()/4.6;
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(compressedBytes.length);

        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int decompressedLength = inflater.inflate(buffer);
            outputStream.write(buffer, 0, decompressedLength);
        }

        inflater.end();
        outputStream.close();

        return "" + (int)file.length()/4.6;
    }*/
}