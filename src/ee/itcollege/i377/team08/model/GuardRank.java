package ee.itcollege.i377.team08.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = ("PiirivalvurAuaste"))
@NamedQueries({
		@NamedQuery(name = "GuardRank.findAll", query = "SELECT g FROM GuardRank g WHERE g.removed IS null"),
		@NamedQuery(name = "GuardRank.findWithDeleted", query = "SELECT g FROM GuardRank g") })
public class GuardRank extends DatabaseModel implements Serializable {

	private static final long serialVersionUID = -7030775697103650332L;

	@Column(name = "alates")
	private Date start;

	@Column(name = "kuni")
	private Date end;

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "auaste_id")
	private Rank rank;

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "piirivalvur_id")
	private Guard guard;

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public String getEndAsString() {
		if (end == null){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(end);
	}

	public String getStartAsString() {
		if (start == null){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(start);
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Guard getGuard() {
		return guard;
	}

	public void setGuard(Guard guard) {
		this.guard = guard;
	}
}
