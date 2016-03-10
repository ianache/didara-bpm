package com.bpm4sb.process.domain.model.task;

import java.util.List;
import java.util.Set;

/**
 *
 * @author ianache
 */
public interface QueryTaskService {
    /**
     * Retrieve the task abstracts. This operation is used to obtain the data 
     * required to display a task list.
     * 
     * If no task type has been specified then the default value “ALL” MUST 
     * be used.
     * 
     * If no generic human role has been specified then the default value 
     * “actualOwner” MUST be used.
     * 
     * If no status list has been specified then tasks in all valid states 
     * are returned.
     * 
     * @param taskType
     * @param genericHumanRole
     * @param statuses
     * @param maxTasks
     * @param taskIndexOffset
     * @return 
     */
    List<TaskAbstract> getMyTaskAbstracts(TaskTypeEnum taskType, String genericHumanRole
            /*, String workQueue*/
            , Set<String> statuses
            /*, String wherClause, String orderByClause, Date createOnClause,*/
            ,Integer maxTasks, Integer taskIndexOffset);
    
    /**
     * Retrieve the task details. This operation is used to obtain the data 
     * required to display a task list, as well as the details for the 
     * individual tasks.
     * 
     * If no task type has been specified then the default value “ALL” MUST 
     * be used. If no generic human role has been specified then the default 
     * value “actualOwner” MUST be used.
     * 
     * If no status list has been specified then tasks in all valid states 
     * are returned.
     * 
     * @param taskType
     * @param genericHumanRole
     * @param statuses
     * @param maxTasks
     * @return 
     */
    List<TaskDetail> getMyTaskDetails(TaskTypeEnum taskType, String genericHumanRole
            /*, String workQueue*/
            , Set<String> statuses
            /*, String wherClause, String orderByClause, Date createOnClause,*/
            ,Integer maxTasks);
    
    /**
     * Retrieve task data.  If maxTasks is specified, then the number of task 
     * returned by the query MUST NOT exceed this limit. The 
     * taskIndexOffset can be used to perform multiple identical queries and 
     * iterate over result sets where the maxTasks size exceeds the query limit. 
     * 
     * @param maxTasks
     * @param taskIndexOffset
     * @return 
     */
    TaskQueryResultSet query(/*String selectClause, String whereClause, 
            String orderByClause,*/
            Integer maxTasks, Integer taskIndexOffset);
}
