package com.nit.city.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CameraExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CameraExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCameraIdIsNull() {
            addCriterion("camera_id is null");
            return (Criteria) this;
        }

        public Criteria andCameraIdIsNotNull() {
            addCriterion("camera_id is not null");
            return (Criteria) this;
        }

        public Criteria andCameraIdEqualTo(Integer value) {
            addCriterion("camera_id =", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotEqualTo(Integer value) {
            addCriterion("camera_id <>", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdGreaterThan(Integer value) {
            addCriterion("camera_id >", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("camera_id >=", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLessThan(Integer value) {
            addCriterion("camera_id <", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdLessThanOrEqualTo(Integer value) {
            addCriterion("camera_id <=", value, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdIn(List<Integer> values) {
            addCriterion("camera_id in", values, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotIn(List<Integer> values) {
            addCriterion("camera_id not in", values, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdBetween(Integer value1, Integer value2) {
            addCriterion("camera_id between", value1, value2, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraIdNotBetween(Integer value1, Integer value2) {
            addCriterion("camera_id not between", value1, value2, "cameraId");
            return (Criteria) this;
        }

        public Criteria andCameraNameIsNull() {
            addCriterion("camera_name is null");
            return (Criteria) this;
        }

        public Criteria andCameraNameIsNotNull() {
            addCriterion("camera_name is not null");
            return (Criteria) this;
        }

        public Criteria andCameraNameEqualTo(String value) {
            addCriterion("camera_name =", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameNotEqualTo(String value) {
            addCriterion("camera_name <>", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameGreaterThan(String value) {
            addCriterion("camera_name >", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameGreaterThanOrEqualTo(String value) {
            addCriterion("camera_name >=", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameLessThan(String value) {
            addCriterion("camera_name <", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameLessThanOrEqualTo(String value) {
            addCriterion("camera_name <=", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameLike(String value) {
            addCriterion("camera_name like", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameNotLike(String value) {
            addCriterion("camera_name not like", value, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameIn(List<String> values) {
            addCriterion("camera_name in", values, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameNotIn(List<String> values) {
            addCriterion("camera_name not in", values, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameBetween(String value1, String value2) {
            addCriterion("camera_name between", value1, value2, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCameraNameNotBetween(String value1, String value2) {
            addCriterion("camera_name not between", value1, value2, "cameraName");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdIsNull() {
            addCriterion("coordinate_id is null");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdIsNotNull() {
            addCriterion("coordinate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdEqualTo(Integer value) {
            addCriterion("coordinate_id =", value, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdNotEqualTo(Integer value) {
            addCriterion("coordinate_id <>", value, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdGreaterThan(Integer value) {
            addCriterion("coordinate_id >", value, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coordinate_id >=", value, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdLessThan(Integer value) {
            addCriterion("coordinate_id <", value, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdLessThanOrEqualTo(Integer value) {
            addCriterion("coordinate_id <=", value, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdIn(List<Integer> values) {
            addCriterion("coordinate_id in", values, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdNotIn(List<Integer> values) {
            addCriterion("coordinate_id not in", values, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdBetween(Integer value1, Integer value2) {
            addCriterion("coordinate_id between", value1, value2, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coordinate_id not between", value1, value2, "coordinateId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(Integer value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(Integer value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(Integer value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(Integer value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(Integer value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<Integer> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<Integer> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(Integer value1, Integer value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}