package controller;

import java.util.Locale;
import java.util.ResourceBundle;
import view.Menu;

public class Programming extends Menu {
    private Validation valid;

    public Programming(String td, String[] mc, Validation validation) {
        super(td, mc);
        this.valid = validation;
    }

    @Override
    public void execute(int n) {
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;
        switch (n) {
            case 1:
                login(vietnamese);
                break;
            case 2:
                login(english);
                break;
            case 3:
                System.exit(0);
        }
    }

    public String generateCaptchaText() {
        final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
                'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
                'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
                'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
                '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
                'Y', 'y', 'Z', 'z', '9'};
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    public void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words
                = ResourceBundle.getBundle("Language/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }

    public void login(Locale language) {
        getWordLanguage(language, "enterAccountNumber");
        int accountNumber = valid.checkInputAccount(language);
        getWordLanguage(language, "enterPassword");
        String passString = valid.checkInputPassword(language);
        String captchaGenerated = generateCaptchaText();
        while (true) {
            if (valid.checkInputCaptcha(captchaGenerated, language)) {
                getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println();
            }
        }
    }
}
