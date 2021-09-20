package com.example.nasaapibot.Model.MarsModel;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "sol",
        "camera",
        "img_src",
        "earth_date",
        "rover"
})
@Generated("jsonschema2pojo")
public class Photo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sol")
    private Integer sol;
    @JsonProperty("camera")
    private Camera camera;
    @JsonProperty("img_src")
    private String imgSrc;
    @JsonProperty("earth_date")
    private String earthDate;
    @JsonProperty("rover")
    private Rover rover;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Photo() {
    }

    /**
     *
     * @param sol
     * @param id
     * @param camera
     * @param earthDate
     * @param rover
     * @param imgSrc
     */
    public Photo(Integer id, Integer sol, Camera camera, String imgSrc, String earthDate, Rover rover) {
        super();
        this.id = id;
        this.sol = sol;
        this.camera = camera;
        this.imgSrc = imgSrc;
        this.earthDate = earthDate;
        this.rover = rover;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Photo withId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("sol")
    public Integer getSol() {
        return sol;
    }

    @JsonProperty("sol")
    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public Photo withSol(Integer sol) {
        this.sol = sol;
        return this;
    }

    @JsonProperty("camera")
    public Camera getCamera() {
        return camera;
    }

    @JsonProperty("camera")
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Photo withCamera(Camera camera) {
        this.camera = camera;
        return this;
    }

    @JsonProperty("img_src")
    public String getImgSrc() {
        return imgSrc;
    }

    @JsonProperty("img_src")
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Photo withImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
        return this;
    }

    @JsonProperty("earth_date")
    public String getEarthDate() {
        return earthDate;
    }

    @JsonProperty("earth_date")
    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public Photo withEarthDate(String earthDate) {
        this.earthDate = earthDate;
        return this;
    }

    @JsonProperty("rover")
    public Rover getRover() {
        return rover;
    }

    @JsonProperty("rover")
    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Photo withRover(Rover rover) {
        this.rover = rover;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Photo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}