package com.bpm4sb.process.domain.model.task;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ianache
 */
public class TaskQueryResultSet {
    private List<TaskQueryResultRow> rows = new ArrayList<>();

    public TaskQueryResultSet() {
    }

    public List<TaskQueryResultRow> getRows() {
        return rows;
    }

    public void setRows(List<TaskQueryResultRow> rows) {
        this.rows = rows;
    }
    
    public Integer getRowsCount() {
        return rows.size();
    }
}
