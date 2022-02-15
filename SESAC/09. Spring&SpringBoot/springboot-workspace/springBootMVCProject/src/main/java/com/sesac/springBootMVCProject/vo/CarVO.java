package com.sesac.springBootMVCProject.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
@Getter
@Setter
//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder*/

@Data
@Builder
@AllArgsConstructor
public class CarVO {

	@NonNull
	private String model;
	private int price;
}
