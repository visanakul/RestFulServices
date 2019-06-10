package com.webservice.rest.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
@Data
@XmlRootElement
public class Result {
	private String msg;
	private Date date;
}
