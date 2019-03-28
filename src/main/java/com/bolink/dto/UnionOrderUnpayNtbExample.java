package com.bolink.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UnionOrderUnpayNtbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnionOrderUnpayNtbExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIsNull() {
            addCriterion("plate_number is null");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIsNotNull() {
            addCriterion("plate_number is not null");
            return (Criteria) this;
        }

        public Criteria andPlateNumberEqualTo(String value) {
            addCriterion("plate_number =", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotEqualTo(String value) {
            addCriterion("plate_number <>", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberGreaterThan(String value) {
            addCriterion("plate_number >", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("plate_number >=", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLessThan(String value) {
            addCriterion("plate_number <", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLessThanOrEqualTo(String value) {
            addCriterion("plate_number <=", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLike(String value) {
            addCriterion("plate_number like", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotLike(String value) {
            addCriterion("plate_number not like", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIn(List<String> values) {
            addCriterion("plate_number in", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotIn(List<String> values) {
            addCriterion("plate_number not in", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberBetween(String value1, String value2) {
            addCriterion("plate_number between", value1, value2, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotBetween(String value1, String value2) {
            addCriterion("plate_number not between", value1, value2, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Long value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Long value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Long value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Long value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Long value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Long> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Long> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Long value1, Long value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Long value1, Long value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Long value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Long value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Long value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Long value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Long value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Long> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Long> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Long value1, Long value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Long value1, Long value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andUnionIdIsNull() {
            addCriterion("union_id is null");
            return (Criteria) this;
        }

        public Criteria andUnionIdIsNotNull() {
            addCriterion("union_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnionIdEqualTo(Long value) {
            addCriterion("union_id =", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotEqualTo(Long value) {
            addCriterion("union_id <>", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThan(Long value) {
            addCriterion("union_id >", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("union_id >=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThan(Long value) {
            addCriterion("union_id <", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThanOrEqualTo(Long value) {
            addCriterion("union_id <=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdIn(List<Long> values) {
            addCriterion("union_id in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotIn(List<Long> values) {
            addCriterion("union_id not in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdBetween(Long value1, Long value2) {
            addCriterion("union_id between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotBetween(Long value1, Long value2) {
            addCriterion("union_id not between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(BigDecimal value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(BigDecimal value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(BigDecimal value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(BigDecimal value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<BigDecimal> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<BigDecimal> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total not between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNull() {
            addCriterion("park_id is null");
            return (Criteria) this;
        }

        public Criteria andParkIdIsNotNull() {
            addCriterion("park_id is not null");
            return (Criteria) this;
        }

        public Criteria andParkIdEqualTo(String value) {
            addCriterion("park_id =", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotEqualTo(String value) {
            addCriterion("park_id <>", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThan(String value) {
            addCriterion("park_id >", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdGreaterThanOrEqualTo(String value) {
            addCriterion("park_id >=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThan(String value) {
            addCriterion("park_id <", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLessThanOrEqualTo(String value) {
            addCriterion("park_id <=", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdLike(String value) {
            addCriterion("park_id like", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotLike(String value) {
            addCriterion("park_id not like", value, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdIn(List<String> values) {
            addCriterion("park_id in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotIn(List<String> values) {
            addCriterion("park_id not in", values, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdBetween(String value1, String value2) {
            addCriterion("park_id between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andParkIdNotBetween(String value1, String value2) {
            addCriterion("park_id not between", value1, value2, "parkId");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNull() {
            addCriterion("local_id is null");
            return (Criteria) this;
        }

        public Criteria andLocalIdIsNotNull() {
            addCriterion("local_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocalIdEqualTo(String value) {
            addCriterion("local_id =", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotEqualTo(String value) {
            addCriterion("local_id <>", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThan(String value) {
            addCriterion("local_id >", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdGreaterThanOrEqualTo(String value) {
            addCriterion("local_id >=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThan(String value) {
            addCriterion("local_id <", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLessThanOrEqualTo(String value) {
            addCriterion("local_id <=", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdLike(String value) {
            addCriterion("local_id like", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotLike(String value) {
            addCriterion("local_id not like", value, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdIn(List<String> values) {
            addCriterion("local_id in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotIn(List<String> values) {
            addCriterion("local_id not in", values, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdBetween(String value1, String value2) {
            addCriterion("local_id between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andLocalIdNotBetween(String value1, String value2) {
            addCriterion("local_id not between", value1, value2, "localId");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeIsNull() {
            addCriterion("free_out_time is null");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeIsNotNull() {
            addCriterion("free_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeEqualTo(Integer value) {
            addCriterion("free_out_time =", value, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeNotEqualTo(Integer value) {
            addCriterion("free_out_time <>", value, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeGreaterThan(Integer value) {
            addCriterion("free_out_time >", value, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_out_time >=", value, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeLessThan(Integer value) {
            addCriterion("free_out_time <", value, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeLessThanOrEqualTo(Integer value) {
            addCriterion("free_out_time <=", value, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeIn(List<Integer> values) {
            addCriterion("free_out_time in", values, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeNotIn(List<Integer> values) {
            addCriterion("free_out_time not in", values, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeBetween(Integer value1, Integer value2) {
            addCriterion("free_out_time between", value1, value2, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andFreeOutTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("free_out_time not between", value1, value2, "freeOutTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeIsNull() {
            addCriterion("query_time is null");
            return (Criteria) this;
        }

        public Criteria andQueryTimeIsNotNull() {
            addCriterion("query_time is not null");
            return (Criteria) this;
        }

        public Criteria andQueryTimeEqualTo(Long value) {
            addCriterion("query_time =", value, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeNotEqualTo(Long value) {
            addCriterion("query_time <>", value, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeGreaterThan(Long value) {
            addCriterion("query_time >", value, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("query_time >=", value, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeLessThan(Long value) {
            addCriterion("query_time <", value, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeLessThanOrEqualTo(Long value) {
            addCriterion("query_time <=", value, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeIn(List<Long> values) {
            addCriterion("query_time in", values, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeNotIn(List<Long> values) {
            addCriterion("query_time not in", values, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeBetween(Long value1, Long value2) {
            addCriterion("query_time between", value1, value2, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryTimeNotBetween(Long value1, Long value2) {
            addCriterion("query_time not between", value1, value2, "queryTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeIsNull() {
            addCriterion("query_price_time is null");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeIsNotNull() {
            addCriterion("query_price_time is not null");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeEqualTo(Long value) {
            addCriterion("query_price_time =", value, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeNotEqualTo(Long value) {
            addCriterion("query_price_time <>", value, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeGreaterThan(Long value) {
            addCriterion("query_price_time >", value, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("query_price_time >=", value, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeLessThan(Long value) {
            addCriterion("query_price_time <", value, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeLessThanOrEqualTo(Long value) {
            addCriterion("query_price_time <=", value, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeIn(List<Long> values) {
            addCriterion("query_price_time in", values, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeNotIn(List<Long> values) {
            addCriterion("query_price_time not in", values, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeBetween(Long value1, Long value2) {
            addCriterion("query_price_time between", value1, value2, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andQueryPriceTimeNotBetween(Long value1, Long value2) {
            addCriterion("query_price_time not between", value1, value2, "queryPriceTime");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyIsNull() {
            addCriterion("derate_money is null");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyIsNotNull() {
            addCriterion("derate_money is not null");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyEqualTo(BigDecimal value) {
            addCriterion("derate_money =", value, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyNotEqualTo(BigDecimal value) {
            addCriterion("derate_money <>", value, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyGreaterThan(BigDecimal value) {
            addCriterion("derate_money >", value, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("derate_money >=", value, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyLessThan(BigDecimal value) {
            addCriterion("derate_money <", value, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("derate_money <=", value, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyIn(List<BigDecimal> values) {
            addCriterion("derate_money in", values, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyNotIn(List<BigDecimal> values) {
            addCriterion("derate_money not in", values, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("derate_money between", value1, value2, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("derate_money not between", value1, value2, "derateMoney");
            return (Criteria) this;
        }

        public Criteria andDerateDurationIsNull() {
            addCriterion("derate_duration is null");
            return (Criteria) this;
        }

        public Criteria andDerateDurationIsNotNull() {
            addCriterion("derate_duration is not null");
            return (Criteria) this;
        }

        public Criteria andDerateDurationEqualTo(Integer value) {
            addCriterion("derate_duration =", value, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationNotEqualTo(Integer value) {
            addCriterion("derate_duration <>", value, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationGreaterThan(Integer value) {
            addCriterion("derate_duration >", value, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("derate_duration >=", value, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationLessThan(Integer value) {
            addCriterion("derate_duration <", value, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationLessThanOrEqualTo(Integer value) {
            addCriterion("derate_duration <=", value, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationIn(List<Integer> values) {
            addCriterion("derate_duration in", values, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationNotIn(List<Integer> values) {
            addCriterion("derate_duration not in", values, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationBetween(Integer value1, Integer value2) {
            addCriterion("derate_duration between", value1, value2, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andDerateDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("derate_duration not between", value1, value2, "derateDuration");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoIsNull() {
            addCriterion("query_order_no is null");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoIsNotNull() {
            addCriterion("query_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoEqualTo(String value) {
            addCriterion("query_order_no =", value, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoNotEqualTo(String value) {
            addCriterion("query_order_no <>", value, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoGreaterThan(String value) {
            addCriterion("query_order_no >", value, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("query_order_no >=", value, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoLessThan(String value) {
            addCriterion("query_order_no <", value, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoLessThanOrEqualTo(String value) {
            addCriterion("query_order_no <=", value, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoLike(String value) {
            addCriterion("query_order_no like", value, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoNotLike(String value) {
            addCriterion("query_order_no not like", value, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoIn(List<String> values) {
            addCriterion("query_order_no in", values, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoNotIn(List<String> values) {
            addCriterion("query_order_no not in", values, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoBetween(String value1, String value2) {
            addCriterion("query_order_no between", value1, value2, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andQueryOrderNoNotBetween(String value1, String value2) {
            addCriterion("query_order_no not between", value1, value2, "queryOrderNo");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdIsNull() {
            addCriterion("out_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdIsNotNull() {
            addCriterion("out_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdEqualTo(String value) {
            addCriterion("out_channel_id =", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdNotEqualTo(String value) {
            addCriterion("out_channel_id <>", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdGreaterThan(String value) {
            addCriterion("out_channel_id >", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_channel_id >=", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdLessThan(String value) {
            addCriterion("out_channel_id <", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdLessThanOrEqualTo(String value) {
            addCriterion("out_channel_id <=", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdLike(String value) {
            addCriterion("out_channel_id like", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdNotLike(String value) {
            addCriterion("out_channel_id not like", value, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdIn(List<String> values) {
            addCriterion("out_channel_id in", values, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdNotIn(List<String> values) {
            addCriterion("out_channel_id not in", values, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdBetween(String value1, String value2) {
            addCriterion("out_channel_id between", value1, value2, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andOutChannelIdNotBetween(String value1, String value2) {
            addCriterion("out_channel_id not between", value1, value2, "outChannelId");
            return (Criteria) this;
        }

        public Criteria andErrmsgIsNull() {
            addCriterion("errmsg is null");
            return (Criteria) this;
        }

        public Criteria andErrmsgIsNotNull() {
            addCriterion("errmsg is not null");
            return (Criteria) this;
        }

        public Criteria andErrmsgEqualTo(String value) {
            addCriterion("errmsg =", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotEqualTo(String value) {
            addCriterion("errmsg <>", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgGreaterThan(String value) {
            addCriterion("errmsg >", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgGreaterThanOrEqualTo(String value) {
            addCriterion("errmsg >=", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLessThan(String value) {
            addCriterion("errmsg <", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLessThanOrEqualTo(String value) {
            addCriterion("errmsg <=", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgLike(String value) {
            addCriterion("errmsg like", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotLike(String value) {
            addCriterion("errmsg not like", value, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgIn(List<String> values) {
            addCriterion("errmsg in", values, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotIn(List<String> values) {
            addCriterion("errmsg not in", values, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgBetween(String value1, String value2) {
            addCriterion("errmsg between", value1, value2, "errmsg");
            return (Criteria) this;
        }

        public Criteria andErrmsgNotBetween(String value1, String value2) {
            addCriterion("errmsg not between", value1, value2, "errmsg");
            return (Criteria) this;
        }

        public Criteria andStopPositionIsNull() {
            addCriterion("stop_position is null");
            return (Criteria) this;
        }

        public Criteria andStopPositionIsNotNull() {
            addCriterion("stop_position is not null");
            return (Criteria) this;
        }

        public Criteria andStopPositionEqualTo(String value) {
            addCriterion("stop_position =", value, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionNotEqualTo(String value) {
            addCriterion("stop_position <>", value, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionGreaterThan(String value) {
            addCriterion("stop_position >", value, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionGreaterThanOrEqualTo(String value) {
            addCriterion("stop_position >=", value, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionLessThan(String value) {
            addCriterion("stop_position <", value, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionLessThanOrEqualTo(String value) {
            addCriterion("stop_position <=", value, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionLike(String value) {
            addCriterion("stop_position like", value, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionNotLike(String value) {
            addCriterion("stop_position not like", value, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionIn(List<String> values) {
            addCriterion("stop_position in", values, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionNotIn(List<String> values) {
            addCriterion("stop_position not in", values, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionBetween(String value1, String value2) {
            addCriterion("stop_position between", value1, value2, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andStopPositionNotBetween(String value1, String value2) {
            addCriterion("stop_position not between", value1, value2, "stopPosition");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoIsNull() {
            addCriterion("hide_inpark_info is null");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoIsNotNull() {
            addCriterion("hide_inpark_info is not null");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoEqualTo(Integer value) {
            addCriterion("hide_inpark_info =", value, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoNotEqualTo(Integer value) {
            addCriterion("hide_inpark_info <>", value, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoGreaterThan(Integer value) {
            addCriterion("hide_inpark_info >", value, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("hide_inpark_info >=", value, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoLessThan(Integer value) {
            addCriterion("hide_inpark_info <", value, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoLessThanOrEqualTo(Integer value) {
            addCriterion("hide_inpark_info <=", value, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoIn(List<Integer> values) {
            addCriterion("hide_inpark_info in", values, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoNotIn(List<Integer> values) {
            addCriterion("hide_inpark_info not in", values, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoBetween(Integer value1, Integer value2) {
            addCriterion("hide_inpark_info between", value1, value2, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andHideInparkInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("hide_inpark_info not between", value1, value2, "hideInparkInfo");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNull() {
            addCriterion("pic_url is null");
            return (Criteria) this;
        }

        public Criteria andPicUrlIsNotNull() {
            addCriterion("pic_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            addCriterion("pic_url =", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            addCriterion("pic_url <>", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            addCriterion("pic_url >", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_url >=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThan(String value) {
            addCriterion("pic_url <", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_url <=", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlLike(String value) {
            addCriterion("pic_url like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotLike(String value) {
            addCriterion("pic_url not like", value, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlIn(List<String> values) {
            addCriterion("pic_url in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            addCriterion("pic_url not in", values, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria) this;
        }

        public Criteria andSubNumberIsNull() {
            addCriterion("sub_number is null");
            return (Criteria) this;
        }

        public Criteria andSubNumberIsNotNull() {
            addCriterion("sub_number is not null");
            return (Criteria) this;
        }

        public Criteria andSubNumberEqualTo(String value) {
            addCriterion("sub_number =", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberNotEqualTo(String value) {
            addCriterion("sub_number <>", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberGreaterThan(String value) {
            addCriterion("sub_number >", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberGreaterThanOrEqualTo(String value) {
            addCriterion("sub_number >=", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberLessThan(String value) {
            addCriterion("sub_number <", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberLessThanOrEqualTo(String value) {
            addCriterion("sub_number <=", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberLike(String value) {
            addCriterion("sub_number like", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberNotLike(String value) {
            addCriterion("sub_number not like", value, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberIn(List<String> values) {
            addCriterion("sub_number in", values, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberNotIn(List<String> values) {
            addCriterion("sub_number not in", values, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberBetween(String value1, String value2) {
            addCriterion("sub_number between", value1, value2, "subNumber");
            return (Criteria) this;
        }

        public Criteria andSubNumberNotBetween(String value1, String value2) {
            addCriterion("sub_number not between", value1, value2, "subNumber");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyIsNull() {
            addCriterion("prepay_money is null");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyIsNotNull() {
            addCriterion("prepay_money is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyEqualTo(BigDecimal value) {
            addCriterion("prepay_money =", value, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("prepay_money <>", value, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyGreaterThan(BigDecimal value) {
            addCriterion("prepay_money >", value, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("prepay_money >=", value, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyLessThan(BigDecimal value) {
            addCriterion("prepay_money <", value, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("prepay_money <=", value, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyIn(List<BigDecimal> values) {
            addCriterion("prepay_money in", values, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("prepay_money not in", values, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prepay_money between", value1, value2, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andPrepayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("prepay_money not between", value1, value2, "prepayMoney");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayIsNull() {
            addCriterion("multiple_prepay is null");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayIsNotNull() {
            addCriterion("multiple_prepay is not null");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayEqualTo(Integer value) {
            addCriterion("multiple_prepay =", value, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayNotEqualTo(Integer value) {
            addCriterion("multiple_prepay <>", value, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayGreaterThan(Integer value) {
            addCriterion("multiple_prepay >", value, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayGreaterThanOrEqualTo(Integer value) {
            addCriterion("multiple_prepay >=", value, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayLessThan(Integer value) {
            addCriterion("multiple_prepay <", value, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayLessThanOrEqualTo(Integer value) {
            addCriterion("multiple_prepay <=", value, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayIn(List<Integer> values) {
            addCriterion("multiple_prepay in", values, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayNotIn(List<Integer> values) {
            addCriterion("multiple_prepay not in", values, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayBetween(Integer value1, Integer value2) {
            addCriterion("multiple_prepay between", value1, value2, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andMultiplePrepayNotBetween(Integer value1, Integer value2) {
            addCriterion("multiple_prepay not between", value1, value2, "multiplePrepay");
            return (Criteria) this;
        }

        public Criteria andDeductionIsNull() {
            addCriterion("deduction is null");
            return (Criteria) this;
        }

        public Criteria andDeductionIsNotNull() {
            addCriterion("deduction is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionEqualTo(BigDecimal value) {
            addCriterion("deduction =", value, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionNotEqualTo(BigDecimal value) {
            addCriterion("deduction <>", value, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionGreaterThan(BigDecimal value) {
            addCriterion("deduction >", value, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction >=", value, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionLessThan(BigDecimal value) {
            addCriterion("deduction <", value, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction <=", value, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionIn(List<BigDecimal> values) {
            addCriterion("deduction in", values, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionNotIn(List<BigDecimal> values) {
            addCriterion("deduction not in", values, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction between", value1, value2, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction not between", value1, value2, "deduction");
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