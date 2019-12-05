package com.letran.manaoag.sis.entity;

public class Student {
	
	private String sid,
				   snum,
				   first_name,
				   middle_name,
				   last_name,
				   age,
				   gender,
				   birthday,
				   contact_no,
				   address,
				   father_name,
				   mother_name,
				   nationality,
				   religion,
				   civil_status,
				   course,
				   year;
	
	public Student() {
		
	}
	
	
	public Student(String snum, String first_name, String middle_name, String last_name, String age, String gender,
			String birthday, String contact_no, String address, String father_name, String mother_name,
			String nationality, String religion, String civil_status, String course, String year) {
		super();
		this.snum = snum;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.contact_no = contact_no;
		this.address = address;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.nationality = nationality;
		this.religion = religion;
		this.civil_status = civil_status;
		this.course = course;
		this.year = year;
	}
	
	
	public Student(String sid,String snum, String first_name, String middle_name, String last_name, String age, String gender,
			String birthday, String contact_no, String address, String father_name, String mother_name,
			String nationality, String religion, String civil_status, String course, String year) {
		super();
		this.sid=sid;
		this.snum = snum;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.last_name = last_name;
		this.age = age;
		this.gender = gender;
		this.birthday = birthday;
		this.contact_no = contact_no;
		this.address = address;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.nationality = nationality;
		this.religion = religion;
		this.civil_status = civil_status;
		this.course = course;
		this.year = year;
	}
	
	

	public String getSid() {
		return sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}


	public String getSnum() {
		return snum;
	}


	public void setSnum(String snum) {
		this.snum = snum;
	}



	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCivil_status() {
		return civil_status;
	}

	public void setCivil_status(String civil_status) {
		this.civil_status = civil_status;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	

}
