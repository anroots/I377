package ee.itcollege.i377.team08.editor;

import java.beans.PropertyEditorSupport;

import ee.itcollege.i377.team08.dao.RankTypeDao;
import ee.itcollege.i377.team08.model.RankType;

public class RankTypeEditor extends PropertyEditorSupport {
	 
    private final RankTypeDao rankTypeDao;
 
    public RankTypeEditor(RankTypeDao rankTypeDao) {
        this.rankTypeDao = rankTypeDao;
    }
 
	@Override
	public void setAsText(String rankTypeIDString) throws IllegalArgumentException {
		RankType rank = rankTypeDao.find(Integer.parseInt(rankTypeIDString));
        setValue(rank);
	}
 
}