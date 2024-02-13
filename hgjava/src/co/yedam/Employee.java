package co.yedam;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor// 전체필드값을 가지는 생성자.
@NoArgsConstructor//기본 생성자
public class Employee {
  private int empNo;//사원번호.
  private String empName;// 사원명.
  private String email;//이메일
  private String phone;
  private Date hireDate;
  private int salary;
  private String department;
}
