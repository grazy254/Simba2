package com.simba.model.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linshuo on 2017/12/6.
 * <p>
 * 短信模板审核状态
 */
public enum AuditStatus {
    UNAPPROVAL(0, "审核不过"),
    APPROVAL(1, "已审核"),
    AUDITING(2, "审核中"),
    NONE(3, "无");

    private int id;
    private String description;
    private static Map<Integer, String> statusMap = new HashMap<>();

    static {
        for (AuditStatus status : AuditStatus.values()) {
            statusMap.put(status.getId(), status.getDescription());
        }
    }

    AuditStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String getById(int id) {
        return statusMap.get(id);
    }
}
