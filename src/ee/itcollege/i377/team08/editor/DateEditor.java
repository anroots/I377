package ee.itcollege.i377.team08.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String date) throws IllegalArgumentException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Date formattedDate;
		try {
			formattedDate = formatter.parse(date);
		} catch (ParseException e) {
			formattedDate = null;
			e.printStackTrace();
		}
		setValue(formattedDate);
	}

}