package br.com.franca.resourceServer.domain.model;

import br.com.franca.resourceServer.domain.listener.CustomRevisionListener;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@org.hibernate.envers.RevisionEntity(CustomRevisionListener.class)
@Entity(name = "revinfo_cust")
@Setter
@Getter
public class CustomRevisionEntity extends DefaultRevisionEntity {

    @Column
    private String ip;

    @Column
    private String usuario;
}
