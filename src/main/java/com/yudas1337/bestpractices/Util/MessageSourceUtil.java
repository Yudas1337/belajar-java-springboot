package com.yudas1337.bestpractices.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageSourceUtil {

    private static MessageSource messageSource;

    @Autowired
    public MessageSourceUtil(MessageSource messageSource) {
        MessageSourceUtil.messageSource = messageSource;
    }

    public static String getMessage(String code, Object[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }

    public static String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }

    public static String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.ENGLISH);
    }
}
