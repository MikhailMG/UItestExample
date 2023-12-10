package Utils.RandomUtils;


import lombok.Getter;

@Getter
public class StringRandomGenerator {
    private static final String ALPHA_NUMERIC_STRING =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789";
    private static final String ALPHA_NUMERIC_SPESHIAL_STRING =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm0123456789!@#%^&*()<>?|";
    private static final String KIRRILIC_STRING =
            "йцукенгшщзхъфывапролджэячсмитьбю";

    public static String getRandomString(int countLength, String charScope) {
        StringBuilder builder = new StringBuilder();
        while (countLength-- != 0) {
            int character = (int) (Math.random() * charScope.length());
            builder.append(charScope.charAt(character));
        }
        return builder.toString();
    }

    public static String getALPHA_NUMERIC_STRING() {
        return ALPHA_NUMERIC_STRING;
    }

    public static String getALPHA_NUMERIC_SPESHIAL_STRING() {
        return ALPHA_NUMERIC_SPESHIAL_STRING;
    }

    public static String getCIRRILIC_STRING() {
        return KIRRILIC_STRING;
    }
}