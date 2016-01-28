package com.bpm4sb.bpmn;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.didara.bpmn.model.Process;

import org.junit.Test;

public class LoadProcessTest {

	@Test
	public void test() {
		try {
			
			JAXBContext jbctx = JAXBContext.newInstance(/*TDefinitions.class*/"com.bpm4sb.bpmn");
			Unmarshaller um = jbctx.createUnmarshaller();
			File fd = new File( "H:\\innovaswc\\bpm4sm\\doc\\example1.bpmn" );
			
			Object o = um.unmarshal(fd);
			assertTrue(o != null);
			
			JAXBElement<TDefinitions> obj = 
				(JAXBElement<TDefinitions>) um.unmarshal(fd);
			TDefinitions def = obj.getValue();
			
			Process process = null;
			for(JAXBElement<? extends TRootElement> e: def.getRootElement()) {
				if(e.getValue() instanceof TProcess) {
					process = loadProcess((TProcess) e.getValue());
					break;
				}				
			}
			
			assertTrue(process != null);
			assertEquals("Process_1", process.getId());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}

	private Process loadProcess(TProcess p) {
		Process result = new Process();
		result.setId(p.getId());
		return result;
	}

}
