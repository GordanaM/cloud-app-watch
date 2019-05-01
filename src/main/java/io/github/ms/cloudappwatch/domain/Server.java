package io.github.ms.cloudappwatch.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import io.github.ms.cloudappwatch.domain.enumeration.ServiceStatus;

/**
 * A Server.
 */
@Entity
@Table(name = "server")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Server implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "host_name")
    private String hostName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ServiceStatus status;

    @Column(name = "last_check")
    private ZonedDateTime lastCheck;

    @ManyToOne
    @JsonIgnoreProperties("servers")
    private User admin;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostName() {
        return hostName;
    }

    public Server hostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public Server status(ServiceStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public ZonedDateTime getLastCheck() {
        return lastCheck;
    }

    public Server lastCheck(ZonedDateTime lastCheck) {
        this.lastCheck = lastCheck;
        return this;
    }

    public void setLastCheck(ZonedDateTime lastCheck) {
        this.lastCheck = lastCheck;
    }

    public User getAdmin() {
        return admin;
    }

    public Server admin(User user) {
        this.admin = user;
        return this;
    }

    public void setAdmin(User user) {
        this.admin = user;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Server server = (Server) o;
        if (server.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), server.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Server{" +
            "id=" + getId() +
            ", hostName='" + getHostName() + "'" +
            ", status='" + getStatus() + "'" +
            ", lastCheck='" + getLastCheck() + "'" +
            "}";
    }
}
