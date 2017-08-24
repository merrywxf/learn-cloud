package ig.erp.task.service.config;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;


/**
 * Created by Administrator on 2017-06-12.
 */
public class MyDateEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        SimpleDateFormat sdf = getDate(text);
        try {
            setValue(sdf.parseObject(text));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private SimpleDateFormat getDate(String text) {
        SimpleDateFormat sdf = null;
        if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", text)) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return sdf;
    }
}
