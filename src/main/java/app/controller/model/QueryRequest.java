package app.controller.model;

import java.util.Map;

public class QueryRequest {
    private String queryType;
    private Map<String, Object> queryData;
    private int page;
    private int recordsPerPage;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public Map<String, Object> getQueryData() {
        return queryData;
    }

    public void setQueryData(Map<String, Object> queryData) {
        this.queryData = queryData;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }
}
