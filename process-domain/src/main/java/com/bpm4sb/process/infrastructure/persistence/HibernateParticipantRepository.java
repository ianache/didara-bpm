package com.bpm4sb.process.infrastructure.persistence;

import com.bpm4sb.process.domain.model.IdentificationService;
import com.bpm4sb.process.domain.model.participant.Participant;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import static com.bpm4sb.common.domain.model.AssertionConcern.*;
import com.bpm4sb.process.domain.model.participant.ParticipantRepository;
import java.text.MessageFormat;

/**
 *
 * @author ianache
 */
public class HibernateParticipantRepository extends HibernateBaseRepository 
        implements ParticipantRepository {

    @Autowired private IdentificationService identificationService;

    @Override
    public Participant queryParticipantById(String id) {
        Query q = session().createQuery("select p from Participant p where p.id=:_id");
        q.setParameter("_id", id);
        List<Participant> participants = q.list();
        assertState(participants.size() == 1, MessageFormat.format("No se ha encontrado el participante {0}",id));
        return participants.get(0);
    }

    @Override
    public List<Participant> queryAllParticipant() {
        return session()
                .createQuery("select p from Participant p order by p.name asc")
                .list();        
    }

    @Override
    public String newParticipant(String name, String description) {
        Participant participant = queryParticipantByName(name);
        assertState(participant == null, MessageFormat.format("El participante {0} ya existe", name));
        participant = new Participant(identificationService.getUniqueId(), name, description);
        session().persist(participant);
        return participant.getId();
    }

    @Override
    public Participant queryParticipantByName(String participantName) {
        Query q = session().createQuery("select p from Participant p where p.name=:_name");
        q.setParameter("_name", participantName);
        List<Participant> participants = q.list();
        return (participants.size() == 1) ? participants.get(0) : (null);
    }

    @Override
    public void save(Participant participant) {
        session().update(participant);
    }
}
