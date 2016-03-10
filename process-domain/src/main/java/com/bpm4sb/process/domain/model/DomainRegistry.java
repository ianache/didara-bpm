package com.bpm4sb.process.domain.model;

import com.bpm4sb.process.domain.model.taskedefinition.TaskDefinitionRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author ianache
 */
public class DomainRegistry implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    
    public static TaskDefinitionRepository taskDefinitionRepository() {
        return (TaskDefinitionRepository) 
                applicationContext.getBean("taskDefinitionRepository");
    }

    @Override
    public synchronized void setApplicationContext(
            ApplicationContext anApplicationContext) throws BeansException {

        if (DomainRegistry.applicationContext == null) {
            DomainRegistry.applicationContext = anApplicationContext;
        }
    }
}
