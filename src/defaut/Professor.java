package defaut;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="office_number")
	private String offceNumber;
	
	@Column(name="research_area")
	private String researchArea;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	

	public Professor() {
		
	}

	public Professor(String offceNumber, String researchArea) {
		this.offceNumber = offceNumber;
		this.researchArea = researchArea;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOffceNumber() {
		return offceNumber;
	}


	public void setOffceNumber(String offceNumber) {
		this.offceNumber = offceNumber;
	}


	public String getResearchArea() {
		return researchArea;
	}


	public void setResearchArea(String researchArea) {
		this.researchArea = researchArea;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Professor [id=" + id + ", offceNumber=" + offceNumber + ", researchArea=" + researchArea + ", customer="
				+ customer + "]";
	}
}
