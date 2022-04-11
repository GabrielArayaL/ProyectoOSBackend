package com.lien.store.utils;

import java.util.Random;

public class GeneralUtil {
  public static String generatePassword(int length) {
    String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "1234567890";
    String special = "!@#$";
    String combined = capital + lower + numbers + special;

    Random random = new Random();

    String password =
        String.valueOf(capital.charAt(random.nextInt(capital.length())))
            .concat(String.valueOf(lower.charAt(random.nextInt(lower.length()))))
            .concat(String.valueOf(numbers.charAt(random.nextInt(numbers.length()))))
            .concat(String.valueOf(special.charAt(random.nextInt(special.length()))));

    for (int i = 4; i < length; i++) {
      password =
          password.concat(String.valueOf(combined.charAt(random.nextInt(combined.length()))));
    }

    return password;
  }
}
