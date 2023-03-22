package com.baidu.Drivers;

import com.baidu.DeBruijnAssembler;

public class SOPDriver {

	public static void main(String[] args) {
	String tekst = "He_fell_down_down_down_the_gray_hole";
	System.out.println(DeBruijnAssembler.assemble(tekst, 5, true));
	System.out.println(DeBruijnAssembler.assemble(tekst, 5, false));
	System.out.println( DeBruijnAssembler.assemble(tekst, 5, false));
	}



}
