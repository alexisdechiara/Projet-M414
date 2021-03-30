package fr.univcotedazur.iut.info.m414.projet;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static fr.univcotedazur.iut.info.m414.projet.MainActivity.checkResult;
import static fr.univcotedazur.iut.info.m414.projet.MainActivity.isValid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        values.put("1+2", true);
        values.put("1--2", false);
        values.put("1++2", false);
        values.put("1-2", true);
        values.put("1+2+5", true);
        values.put("1+(2+5)", false);

        values.forEach((s, b) -> assertEquals(isValid(s), b));


        String[] s = {"1+5", "5-2", "1*5", "8/3","1+5", "5-2", "1*5", "8/2", "1+5", "5-2"};
        String[] s1 = {"1+5", "5-2", "1*5", "8/2"};
        String[] s2 = {"1+5", "5-2", "1*5", "8/2"};
        /*try {
            int[] tab1 = checkResult(s);
            for (int i = 0 ; i < 10; i++){
                System.out.println(tab1[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        int[] test = checkResult(s);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
