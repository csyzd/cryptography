package cryptography.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CaesarCrypto {

    private static final String CAESAR_ENCRYPTED_TEXT = "PELCGBTENCUL";
    private static final int LETTER_COUNT = 26;
    private static final int OFFSET = 32;
    private static final char MAX_CHAR = 'z';
    private static final char MIN_CHAR = 'a';


    public static void main(String[] args) {

        doDecrypt(CAESAR_ENCRYPTED_TEXT);
    }

    private static void doDecrypt(String caesarEncryptedText) {

        for(int pass = 0; pass <= LETTER_COUNT; pass++){

            StringBuilder decryptedText = new StringBuilder();
            for(int k = 0; k < caesarEncryptedText.length(); k++){
                char c = (char)(caesarEncryptedText.charAt(k) + OFFSET + pass);
                int offset = c - MAX_CHAR;
                if(offset > 0){
                    c = (char) ('a' + offset - 1);
                }

                decryptedText.append(c);
            }

            log.info("=== Possible decrypted text with pass={} is {}", pass, decryptedText);
        }
    }
}
