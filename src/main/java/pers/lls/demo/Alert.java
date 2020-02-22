package pers.lls.demo;

import com.alibaba.fastjson.annotation.JSONField;
import com.esotericsoftware.kryo.DefaultSerializer;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import uyun.indian.entity.ExtendProperty;
import uyun.indian.entity.Tag;

import java.io.Serializable;
import java.util.*;

/**
 * 告警实体类 在 Alert系统中，称之为 Incident
 * <p>
 * Created by xuyh at 2017年3月8日 上午9:46:22
 */
@DefaultSerializer(CompatibleFieldSerializer.class)
@Document(collection = "Alert")
public class Alert implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String FIELD_MD5_CODE_ID = "_id";
    public static String FIELD_CODE_ID = "id";
    public static String FIELD_CODE_TENANT = "tenant";
    public static String FIELD_CODE_NAME = "name";
    public static String FIELD_CODE_ALIAS = "alias";
    public static String FIELD_CODE_PARENT_ID = "parentId";
    public static String FIELD_CODE_SUB_NUM = "subNum";
    public static String FIELD_CODE_SEVERITY = "severity";
    public static String FIELD_CODE_SOURCE = "source";
    public static String FIELD_CODE_STATUS = "status";
    public static String FIELD_CODE_ENTITY_NAME = "entityName";
    public static String FIELD_CODE_ENTITY_ADDR = "entityAddr";
    public static String FIELD_CODE_COUNT = "count";
    public static String FIELD_CODE_CREATE_TIME = "createTime";
    public static String FIELD_CODE_FIRST_OCCUR_TIME = "firstOccurTime";
    public static String FIELD_CODE_LAST_OCCUR_TIME = "lastOccurTime";
    public static String FIELD_CODE_DESCRIPTION = "description";
    public static String FIELD_CODE_DISCRIMINATION = "discrimination";
    public static String FIELD_CODE_MERGE_KEY = "mergeKey";
    public static String FIELD_CODE_IDENTIFY_KEY = "identifyKey";
    public static String FIELD_CODE_ORDER_ID = "orderId";
    public static String FIELD_CODE_ORDER_FLOW_Num = "orderFlowNum";
    public static String FIELD_CODE_IS_NOTIFY = "isNotify";
    public static String FIELD_CODE_NOTIFY_LIST = "notifyList";
    //    public static String FIELD_CODE_CUSTOM_NOTIFY_LIST = "customNotifyList";
    public static String FIELD_CODE_RESOLVE_MESSAGE = "resolveMessage";
    public static String FIELD_CODE_CLOSE_MESSAGE = "closeMessage";
    public static String FIELD_CODE_REMARK = "remark";
    public static String FIELD_CODE_SHARED = "shared";
    public static String FIELD_CODE_PROPERTIES = "properties";
    public static String FIELD_CODE_PROPERTIE_CODE = "properties.code";
    public static String FIELD_CODE_PROPERTIE_NAME = "properties.name";
    public static String FIELD_CODE_PROPERTIE_VAL = "properties.val";
    public static String FIELD_CODE_TAGS = "tags";
    public static String FIELD_CODE_TAGS_CODE = "tags.key";
    public static String FIELD_CODE_TAGS_NAME = "tags.keyName";
    public static String FIELD_CODE_TAGS_VALUE = "tags.value";
    public static String FIELD_CODE_TAGS_KV = "tags.tagKV";
    public static String FIELD_CODE_RES_OBJECT_ID = "resObjectId";
    public static String FIELD_CODE_CLASS_CODE = "classCode";
    public static String FIELD_CODE_APP_KEY = "appKey";
    public static String FIELD_CODE_COSS_FLOW_ID = "cossFlowId";
    public static String FIELD_CODE_CLOSE_TIME = "closeTime";
    public static String FIELD_CODE_OWNER = "owner";
    public static String FIELD_CODE_SUPPRESSION_FLAG = "suppressionFlag";
    public static String FIELD_CODE_CHILDREN = "children";
    public static String FIELD_CODE_HASPARENT = "hasParent";
    public static String FIELD_CODE_JOB_LIST = "jobList";
    public static String FIELD_CODE_JOBIDS = "jobIds";
    public static String FIELD_CODE_AUTOSTATUS = "autoStatus";
    public static String FIELD_CODE_TILE_IDS = "tileIds.key";
    public static String FIELD_CODE_RULE_IDS = "ruleIds";
    public static String FIELD_CODE_CIPROPERTIES = "ciProperties";
    public static String FIELD_CODE_PREVIOUS_SEVERITY = "previousSeverity";
    public static String FIELD_CODE_EVENT_LIST = "eventList";
    public static String FIELD_CODE_TYPE = "type";

    @Id
    private String _id; // 故障id(MD5处理)

    private String id; // 故障id(原UUID)

    @Indexed
    private String tenant;// 租户id

    private String name;// 故障名称
    private String alias;// 故障显示名

    private String parentId = null;// 合并故障的父故障id

    @Indexed
    private int subNum = 0;// 子故障数量

    @Indexed
    private int severity;// 最后一次发生故障时的严重性等级，等级定义请参考{@link Severity}，不包括恢复等级

    @Indexed
    private int previousSeverity;// 上一次故障级别

    private String source;// 来源系统
    @Indexed
    private int status;// 故障状态，状态定义详情请参考{@link AlertStatus}

    private String entityName;// 故障发生源名称

    private String entityAddr;// 故障发生源地址,一般情况下为IP address
    @Indexed
    private int count;// 故障发生次数
    @Indexed
    private Long firstOccurTime;// 故障首次发生时间
    @Indexed
    private Long lastOccurTime;// 故障最后一次发生时间，最后一次发生时间不包含故障恢复故障

    private Long closeTime;// 故障关闭时间

    private String description;// 故障描述

    @Indexed
    private String discrimination;// 故障标识

    @Indexed
    private String mergeKey;// 压缩字段key

    private String identifyKey;// 丰富字段key

    private String orderId;// 故障所关联的工单ID

    private String orderFlowNum;//故障所关联的工单流水号(详情展示)

    private String cossFlowId;

    private String resolveMessage;// 故障解决信息

    private String closeMessage;// 故障关闭信息

    private String remark;// 备注

    private boolean shared;// 是否分享

    private boolean isNotify; //是否通知

    private Set<String> notifyList; //通知方式:EMAIL(1, "电子邮件"), SMS(2, "短信"), CHATOPS_PRIVATE(3, "Chatops私聊"),其它值从notify中获取（即获取notify动作）

//    private Set<Integer> notifyList; //通知方式:EMAIL(1, "电子邮件"), SMS(2, "短信"), CHATOPS_PRIVATE(3, "Chatops私聊")

//    private Set<String> customNotifyList;//自定义通知方式（通知方式从notify模块获取）

    @Indexed
    private String resObjectId;//对应统一资源库的资源ID

    private String classCode;//对应store的资源类型

    private List<Map<String, Object>> properties;//故障扩展属性

    private List<ExtendProperty> ciProperties;//从定位的CI丰富到的属性

    private List<Tag> tags;// 故障关联的标签

    @Indexed
    private String appKey;
    @Indexed
    private String owner;//责任人

    private Boolean suppressionFlag = false;//是否被抑制

    private HashSet<String> children; //子告警ID


    @Indexed
    private Boolean hasParent = false;//是否有父告警(默认没有)

    private List<String> jobList;//auto的作业id

    private int autoStatus;

    private Set<String> tileIds;//磁贴ID列表

    private Set<String> eventList;//事件ID集合

    private String type = "event";//告警类型

    public Set<String> getEventList() {
        return eventList;
    }

    public void setEventList(Set<String> eventList) {
        this.eventList = eventList;
    }

    /**
     * 所执行过的规则列表
     *
     * @author Xin Fang
     * @date 2018年1月24日 下午4:19
     * @since R13.1
     */
    private Set<String> ruleIds;

    @JSONField(name="_id")
    public String get_id() {
        return _id;
    }

    @JSONField(name="_id")
    public void set_id(String _id) {
        this._id = _id;
    }

    public int getAutoStatus() {
        return autoStatus;
    }

    public void setAutoStatus(int autoStatus) {
        this.autoStatus = autoStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMergeKey() {
        return mergeKey;
    }

    public void setMergeKey(String mergeKey) {
        this.mergeKey = mergeKey;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getPreviousSeverity() {
        return previousSeverity;
    }

    public void setPreviousSeverity(int previousSeverity) {
        this.previousSeverity = previousSeverity;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityAddr() {
        return entityAddr;
    }

    public void setEntityAddr(String entityAddr) {
        this.entityAddr = entityAddr;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscrimination() {
        return discrimination;
    }

    public void setDiscrimination(String discrimination) {
        this.discrimination = discrimination;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResolveMessage() {
        return resolveMessage;
    }

    public void setResolveMessage(String resolveMessage) {
        this.resolveMessage = resolveMessage;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public List<Map<String, Object>> getProperties() {
        return properties;
    }

    public void setProperties(List<Map<String, Object>> properties) {
        this.properties = properties;
    }

    public boolean isNotify() {
        return isNotify;
    }

    public void setNotify(boolean notify) {
        isNotify = notify;
    }

    public HashSet<String> getChildren() {
        return children;
    }

    public void setChildren(HashSet<String> children) {
        this.children = children;
    }

    public Boolean getHasParent() {
        return hasParent;
    }

    public void setHasParent(Boolean hasParent) {
        this.hasParent = hasParent;
    }

    public List<ExtendProperty> getCiProperties() {
        return ciProperties;
    }

    public void setCiProperties(List<ExtendProperty> ciProperties) {
        this.ciProperties = ciProperties;
    }

    public void addProperty(Map<String, Object> property) {
        if (this.properties == null || this.properties.isEmpty()) {
            this.properties = new ArrayList<>();
        }
        this.properties.add(property);
    }

    public boolean getIsNotify() {
        return isNotify;
    }

    public void setIsNotify(boolean notify) {
        isNotify = notify;
    }

//    public Set<Integer> getNotifyList() {
//        if (notifyList == null) {
//            notifyList = new HashSet<>();
//        }
//        return notifyList;
//    }
//
//    public void setNotifyList(Set<Integer> notifyList) {
//        this.notifyList = notifyList;
//    }

    public Set<String> getNotifyList() {
        if (notifyList == null) {
            notifyList = new HashSet<>();
        }
        return notifyList;
    }

    public void setNotifyList(Set<String> notifyList) {
        this.notifyList = notifyList;
    }

    public void addProperty(String code, String name, Object val) {
        if (this.properties == null || this.properties.isEmpty()) {
            this.properties = new ArrayList<>();
        }
        Map<String, Object> property = new HashMap<>();
        property.put("code", code);
        property.put("name", name);
        property.put("val", val);
        this.properties.add(property);
    }

    public void removeProperty(Map<String, Object> property) {
        if (this.properties != null && !this.properties.isEmpty()) {
            this.properties.remove(property);
        }
    }

    public void removeProperty(String code, String name) {
        if (this.properties != null && !this.properties.isEmpty()) {
            for (Map<String, Object> property : properties) {
                String innerCode = (String) property.get("code");
                String innerName = (String) property.get("name");
                if (innerCode.equals(code) && innerName.equals(name)) {
                    properties.remove(property);
                    break;
                }
            }//end foreach
        }
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        if (this.tags == null || this.tags.isEmpty()) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tag);
    }

    public void removeTag(Tag tag) {
        if (this.tags != null && !this.tags.isEmpty()) {
            this.tags.remove(tag);
        }
    }

    public Set<String> getTileIds() {
        return tileIds;
    }

    public void setTileIds(Set<String> tileIds) {
        this.tileIds = tileIds;
    }

    public void addTileId(String tileId) {
        if (tileIds == null)
            tileIds = new HashSet<>();
        tileIds.add(tileId);
    }

    public void removeTileId(String tileId) {
        if (tileIds == null)
            return;
        if (tileIds.contains(tileId))
            tileIds.remove(tileId);
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getResObjectId() {
        return resObjectId;
    }

    public void setResObjectId(String resObjectId) {
        this.resObjectId = resObjectId;
    }

    public String getOrderFlowNum() {
        return orderFlowNum;
    }

    public void setOrderFlowNum(String orderFlowNum) {
        this.orderFlowNum = orderFlowNum;
    }

    public String getCloseMessage() {
        return closeMessage;
    }

    public void setCloseMessage(String closeMessage) {
        this.closeMessage = closeMessage;
    }

    public String getCossFlowId() {
        return cossFlowId;
    }

    public void setCossFlowId(String cossFlowId) {
        this.cossFlowId = cossFlowId;
    }

    public String getIdentifyKey() {
        return identifyKey;
    }

    public void setIdentifyKey(String identifyKey) {
        this.identifyKey = identifyKey;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getSuppressionFlag() {
        return suppressionFlag;
    }

    public void setSuppressionFlag(Boolean suppressionFlag) {
        this.suppressionFlag = suppressionFlag;
    }

    public List<String> getJobList() {
        return jobList;
    }

    public void setJobList(List<String> jobList) {
        this.jobList = jobList;
    }

    public Set<String> getRuleIds() {
        return ruleIds;
    }

    public void setRuleIds(Set<String> ruleIds) {
        this.ruleIds = ruleIds;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id='" + id + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getFirstOccurTime() {
        return firstOccurTime;
    }

    public void setFirstOccurTime(Long firstOccurTime) {
        this.firstOccurTime = firstOccurTime;
    }

    public Long getLastOccurTime() {
        return lastOccurTime;
    }

    public void setLastOccurTime(Long lastOccurTime) {
        this.lastOccurTime = lastOccurTime;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Set<String> getCustomNotifyList() {
//        return customNotifyList;
//    }
//
//    public void setCustomNotifyList(Set<String> customNotifyList) {
//        this.customNotifyList = customNotifyList;
//    }
}
