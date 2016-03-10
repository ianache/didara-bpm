package com.bpm4sb.process.domain.model.task;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ianache
 */
public interface TaskService {
    /**
     * Activate the task.
     * 
     * @param taskId 
     */
    void activate(String taskId);
    /**
     * Nominate an organization entity to process the task.
     * @param taskId 
     * @param orgEntity 
     */
    void nominate(String taskId, OrganizationalEntity orgEntity);
    /**
     * Replace the organizational assignment to the task in one generic human role.
     * 
     * @param taskId
     * @param genericHumanRole
     * @param orgEntity 
     */
    void setGenericHumanRole(String taskId, String genericHumanRole, 
            OrganizationalEntity orgEntity);
    /**
     * Add attachment to a task. Returns an identifier for the attachment.
     * 
     * @param taskId
     * @param attachmentName
     * @param accessType
     * @param contentType
     * @param data
     * @return 
     */
    String addAttachment(String taskId, String attachmentName, String accessType,
            String contentType, Object data);
    /**
     * Add a comment to a task. Returns an identifier that can be used to later 
     * update or delete the comment.
     * 
     * @param taskId
     * @param comment 
     * @return  
     */
    String addComment(String taskId, String comment);
    /**
     * Claim responsibility for a task, i.e. set the task to status Reserved.
     * 
     * @param taskId 
     */
    void claim(String taskId);
    /**
     * Execution of the task finished successfully.
     * 
     * @param taskId
     * @param outputData 
     */
    void complete(String taskId, String outputData);
    /**
     * Assign the task to one user and set the task to state Reserved. 
     * If the recipient was not a potential owner then this person MUST be 
     * added to the set of potential owners.
     * 
     * @param taskId
     * @param orgEntity 
     */
    void delegate(String taskId, OrganizationalEntity orgEntity);
    /**
     * Delete the attachment with the specified identifier from the task.
     * 
     * @param taskId
     * @param attachmentId 
     */
    void deleteAttachment(String taskId, String attachmentId);
    /**
     * Deletes the identified comment.
     * 
     * @param taskId
     * @param commentId 
     */
    void deleteComment(String taskId, String commentId);
    /**
     * Deletes the fault name and fault data of the task.
     * 
     * @param taskId 
     */
    void deleteFault(String taskId);
    /**
     * Deletes the output data of the task.
     * 
     * @param taskId 
     */
    void deleteOutput(String taskId);
    /**
     * Execution of the task fails and a fault is returned.
     * 
     * @param taskId
     * @param faultData 
     */
    void fail(String taskId, FaultData faultData);
    /**
     * Forward the task to another organization entity. Potential owners MAY 
     * forward a task while the task is in the Ready state.
     * 
     * @param taskId
     * @param orgEntity 
     */
    void forward(String taskId, OrganizationalEntity orgEntity);
    /**
     * Get the task attachment with the given identifier.
     * 
     * @param taskId
     * @param attachmentId
     * @return 
     */
    AttachmentInfo getAttachment(String taskId, String attachmentId);
    /**
     * Get attachment information for all attachments associated with the task.
     * 
     * @param taskId
     * @return 
     */
    List<AttachmentInfo> getAttachmentInfos(String taskId);
    /**
     * Get all comments of a task.
     * 
     * @param taskId
     * @return 
     */
    List<Comment> getComments(String taskId);
    /**
     * Get the fault data of the task.
     * 
     * @param taskId
     * @return 
     */
    FaultData getFault(String taskId);
    /**
     * Get the data for the part of the task's input message.
     * 
     * @param taskId
     * @param partName
     * @return 
     */
    Object getInput(String taskId, String partName);
    /**
     * Get the outcome of the task.
     * 
     * @param taskId
     * @return 
     */
    String getOutcome(String taskId);
    /**
     * Get the data for the part of the task's output message.
     * 
     * @param taskId
     * @param partName
     * @return 
     */
    Object getOutput(String taskId, String partName);
    /**
     * Returns the superior composite task of a sub task.
     * 
     * @param taskId
     * @return 
     */
    TaskDetail getParentTask(String taskId);
    /**
     * Returns the task identifier of the superior composite task of a sub task.
     * 
     * @param taskId
     * @return 
     */
    String getParentTaskIdentifier(String taskId);
    /**
     * Returns the rendering specified by the type parameter. 
     * 
     * @param taskId
     * @param rendingType
     * @return 
     */
    Object getRendering(String taskId, String rendingType);
    /**
     * Applies to both tasks and notifications. Returns the rendering types 
     * available for the task or notification.
     * 
     * @param taskId
     * @return 
     */
    List<String> getRenderingTypes(String taskId);
    /**
     * Returns the identifiers of all already created sub tasks of a task
     * 
     * @param taskId
     * @return 
     */
    List<String> getSubtaskIdentifiers(String taskId);
    List<TaskDetail> getSubtasks(String taskId);
    String getTaskDescription(String taskId/*, contentType*/);
    TaskDetail getTaskDetails(String taskId);
    List<TaskEvent> getTaskHistory(String taskId, TaskHistoryFilter filter,
            Integer startIndex, Integer maxTasks/*, includeData*/);
    TaskInstanceData getTaskInstanceData(String taskId);
    /**
     * Returns list of operations that are available to the authorized user 
     * given the user's role and the state of the task.
     * 
     * @param taskId
     * @return 
     */
    List<String> getTaskOperations(String taskId);
    Boolean hasSubtasks(String taskId);
    String instantiateSubTask(String taskId, String taskName);
    Boolean isSubtask(String taskId);
    void release(String taskId);
    void remove(String taskId);
    void resume(String taskId);
    void setFault(String taskId, String faultName, String faultData);
    void setOutput(String taskId, String partName, String outputData);
    void setPriority(String taskId, Integer priority);
    void setTaskCompletionDeadlineExpression(String taskId, String deadLineName, 
            String durationExpression);
    void setTaskCompletionDurationExpression(String taskId, String deadLineName, 
            String durationExpression);
    void setTaskStartDeadlineExpression(String taskId, String deadLineName, 
            String durationExpression);
    void setTaskStartDurationExpression(String taskId, String deadLineName, 
            String durationExpression);
    void skip(String taskId);
    void start(String taskId);
    void stop(String taskId);
    void suspend(String taskId);
    void suspendUntil(String taskId, TimePeriod timePeriod, Date pointInTime);
    void updateComment(String taskId, String commentId, String newComment);
    String getActualOwner(String taskId);
    List<OrganizationalEntity> getBusinessAdministrators(String taskId);
    /**
     * Returns the number of finished sub tasks of a task If the task name is 
     * not present the current task MUST be considered.
     * 
     * @param taskId
     * @return 
     */
    Integer getCountOfFinishedSubTasks(String taskId);
    /**
     * Returns the number of sub tasks of a task If the task name is not present 
     * the current task MUST be considered.
     * 
     * @param taskId
     * @return 
     */
    Integer getCountOfSubTasks(String taskId);
    /**
     * Returns the number of a task subtasks that are in the specified state. 
     * If the task name is not present the current task MUST be considered.
     * 
     * @param state
     * @param taskName
     * @return 
     */
    Integer getCountOfSubTasksInState(String state, String taskName);
    /**
     * Returns the number of a task sub tasks that match the given outcome. 
     * If the task name is not present the current task  MUST be considered.
     * @param outcome
     * @param taskName
     * @return 
     */
    Integer getCountOfSubTasksWithOutcome(String outcome, String taskName);
    /**
     * Returns the excluded owners. If the task name is not present the 
     * current task MUST be considered.
     * 
     * @param name
     * @return 
     */
    List<OrganizationalEntity> getExcludedOwners(String name);

    /**
     * Returns the value of a logical people group. If the task name is not 
     * present the current task MUST be considered.
     * 
     * @param nameLogicalPeopleGroup
     * @param parameters
     * @return 
     */
    OrganizationalEntity getLogicalPeopleGroup(String nameLogicalPeopleGroup, 
            HashMap<String, String> parameters);
    /**
     * Returns the potential owners of the task.
     * 
     * @param taskName
     * @return 
     */
    List<OrganizationalEntity> getPotentialOwners(String taskName);
    /**
     * Returns a node-set representing the specified part or contained elements 
     * of a sub task‟s output message. Only completed sub tasks of the current 
     * task MUST be considered.
     * 
     * @param subTaskName
     * @return 
     */
    HashMap<String, String> getSubtaskOutput(String subTaskName/*, String partName, String locationPath*/);
    /**
     * Returns a node-set of simpletyped or complex-typed elements, 
     * constructed from the sub tasks‟ output documents in a routing pattern. 
     * 
     * @param partName
     * @return 
     */
    HashMap<String, String> getSubtaskOutputs(String partName/*, String locationPath*/);
    /**
     * Returns the initiator of the task. If the task name is not present the 
     * current task MUST be considered.
     * 
     * @param taskName
     * @return 
     */
    String getTaskInitiator(String taskName);
    /**
     * Returns the priority of the task.
     * 
     * @param taskName
     * @return 
     */
    Integer getTaskPriority(String taskName);
    /**
     * Returns the stakeholders of the task. If the task name is not present 
     * the current task MUST be considered.
     * 
     * @param taskId
     * @return 
     */
    List<OrganizationalEntity> getTaskStakeholders(String taskId);
}
