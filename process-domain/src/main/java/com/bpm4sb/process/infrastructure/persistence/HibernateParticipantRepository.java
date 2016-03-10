package com.bpm4sb.process.infrastructure.persistence;

import com.bpm4sb.process.domain.model.IdentificationService;
import com.bpm4sb.process.domain.model.participant.Participant;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import static com.bpm4sb.common.domain.model.AssertionConcern.*;
import com.bpm4sb.process.domain.model.participant.ParticipantRepository;

/**
 *
 * @author USUARIO
 */
@Transactional
public class HibernateParticipantRepository implements ParticipantRepository {

    @Autowired private HibernateTransactionManager txManager;
    @Autowired private IdentificationService identificationService;

    @Override
    public Participant queryParticipantById(String id) {
        Query q = getSession().createQuery("select p from Participant p where p.id=:_id");
        q.setParameter("_id", id);
        List<Participant> participants = q.list();
        assertStateTrue(participants.size() == 1, "No se ha encontrado el participante");
        return participants.get(0);
    }

    @Override
    public List<Participant> queryAllParticipant() {
        return getSession()
                .createQuery("select p from Participant p order by p.name asc")
                .list();        
    }

    @Override
    public String newParticipant(String name, String description) {
        Participant participant
                = new Participant(identificationService.getUniqueId(), name, description);
        getSession().persist(participant);
        return participant.getId();
    }

    @Override
    public Participant queryParticipantByName(String participantName) {
        Query q = getSession().createQuery("select p from Participant p where p.name=:_name");
        q.setParameter("_name", participantName);
        List<Participant> participants = q.list();
        assertStateTrue(participants.size() == 1, "No se ha encontrado el participante");
        return participants.get(0);
    }

    private Session getSession() {
        return txManager.getSessionFactory().getCurrentSession();
    }
}
