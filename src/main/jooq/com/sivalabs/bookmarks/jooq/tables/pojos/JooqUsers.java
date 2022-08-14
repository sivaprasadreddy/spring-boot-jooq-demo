/*
 * This file is generated by jOOQ.
 */
package com.sivalabs.bookmarks.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String email;
    private String password;
    private Long addrId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public JooqUsers() {}

    public JooqUsers(JooqUsers value) {
        this.id = value.id;
        this.name = value.name;
        this.email = value.email;
        this.password = value.password;
        this.addrId = value.addrId;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public JooqUsers(
        Long id,
        String name,
        String email,
        String password,
        Long addrId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.addrId = addrId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for <code>USERS.ID</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>USERS.ID</code>.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>USERS.NAME</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>USERS.NAME</code>.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for <code>USERS.EMAIL</code>.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter for <code>USERS.EMAIL</code>.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for <code>USERS.PASSWORD</code>.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Setter for <code>USERS.PASSWORD</code>.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for <code>USERS.ADDR_ID</code>.
     */
    public Long getAddrId() {
        return this.addrId;
    }

    /**
     * Setter for <code>USERS.ADDR_ID</code>.
     */
    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    /**
     * Getter for <code>USERS.CREATED_AT</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>USERS.CREATED_AT</code>.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Getter for <code>USERS.UPDATED_AT</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Setter for <code>USERS.UPDATED_AT</code>.
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final JooqUsers other = (JooqUsers) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.email == null) {
            if (other.email != null)
                return false;
        }
        else if (!this.email.equals(other.email))
            return false;
        if (this.password == null) {
            if (other.password != null)
                return false;
        }
        else if (!this.password.equals(other.password))
            return false;
        if (this.addrId == null) {
            if (other.addrId != null)
                return false;
        }
        else if (!this.addrId.equals(other.addrId))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        if (this.updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        }
        else if (!this.updatedAt.equals(other.updatedAt))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
        result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
        result = prime * result + ((this.addrId == null) ? 0 : this.addrId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqUsers (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(email);
        sb.append(", ").append(password);
        sb.append(", ").append(addrId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
