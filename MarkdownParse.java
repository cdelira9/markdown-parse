// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

        public static ArrayList<String> getLinks(String markdown) {
            ArrayList<String> toReturn = new ArrayList<>();
            // find the next [, then find the ], then find the (, then take up to
            // the next )
            int currentIndex = 0;
            int openParen = 0;
            int nextOpenBracket = 0;
            int nextCloseBracket = 0;
            int closeParen = 0;
            while(currentIndex < markdown.length()) {
                nextOpenBracket = markdown.indexOf("[", currentIndex);
                if (currentIndex > 0 && markdown.indexOf("!", currentIndex) == nextOpenBracket - 1) {
                    currentIndex = nextOpenBracket + 1;
                    continue;
                }
                if(nextOpenBracket >= 0){
                    openParen = markdown.indexOf("(", currentIndex);
                    if(openParen == 0){
                        toReturn.add("");
                        break;
                    }
                }
                if (nextOpenBracket >= 0) {
                    openParen = markdown.indexOf("(", currentIndex);
                    nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
                    if (openParen > 0 && nextCloseBracket == openParen - 1) {
                        closeParen = markdown.indexOf(")", openParen);
                } else {
                    break;
                }

                currentIndex = openParen + 1;
            }
        }
            return toReturn;
        }

    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}