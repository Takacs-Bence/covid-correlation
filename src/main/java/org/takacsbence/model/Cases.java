package org.takacsbence.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cases {

    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("deaths")
    @Expose
    private Long deaths;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("population")
    @Expose
    private Long population;
    @SerializedName("sq_km_area")
    @Expose
    private Double sqKmArea;
    @SerializedName("life_expectancy")
    @Expose
    private String lifeExpectancy;
    @SerializedName("elevation_in_meters")
    private Double elevationInMeters;
    @SerializedName("continent")
    @Expose
    private String continent;
    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("iso")
    @Expose
    private Integer iso;
    @SerializedName("capital_city")
    @Expose
    private String capitalCity;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("updated")
    @Expose
    private String updated;

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Long getDeaths() {
        return deaths;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getSqKmArea() {
        return sqKmArea;
    }

    public void setSqKmArea(Double sqKmArea) {
        this.sqKmArea = sqKmArea;
    }

    public String getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(String lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Double getElevationInMeters() {
        return elevationInMeters;
    }

    public void setElevationInMeters(Double elevationInMeters) {
        this.elevationInMeters = elevationInMeters;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getIso() {
        return iso;
    }

    public void setIso(Integer iso) {
        this.iso = iso;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Cases{" +
                "confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", sqKmArea=" + sqKmArea +
                ", lifeExpectancy='" + lifeExpectancy + '\'' +
                ", elevationInMeters=" + elevationInMeters +
                ", continent='" + continent + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", location='" + location + '\'' +
                ", iso=" + iso +
                ", capitalCity='" + capitalCity + '\'' +
                ", lat='" + lat + '\'' +
                ", _long='" + _long + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}