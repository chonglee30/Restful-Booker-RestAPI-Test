package com.restful.zippo.data;
import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({"placeName", "longitude", "state", "stateAbbreviation", "latitude"})
public class Place {

	private String placeName;
    private String longitude;
    private String state;
    private String stateAbbreviation;
    private String latitude;

    //String name, String longG, String state, String stateAbb, String lat
    Place() {
//        this.placeNamename;             //"Riga";
//        this.longitude = longG;            //"1";
//        this.state = state;                //"Riga";
//        this.stateAbbreviation = stateAbb; //"RI";
//        this.latitude = lat;               //"1";
    }
    
    @JsonProperty("place name")
    public String getPlaceName() {
        return placeName;
    }

    @JsonProperty("place name")
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("state abbreviation")
    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    @JsonProperty("state abbreviation")
    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }
}