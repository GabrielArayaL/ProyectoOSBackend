package com.lien.store.utils;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
  public static String getReadableDate(Date date, String pattern) {
    Locale locale = new Locale("es", "ES");

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Costa_Rica"));

    return simpleDateFormat.format(date);
  }

  public static String getDateFormat(Date date, String pattern) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    return simpleDateFormat.format(date);
  }

  @SneakyThrows
  public static Date getDate(Date date, String pattern) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    return simpleDateFormat.parse(simpleDateFormat.format(date));
  }
}
