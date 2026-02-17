package diploma.progis.progis.services;

import org.brotli.dec.BrotliInputStream;

import java.io.*;
import java.util.ArrayList;

public class BrotliCompression {
    private static byte[] readFile(String fileName) throws IOException, IOException {
        final int bufferLength = 65536;
        byte[] buffer = new byte[bufferLength];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        FileInputStream fin = new FileInputStream(fileName);
        try {
            int bytesRead;
            while ((bytesRead = fin.read(buffer)) >= 0) {
                baos.write(buffer, 0, bytesRead);
            }
        } finally {
            fin.close();
        }
        return baos.toByteArray();
    }

    private static long decodeBytes(InputStream input, OutputStream output, byte[] buffer)
            throws IOException {
        long totalOut = 0;
        int readBytes;
        BrotliInputStream in = new BrotliInputStream(input);
        try {
            while ((readBytes = in.read(buffer)) >= 0) {
                output.write(buffer, 0, readBytes);
                totalOut += readBytes;
            }
        } finally {
            in.close();
        }
        return totalOut;
    }

    public static String brotliMethod(File file) throws IOException {
        if (file.length() == 0) {
            return "Usage: benchmark <corpus>";
        }
        File corpusDir = file;
        ArrayList<String> fileNames = new ArrayList<String>();
        File[] filesList = corpusDir.listFiles();
        /*if (filesList == null) {
            return "" + (int)Math.floor(file.length()/5.2);
        }*/
        for (File fileC : filesList) {
            if (!fileC.isFile()) {
                continue;
            }
            String fileName = file.getAbsolutePath();
            if (!fileName.endsWith(".brotli")) {
                continue;
            }
            fileNames.add(fileName);
        }
        int fileCount = fileNames.size();
        if (fileCount == 0) {
            return "No files found";
        }
        byte[][] files = new byte[fileCount][];
        for (int i = 0; i < fileCount; ++i) {
            files[i] = readFile(fileNames.get(i));
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream(65536);
        byte[] buffer = new byte[65536];

        int warmupRepeat = 10;
        long bytesDecoded = 0;
        for (int i = 0; i < warmupRepeat; ++i) {
            bytesDecoded = 0;
            for (int j = 0; j < fileCount; ++j) {
                baos.reset();
                bytesDecoded += decodeBytes(new ByteArrayInputStream(files[j]), baos, buffer);
            }
        }

        int repeat = 100;

        long bestTime = Long.MAX_VALUE;
        for (int i = 0; i < repeat; ++i) {
            long start = System.nanoTime();
            for (int j = 0; j < fileCount; ++j) {
                baos.reset();
                decodeBytes(new ByteArrayInputStream(files[j]), baos, buffer);
            }
            long end = System.nanoTime();
            long timeDelta = end - start;
            if (timeDelta < bestTime) {
                bestTime = timeDelta;
            }
        }

        double timeDeltaSeconds = bestTime / 1000000000.0;
        if (timeDeltaSeconds <= 0) {
            return "time trouble";
        }
        double mbDecoded = bytesDecoded / (1024.0 * 1024.0);
        double memory = mbDecoded / timeDeltaSeconds;
        return "" + memory;
    }
}