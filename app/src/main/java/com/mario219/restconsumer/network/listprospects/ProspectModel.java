package com.mario219.restconsumer.network.listprospects;

/**
 * Created by marioalejndro on 29/06/17.
 */

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProspectModel implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("surname")
    @Expose
    private String surname;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("schProspectIdentification")
    @Expose
    private String schProspectIdentification;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("statusCd")
    @Expose
    private Integer statusCd;
    @SerializedName("zoneCode")
    @Expose
    private String zoneCode;
    @SerializedName("neighborhoodCode")
    @Expose
    private String neighborhoodCode;
    @SerializedName("cityCode")
    @Expose
    private String cityCode;
    @SerializedName("sectionCode")
    @Expose
    private String sectionCode;
    @SerializedName("roleId")
    @Expose
    private Integer roleId;
    @SerializedName("appointableId")
    @Expose
    private Object appointableId;
    @SerializedName("rejectedObservation")
    @Expose
    private Object rejectedObservation;
    @SerializedName("observation")
    @Expose
    private String observation;
    @SerializedName("disable")
    @Expose
    private Boolean disable;
    @SerializedName("visited")
    @Expose
    private Boolean visited;
    @SerializedName("callcenter")
    @Expose
    private Boolean callcenter;
    @SerializedName("acceptSearch")
    @Expose
    private Boolean acceptSearch;
    @SerializedName("campaignCode")
    @Expose
    private String campaignCode;
    @SerializedName("userId")
    @Expose
    private Object userId;

    public ProspectModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSchProspectIdentification() {
        return schProspectIdentification;
    }

    public void setSchProspectIdentification(String schProspectIdentification) {
        this.schProspectIdentification = schProspectIdentification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(Integer statusCd) {
        this.statusCd = statusCd;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getNeighborhoodCode() {
        return neighborhoodCode;
    }

    public void setNeighborhoodCode(String neighborhoodCode) {
        this.neighborhoodCode = neighborhoodCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Object getAppointableId() {
        return appointableId;
    }

    public void setAppointableId(Object appointableId) {
        this.appointableId = appointableId;
    }

    public Object getRejectedObservation() {
        return rejectedObservation;
    }

    public void setRejectedObservation(Object rejectedObservation) {
        this.rejectedObservation = rejectedObservation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public Boolean getCallcenter() {
        return callcenter;
    }

    public void setCallcenter(Boolean callcenter) {
        this.callcenter = callcenter;
    }

    public Boolean getAcceptSearch() {
        return acceptSearch;
    }

    public void setAcceptSearch(Boolean acceptSearch) {
        this.acceptSearch = acceptSearch;
    }

    public String getCampaignCode() {
        return campaignCode;
    }

    public void setCampaignCode(String campaignCode) {
        this.campaignCode = campaignCode;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeString(telephone);
        dest.writeString(schProspectIdentification);
        dest.writeString(address);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(zoneCode);
        dest.writeString(neighborhoodCode);
        dest.writeString(cityCode);
        dest.writeString(sectionCode);
        dest.writeString(observation);
        dest.writeString(campaignCode);
    }

    protected ProspectModel(Parcel in) {
        id = in.readString();
        name = in.readString();
        surname = in.readString();
        telephone = in.readString();
        schProspectIdentification = in.readString();
        address = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        zoneCode = in.readString();
        neighborhoodCode = in.readString();
        cityCode = in.readString();
        sectionCode = in.readString();
        observation = in.readString();
        campaignCode = in.readString();
    }

    public static final Creator<ProspectModel> CREATOR = new Creator<ProspectModel>() {
        @Override
        public ProspectModel createFromParcel(Parcel in) {
            return new ProspectModel(in);
        }

        @Override
        public ProspectModel[] newArray(int size) {
            return new ProspectModel[size];
        }
    };


}
