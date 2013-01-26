package ee.itcollege.i377.team08.editor;

import java.beans.PropertyEditorSupport;

import ee.itcollege.i377.team08.dao.GuardDao;
import ee.itcollege.i377.team08.model.Guard;

public class GuardEditor extends PropertyEditorSupport {
	 
    private final GuardDao guardDao;
 
    public GuardEditor(GuardDao guardDao) {
        this.guardDao = guardDao;
    }
 
	@Override
	public void setAsText(String guardIDString) throws IllegalArgumentException {
		Guard guard = guardDao.find(Integer.parseInt(guardIDString));
        setValue(guard);
	}
 
}