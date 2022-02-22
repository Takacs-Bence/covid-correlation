package org.takacsbence.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vaccines {

    @SerializedName("administered")
    @Expose
    private Long administered;
    @SerializedName("people_vaccinated")
    @Expose
    private Long peopleVaccinated;
    @SerializedName("people_partially_vaccinated")
    @Expose
    private Long peoplePartiallyVaccinated;
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
    private Integer elevationInMeters;
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

    public Long getAdministered() {
        return administered;
    }

    public void setAdministered(Long administered) {
        this.administered = administered;
    }

    public Long getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public void setPeopleVaccinated(Long peopleVaccinated) {
        this.peopleVaccinated = peopleVaccinated;
    }

    public Long getPeoplePartiallyVaccinated() {
        return peoplePartiallyVaccinated;
    }

    public void setPeoplePartiallyVaccinated(Long peoplePartiallyVaccinated) {
        this.peoplePartiallyVaccinated = peoplePartiallyVaccinated;
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

    public Integer getElevationInMeters() {
        return elevationInMeters;
    }

    public void setElevationInMeters(Integer elevationInMeters) {
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
        return "Vaccines{" +
                "administered=" + administered +
                ", peopleVaccinated=" + peopleVaccinated +
                ", peoplePartiallyVaccinated=" + peoplePartiallyVaccinated +
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