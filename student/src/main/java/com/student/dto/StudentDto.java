package com.student.dto;

public class StudentDto {

	Long studentId;
	String studentName;
	String studentClass;
	Long studentPhoneNumber;
	String studentEmail;
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public Long getStudentPhoneNumber() {
		return studentPhoneNumber;
	}

	public void setStudentPhoneNumber(Long studentPhoneNumber) {
		this.studentPhoneNumber = studentPhoneNumber;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public StudentDto(Long studentId, String studentName, String studentClass, Long studentPhoneNumber,
			String studentEmail) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.studentPhoneNumber = studentPhoneNumber;
		this.studentEmail = studentEmail;
	}

	public StudentDto() {
		super();
	}

	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentClass=" + studentClass
				+ ", studentPhoneNumber=" + studentPhoneNumber + ", studentEmail=" + studentEmail + "]";
	}
	
}
