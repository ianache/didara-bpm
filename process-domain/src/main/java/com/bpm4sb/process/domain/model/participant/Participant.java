package com.bpm4sb.process.domain.model.participant;

import com.bpm4sb.common.domain.model.DomainEventPublisher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Esta clase representa al participante responsable de la ejecución de la tarea.
 * Contiene una referencia a todos los usuarios o grupos de usuarios que se ven
 * representados por el participante.
 *
 * @author ianache
 */
public class Participant {
    private String id;
    private String name;
    private String description;
    private Set<OrganizationalEntity> assigments = new HashSet<>();

    public Participant() {
        super();
    }

    public Participant(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        
        DomainEventPublisher
                .instance()
                .publish(new ParticipantCreated(name, id));
    }    

    public Set<OrganizationalEntity> getAssigments() {
        return assigments;
    }

    public void setAssigments(Set<OrganizationalEntity> assigments) {
        this.assigments = assigments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addAssigment(String identityName, IdentityType identityType) {
        OrganizationalEntity orgEntity = new OrganizationalEntity(this, identityName,identityType);
        getAssigments().add(orgEntity);
    }

    public void removeAssigment(String identityName) {
        OrganizationalEntity fe = queryAssignmentByName(identityName);
        getAssigments().remove(fe);
    }

    public OrganizationalEntity queryAssignmentByName(String identityName) {
        Optional<OrganizationalEntity> o = getAssigments()
                .stream()
                .filter((OrganizationalEntity x) -> x.getIdentityName().equals(identityName)).findFirst();
        return o!=null ? o.get() : null;
    }
}
