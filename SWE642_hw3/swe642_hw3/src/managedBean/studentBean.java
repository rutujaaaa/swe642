/**
 * The StudentBean has attributes that matches most of the Student Survey Form fields
 */
package managedBean;
/**
 * 
 * @author rutujajadhav
 *
 */
public class studentBean {
	private String fullname ;
    private String studID ;
    private String email ;
    private String phone ;
    private String url ;
    private String address ;
    public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getStudID() {
		return studID;
	}
	public void setStudID(String studID) {
		this.studID = studID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	private String zipCode ;
    private String city ;
    private String state ;
    private String comments ;
}
