package com.bpm4sb.bpmn;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
//import com.didara.bpmn.model.Process;

import org.junit.Test;

public class LoadProcessTest {
        HashMap<String, TParticipant> mapIdToNames = new HashMap<String, TParticipant>();

	@Test
	public void test() {
		try {
			
			JAXBContext jbctx = JAXBContext.newInstance(/* TDefinitions.class*/"com.bpm4sb.bpmn");
			Unmarshaller um = jbctx.createUnmarshaller();
			File fd = new File( "F:\\dev_ws\\didara\\bpm\\doc\\example1.bpmn" );
			
			Object o = um.unmarshal(fd);
			assertTrue(o != null);
			
			JAXBElement<TDefinitions> obj = 
				(JAXBElement<TDefinitions>) um.unmarshal(fd);
			TDefinitions def = obj.getValue();
                        
                        // Load all definitions colaborations
                        for(JAXBElement<? extends TRootElement> e: def.getRootElement()) {
				if(e.getValue() instanceof TCollaboration) {
                                    TCollaboration c = (TCollaboration) e.getValue();
                                    for(TParticipant part: c.getParticipant()) {
                                        mapIdToNames.put(part.getProcessRef().getLocalPart(), part);
                                    }
                                }
                        }                                
			
                        // Load all processes definitions
			Process process = null;
			for(JAXBElement<? extends TRootElement> e: def.getRootElement()) {
				if(e.getValue() instanceof TProcess) {
                                    loadProcess((TProcess) e.getValue());
				}
			}
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}

    private void loadProcess(TProcess p) {
        
        System.out.println("Nombre: " + mapIdToNames.get(p.getId()).getName());
        System.out.println("Id: " + p.getId());
        
    }
}
