package com.smart.contact.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "mst_contact")
public class MstContactBo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String name;
    private String nick_name;
    private String email;
    private String contact_number;
    private String description;

    @ManyToOne()
	private MstUserBo user_id;
    
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MstUserBo getUser_id() {
		return user_id;
	}

	public void setUser_id(MstUserBo user_id) {
		this.user_id = user_id;
	}

	@Override
    public String toString() {
        return "MstContactBo{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", email='" + email + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", desc='" + description + '\'' +
                '}';
    }

    public MstContactBo() {
        super();
    }

    public MstContactBo(int cid, String name, String nick_name, String email, String contact_number, String description) {
        this.cid = cid;
        this.name = name;
        this.nick_name = nick_name;
        this.email = email;
        this.contact_number = contact_number;
        this.description = description;
    }
}
