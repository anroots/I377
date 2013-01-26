package ee.itcollege.i377.team08.editor;

import java.beans.PropertyEditorSupport;

import ee.itcollege.i377.team08.dao.RankDao;
import ee.itcollege.i377.team08.model.Rank;

public class RankEditor extends PropertyEditorSupport {
	 
    private final RankDao rankDao;
 
    public RankEditor(RankDao rankDao) {
        this.rankDao = rankDao;
    }
 
	@Override
	public void setAsText(String rankIDString) throws IllegalArgumentException {
		Rank rank = rankDao.find(Integer.parseInt(rankIDString));
        setValue(rank);
	}
 
}