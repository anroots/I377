package ee.itcollege.i377.team08.model;

import java.util.Date;

import javax.activity.InvalidActivityException;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.TableGenerator;

import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public abstract class DatabaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, 
					generator =  "generatorName")
	@TableGenerator(table= "SEQUENCE", 
					initialValue = 1, 
					allocationSize = 1, 
					name = "generatorName",
					pkColumnName = "SEQ_NAME",
					valueColumnName = "SEQ_COUNT")
	private int id;
	
	@Column(name = "avaja")
	private String creator;
	
	@Column(name = "avatud")
	private Date created;
	
	@Column(name = "muutja")
	private String modifier;
	
	@Column(name = "muudetud")
	private Date modified;
	
	@Column(name = "sulgeja")
	private String remover;
	
	@Column(name = "suletud")
	private Date removed;
	
	@Column(name = "kommentaar")
	private String comment;
	
	private int version;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;  
	}
	
	public String getCreator() {
		return creator;
	}

	public Date getCreated() {
		return created;
	}

	public String getModifier() {
		return modifier;
	}

	public Date getModified() {
		return modified;
	}

	public String getRemover() {
		return remover;
	}

	public Date getRemoved() {
		return removed;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public void setRemover(String remover) {
		this.remover = remover;
	}

	public void setRemoved(Date removed) {
		this.removed = removed;
	}
	
	@PrePersist
    public void recordCreated() {
		setCreator(getCurrentUserName());
        setCreated( new Date() );
    }

    @PreUpdate
    public void recordModified() {
    	setModifier(getCurrentUserName());
        setModified( new Date() );
    }

    @PreRemove
    public void recordRemoved() throws InvalidActivityException {
        throw new InvalidActivityException("Can not delete records, instead check for the removed column");
    }
    
    private String getCurrentUserName() {
    	 if (SecurityContextHolder.getContext().getAuthentication() == null) 
    		 return "anonymous";
    	   	 
    	 return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
}
