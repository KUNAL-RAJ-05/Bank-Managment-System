package bankmanagmentsystem;

public class Utilityclass {
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
