package com.baidu.Drivers;

import com.baidu.DeBruijnAssembler;

public class SOPDriver {
	public static void main(String[] args) {
		String tekst1 = "He_fell_down_down_down_the_gray_hole";
		System.out.println(DeBruijnAssembler.assemble(tekst1, 4, true));
		System.out.println(DeBruijnAssembler.assemble(tekst1, 4, false));
		System.out.println( DeBruijnAssembler.assemble(tekst1, 4, false) + "\n");

		String tekst2 = "He_fell_down_the_gray_hole";
		System.out.println(DeBruijnAssembler.assemble(tekst2, 4, false));
		System.out.println(DeBruijnAssembler.assemble(tekst2, 4, false));
		System.out.println( DeBruijnAssembler.assemble(tekst2, 4, false));
	}



}
