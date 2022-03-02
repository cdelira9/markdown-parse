import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void getLinksTest() throws IOException{
        Path fileName = Path.of("./test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));

        fileName = Path.of("./test-file2.md");
        contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile2() throws IOException {
        Path fileName = Path.of("./test-file2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile4() throws IOException {
        Path filename = Path.of("test-file4.md");
        String contents = Files.readString(filename);
        assertEquals("Gets link correctly", List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile5() throws IOException {
        Path filename = Path.of("test-file5.md");
        String contents = Files.readString(filename);
        assertEquals("Gets link correctly", List.of(), MarkdownParse.getLinks(contents));
    }


    @Test
    public void testFile6() throws IOException {
        Path filename = Path.of("test-file6.md");
        String contents = Files.readString(filename);
        assertEquals("Gets link correctly", List.of(), MarkdownParse.getLinks(contents));
    }


    
}