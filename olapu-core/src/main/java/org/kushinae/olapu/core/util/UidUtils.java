package org.kushinae.olapu.core.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * uid生成器
 *
 * @author kaisa.liu
 * @since 1.0.0
 */
public class UidUtils {

    private static List<Character> letters = new ArrayList<>(Stream.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0').toList());

    public static String generate(int size) {

        if (size < 1) {
            throw new IllegalArgumentException("Uid generate size the minimum cannot be less than 1");
        }

        StringBuilder uid = new StringBuilder();

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < size; i++) {
            Collections.shuffle(letters);
            uid.append(letters.get(random.nextInt(letters.size())));
        }

        return uid.toString();
    }

}
