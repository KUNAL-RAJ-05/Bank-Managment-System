package bankmanagmentsystem;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utilityclass {

    private static final String BIN = "400000"; // example BIN for VISA
    private static final Set<String> generatedCards = new HashSet<>();

    public static String generateUniqueCardNumber() {
        String cardNumber;
        do {
            cardNumber = generateCardWithLuhn();
        } while (generatedCards.contains(cardNumber));
        
        generatedCards.add(cardNumber);
        return cardNumber;
    }

    private static String generateCardWithLuhn() {
        StringBuilder card = new StringBuilder(BIN);
        Random random = new Random();

        
        for (int i = 0; i < 9; i++) {
            card.append(random.nextInt(10));
        }

       
        card.append(getLuhnChecksum(card.toString()));

        return card.toString();
    }

    private static int getLuhnChecksum(String number) {
        int sum = 0;
        boolean alternate = true;
        
        
        for (int i = number.length() - 1; i >= 0; i--) {
            int n = number.charAt(i) - '0';
            if (alternate) {
                n *= 2;
                if (n > 9) n -= 9;
            }
            sum += n;
            alternate = !alternate;
        }

        return (10 - (sum % 10)) % 10;
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    public static boolean isValidAadhaar(String aadhar) {
        String aadharRegex = "^[2-9]{1}[0-9]{11}$";
        return aadhar != null && aadhar.matches(aadharRegex);
    }
    public static boolean isValidPan(String pan) {
        String panRegex = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
        return pan != null && pan.matches(panRegex);
    }

}
