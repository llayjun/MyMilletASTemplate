package other.mvvm.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Millet
 * @description
 * @date 2021/6/24 19:26
 */
public class StringUtil {

    public static String humpToLowerLine(String humpStr, boolean... defaultUppercaseAndTrueLowercase) {
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(humpStr);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        //如果第二个形参为true 转为大写
        if (defaultUppercaseAndTrueLowercase.length >= 1 && defaultUppercaseAndTrueLowercase[0]) {
            return sb.toString().toUpperCase();
        }
        return sb.toString();
    }

}
