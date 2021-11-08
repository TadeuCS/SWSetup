package br.com.tcs.sws.infrastructure.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tadeu-pc
 */
public class DateUtils {

    public static String formataData(Date data, String formato) {
        try {
            return new SimpleDateFormat(formato).format(data);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getData(Date data) {
        return formataData(data, "dd/MM/yyyy");
    }

    public static String getHora(Date data) {
        return formataData(data, "HH:mm:ss");
    }

    public static String getDataHora(Date data) {
        return formataData(data, "dd/MM/yyyy HH:mm:ss");
    }

    

}
