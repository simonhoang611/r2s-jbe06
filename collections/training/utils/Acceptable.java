package collections.training.utils;

public interface Acceptable {
    public final String CODE_VALID ="^[Rr][Aa]\\d{3}$";
    public final String STATUS_VALID ="^(?i:true|false)$";
    public final String FLAG_VALID ="^(?i:optional|prerequisite|n\\/a)$";
    public final String SHORT_VALID = "^\\d+$";

    public static boolean isValid(String data, String pattern){
        return data.matches(pattern);
    }
}
