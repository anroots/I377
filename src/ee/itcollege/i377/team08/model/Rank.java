package ee.itcollege.i377.team08.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Auaste")
@NamedQueries({
	@NamedQuery(name = "Rank.findAll", query = "SELECT o FROM Rank o WHERE o.removed IS null"),
	@NamedQuery(name = "Rank.findWithDeleted", query = "SELECT o FROM Rank o")
})
public class Rank extends DatabaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "Kood")
	@NotNull
	@Size(min = 2, max = 16)
	private String code;
	
	@Column(name = "Nimetus")
	@NotNull
	@Size(min = 2, max = 32)
	private String name;
	
	@ManyToOne
	@NotNull
	@PrimaryKeyJoinColumn(name="TYYP")
	private RankType type;
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
	public RankType getType() {
		return type;
	}

	public void setType(RankType type) {
		this.type = type;
	}
	

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
