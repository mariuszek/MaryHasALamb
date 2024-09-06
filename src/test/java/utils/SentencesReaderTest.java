package utils;

import org.junit.Assert;
import org.junit.Test;
import org.mariusz.utils.SentencesReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SentencesReaderTest {
    SentencesReader reader = new SentencesReader();

    @Test
    public void readTest() throws FileNotFoundException {

        Path resourceDirectory = Paths.get("src","test","resources","small.in");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        reader.read(new FileInputStream(absolutePath));

    }


}
