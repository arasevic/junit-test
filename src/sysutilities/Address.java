package sysutilities;

/**
 * Immutable class
 * @author cmsc131
 *
 */
public class Address {
	private static final String DEFAULT_STREET = "8223 Paint Branch Dr.";
	private static final String DEFAULT_CITY = "College Park";
	private static final String DEFAULT_STATE = "MD";
	private static final String DEFAULT_ZIPCODE = "20742";
	private String street, city, state, zipCode;

	public Address(String street, String city, String state, String zipCode) {
		if (street == null || city == null || state == null || zipCode == null	
				|| !validZipCode(zipCode.trim())) {
			throw new IllegalArgumentException("Invalid Address Argument");
		}
		this.street = street.trim();
		this.city = city.trim();
		this.state = state.trim();
		this.zipCode = zipCode.trim();
	}

	public Address() {
		this(DEFAULT_STREET, DEFAULT_CITY, DEFAULT_STATE, DEFAULT_ZIPCODE);
	}
	
	public Address(Address address) {
		this(address.street, address.city, address.state, address.zipCode);
	}
	
	public Address(String street) {
		this(street, DEFAULT_CITY, DEFAULT_STATE, DEFAULT_ZIPCODE);
	}
	
	public String getStreet() { return street; }
	public String getCity() { return city; }
	public String getState() { return state; }
	public String getZipCode() { return zipCode; }
	
	public boolean equals(Object obj) {
		if (obj == this) 
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Address address = (Address) obj;
		return  street.equals(address.street) &&
				city.equals(address.city) &&
				state.equals(address.state) &&
				zipCode.equals(address.zipCode);
	}
	
	public String toString() {
		return street + " " + city + " " + state + " " + zipCode; 
	}
	
	private boolean validZipCode(String zipCode) {
		for (int idx = 0; idx < zipCode.length(); idx++) {
			if (!Character.isDigit(zipCode.charAt(idx))) {
				return false;
			}
		}
		return true;
	}
}
