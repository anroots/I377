package ee.itcollege.i377.team08.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Amet")
@NamedQueries({
	@NamedQuery(name = "RankType.findAll", query = "SELECT o FROM RankType o WHERE o.removed IS null"),
	@NamedQuery(name = "RankType.findWithDeleted", query = "SELECT o FROM RankType o")
})
public class RankType extends DatabaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "IscoKood")
	@NotNull
	@Size(min = 2, max = 10)
	private String code;
	
	@Column(name = "Nimetus")
	@NotNull
	@Size(min = 5, max = 50)
	private String name;
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public int hashCode() {
        return new Integer(id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof RankType)) {
            return false;
        }
        return this.id == ((RankType)obj).getId();
    }

}
