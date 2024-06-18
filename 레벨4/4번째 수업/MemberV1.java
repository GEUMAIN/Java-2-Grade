package java_level4.lang.immutable.address;

public class MemberV1 {
	
	private String name;
	private Address address;

	public MemberV1(String name, Address address) {
		this.address = address;
		this.name = name;
	}
	
	Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MemberV1 [name=" + name + ", address=" + address + "]";
	}
	
	
}
