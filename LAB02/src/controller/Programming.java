package controller;

import excute.Counter;
import excute.Library;
import model.Content;

public class Programming {

    public void run() {
        Library library = new Library();
        Counter counter = new Counter();
        Content contentObject = new Content();

        contentObject.setContentString(library.inputContent());
        
        counter.wordCounter(contentObject.getContentString());
        counter.charCounter(contentObject.getContentString());

        library.display("Word Count: " + counter.getWordCount());
        library.display("Character Count: " + counter.getCharCount());
    }
}
