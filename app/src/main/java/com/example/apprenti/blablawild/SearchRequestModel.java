package com.example.apprenti.blablawild;


import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/**
 * Created by apprenti on 19/09/17.
 */

public class SearchRequestModel implements Parcelable {


    public String villedepart;
    public String villedestination;
    public Date datedepart;

    public SearchRequestModel(String villedepart, String villedestination, Date datedepart) {
        this.villedepart = villedepart;
        this.villedestination = villedestination;
        this.datedepart = datedepart;
    }

    public String getVilledepart() {
        return villedepart;
    }

    public void setVilledepart(String villedepart) {
        this.villedepart = villedepart;
    }

    public String getVilledestination() {
        return villedestination;
    }

    public void setVilledestination(String villedestination) {
        this.villedestination = villedestination;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(villedepart);
        dest.writeString(villedestination);
        dest.writeLong(datedepart.getTime());
    }

    public static final Parcelable.Creator<SearchRequestModel> CREATOR = new Parcelable.Creator<SearchRequestModel>()
    {
        @Override
        public SearchRequestModel createFromParcel(Parcel source)
        {
            return new SearchRequestModel(source);
        }

        @Override
        public SearchRequestModel[] newArray(int size)
        {
            return new SearchRequestModel[size];
        }
    };

    public SearchRequestModel(Parcel in) {
        this.villedepart = in.readString();
        this.villedestination = in.readString();
        datedepart = new Date(in.readLong());

    }





}
