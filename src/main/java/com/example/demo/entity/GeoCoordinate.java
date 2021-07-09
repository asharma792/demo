package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.springframework.data.geo.Point;

@Embeddable
public class GeoCoordinate
{

    private static final int MAX_LATITUDE = 90;
    private static final int MIN_LATITUDE = -90;
    private static final int MAX_LONGITUDE = 180;
    private static final int MIN_LONGITUDE = -180;
    @Column(name = "coordinate")
    private final Point point;


    protected GeoCoordinate()
    {
        this.point = null;
    }


    /**
     * @param latitude  - y coordinate
     * @param longitude - x coordinate
     */
    public GeoCoordinate(final double latitude, final double longitude)
    {

        this.point = new Point(longitude, latitude);
    }


    @JsonProperty
    public double getLatitude()
    {
        return this.point.getY();
    }


    @JsonIgnore
    public Point getPoint()
    {
        return this.point;
    }


    @JsonProperty
    public double getLongitude()
    {
        return this.point.getX();
    }


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.point == null) ? 0 : this.point.hashCode());
        return result;
    }


    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        final GeoCoordinate other = (GeoCoordinate) obj;
        if (this.point == null)
        {
            if (other.point != null)
            {
                return false;
            }
        }
        else if (!this.point.equals(other.point))
        {
            return false;
        }
        return true;
    }


    @Override
    public String toString()
    {
        return this.point.toString();
    }

}
