package fr.univcotedazur.iut.info.m414.projet;

import org.junit.Test;

import java.util.HashMap;

import static fr.univcotedazur.iut.info.m414.projet.MainActivity.isValid;
import static org.junit.Assert.assertEquals;

public class isValidTest {
    @Test
    public void test_isValid() {

        HashMap<String, Boolean> values = new HashMap<>();
        values.put("55", false);
        values.put("1*2", true);
        values.put("1* 2", true);
        values.put("1 *2", true);
        values.put("1/2", true);
        values.put("1**2", false);
        values.put("1***2", false);
        values.put("1//2", false);
        values.put("1++2", true);
        values.put("1--2", true);
        values.put("1+2", true);
        values.put("1-2", true);
        values.put("1+2+5", true);
        values.put("1+(2+5)", true);

        values.forEach((s, b) -> {
            assertEquals(isValid(s), b);
        });


    }
}
