package com.bpm4sb.process.domain.model.task.impl;

import com.bpm4sb.process.domain.model.task.QueryTaskService;
import com.bpm4sb.process.domain.model.task.TaskAbstract;
import com.bpm4sb.process.domain.model.task.TaskDetail;
import com.bpm4sb.process.domain.model.task.TaskQueryResultSet;
import com.bpm4sb.process.domain.model.task.TaskTypeEnum;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ianache
 */
public class QueryTaskServiceImpl implements QueryTaskService {

    @Override
    public List<TaskAbstract> getMyTaskAbstracts(TaskTypeEnum taskType, String genericHumanRole, Set<String> statuses, Integer maxTasks, Integer taskIndexOffset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaskDetail> getMyTaskDetails(TaskTypeEnum taskType, String genericHumanRole, Set<String> statuses, Integer maxTasks) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaskQueryResultSet query(Integer maxTasks, Integer taskIndexOffset) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
