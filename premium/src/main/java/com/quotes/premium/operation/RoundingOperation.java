package com.quotes.premium.operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quotes.premium.dto.Applicable;
import com.quotes.premium.dto.Attribute;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoundingOperation implements Operation {

    private static String capitalizeFirstLetter(final String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    @Override
    public void apply(final Applicable obj, final String key, final String baseValueKey, final Attribute attribute) throws Exception {
        if(!attribute.isRounding()){
            return ;
        }
        final Field field = Applicable.class.getDeclaredField(key);
        field.setAccessible(true);
        Double currentDiscount = (Double) field.get(obj);
        currentDiscount = (double) Math.round(currentDiscount);
        final Method method = Applicable.class.getMethod("set" + RoundingOperation.capitalizeFirstLetter(key), Double.class);
        method.invoke(obj, currentDiscount);
    }

    public static void main(String[] args) throws JsonProcessingException {
        final Map<String, List<String>> coverMap = new HashMap<>();
        coverMap.put("lifestyle", List.of("nri","internationalSecondOpinion"));
        coverMap.put("discounts", List.of("nri","internationalSecondOpinion"));
        System.out.println(new ObjectMapper().writeValueAsString(coverMap));
    }
}
