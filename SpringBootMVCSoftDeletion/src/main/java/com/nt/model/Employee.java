package com.nt.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="soft_emp")
@RequiredArgsConstructor

@SQLDelete(sql="update soft_emp set status='inactive' where empno=?")
@SQLRestriction("status <> 'inactive'")
public class Employee {
	@Id
	@SequenceGenerator(name = "seq1" ,sequenceName="emp_seq1",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="seql",strategy=GenerationType.SEQUENCE)
	private Integer empno;
	
	@NonNull
	@Column(length=20)
	private String ename="ankul";
	
	@NonNull
	@Column(length=20)
	private String job;
	
	@NonNull
	private Double  sal;
	
	@NonNull
     private Integer deptno;
	
	private String status="active";
	

}
