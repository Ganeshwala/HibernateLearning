package Com.Hibenate.Entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_Id")
	private int addressId;
	@Column(length = 50)
	private String street;
	@Column(nullable = true)
	private String city;
	@Transient
	private boolean isMegaCity;
	private double population;

	@Temporal(TemporalType.DATE) // to format date
	private Date date;
	@Lob
	private byte[] images;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String street, String city, boolean isMegaCity, double population, Date date,
			byte[] images) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isMegaCity = isMegaCity;
		this.population = population;
		this.date = date;
		this.images = images;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isMegaCity() {
		return isMegaCity;
	}

	public void setMegaCity(boolean isMegaCity) {
		this.isMegaCity = isMegaCity;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getImages() {
		return images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isMegaCity="
				+ isMegaCity + ", population=" + population + ", date=" + date 
				+ "]";
	}

}
