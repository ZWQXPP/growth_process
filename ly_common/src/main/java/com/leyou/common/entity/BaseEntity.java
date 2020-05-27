package com.leyou.common.entity;


import com.leyou.common.utils.DateUtils;
import com.leyou.common.utils.StringUtils;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="SELECT REPLACE(UUID(),'-','')")
    private String id;

    private Date createdTime;

    private String createdBy;

    private Date updatedTime;

    private String updatedBy;

    private Boolean deleted;

    @Transient
    private Date startTm;
    @Transient
    private Date endTm;
    @Transient
    private String sortName;
    @Transient
    private String sortOrder;


    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getStartTm() {
        return startTm;
    }

    public void setStartTm(Date startTm) {
        this.startTm = startTm;
    }

    public Date getEndTm() {
        return endTm;
    }

    public void setEndTm(Date endTm) {
        try {
            this.endTm = DateUtils.getDateEnd(endTm);
        } catch (Exception e) {
            this.endTm = endTm;
        }
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = StringUtils.humpToUnderLine(sortName);
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
