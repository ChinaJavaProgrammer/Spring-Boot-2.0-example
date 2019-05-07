package com.springboot.com.springbootexample.entity;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.springboot.com.springbootexample.annotation.DIYValidate;


public class Validate {
	
	
	public interface TestValidate{}
	
	/*空验证*/
	@Null //验证对象是否为空
	private Integer id;
	
	@NotNull //验证对象不为空
	private Integer boId;
	
	@NotBlank //验证字符串不为空或者不是空字符串，比如""和" "都会验证失败
	private String blank;
	
	@NotEmpty // 验证对象不为空或者集合不为空
	private List map;
	/*空验证*/
	
	/*长度验证*/
	@Size(min=0,max=10) //验证对象长度，可支持字符串、集合
	private List<String> listSize;
	
	@Length //验证字符串大小
	private String stringLength;
	/*长度验证*/
	
	/*数值检测*/ //groups参数表示如果是此接口的验证才会触发这个校验
	@Min(value=10,groups=TestValidate.class) //验证数字是否大于等于指定的值
	private Integer testMin;
	
	@Max(10) //验证数字是否小于等于指定的值
	private Integer testMax;
	
	@Digits(integer=9,fraction=2) // 验证数字是否符合指定格式
	private Integer testDigits;
	
	@Range(min=0,max=100) //验证数字是否在指定的范围内
	private Integer testRange;
	/*数值检测*/
	
	/*其他*/
	@Email //验证是否为邮件格式，为null则不做校验
	private String email;
	
	@Pattern(regexp="[a]") //验证String对象是否符合正则表达式
	private String testPattern;
	/*其他*/
	
	/*自定义验证*/
	@DIYValidate(must="validate",groups=TestValidate.class)
	private String testDIYValidate;
	/*自定义验证*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBoId() {
		return boId;
	}

	public void setBoId(Integer boId) {
		this.boId = boId;
	}

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}


	public List getMap() {
		return map;
	}

	public void setMap(List map) {
		this.map = map;
	}

	public List<String> getListSize() {
		return listSize;
	}

	public void setListSize(List<String> listSize) {
		this.listSize = listSize;
	}

	public String getStringLength() {
		return stringLength;
	}

	public void setStringLength(String stringLength) {
		this.stringLength = stringLength;
	}

	public Integer getTestMin() {
		return testMin;
	}

	public void setTestMin(Integer testMin) {
		this.testMin = testMin;
	}

	public Integer getTestMax() {
		return testMax;
	}

	public void setTestMax(Integer testMax) {
		this.testMax = testMax;
	}

	public Integer getTestDigits() {
		return testDigits;
	}

	public void setTestDigits(Integer testDigits) {
		this.testDigits = testDigits;
	}

	public Integer getTestRange() {
		return testRange;
	}

	public void setTestRange(Integer testRange) {
		this.testRange = testRange;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTestPattern() {
		return testPattern;
	}

	public void setTestPattern(String testPattern) {
		this.testPattern = testPattern;
	}

	public String getTestDIYValidate() {
		return testDIYValidate;
	}

	public void setTestDIYValidate(String testDIYValidate) {
		this.testDIYValidate = testDIYValidate;
	}
	
	
}
