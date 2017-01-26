package com.springinaction.spitter.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class Spittle {
    private Long id;

    @NotEmpty(message = "Message should not be empty")
    private String message;

    private Date time;
    private Double latitude;
    private Double longitude;

    private static final double DEFAULT_LATITUDE = 50.5132878;
    private static final double DEFAULT_LONGITUDE = 30.7987535;

    public Spittle() {
        this.time = new Date();
        this.latitude = DEFAULT_LATITUDE;
        this.longitude = DEFAULT_LONGITUDE;
    }

    public Spittle(String message) {
        this();
        this.message = message;
    }

    public Spittle(String message, Date time) {
        this(message);
        this.time = time;
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this(message, time);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(Long id, String message, Date time, Double latitude, Double longitude) {
        this(message, time, latitude, longitude);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Spittle setId(Long id) {
        this.id = id;
        return this;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spittle spittle = (Spittle) o;

        if (id != null ? !id.equals(spittle.id) : spittle.id != null) return false;
        return time != null ? time.equals(spittle.time) : spittle.time == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
