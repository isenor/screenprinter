package ca.isenor.screenprinter.strings;

import ca.isenor.screenprinter.core.processor.GraphicProcessor;

public class StringPrinterDemo {
	
	public static void main(String[] args) {
		/**
		 * A Printer is constructed using a GraphicsProcessor, a StringParser, and a PrintStream.
		 */
		StringPrinter printer = new StringPrinter(new StringParser(), new GraphicProcessor(), System.out);
		
		//printer.buffer("yes, la ilaha illallah");
		//printer.buffer("la ilaha illallah\nAllahu Allah\nAllahu rabbi\nawni wa hasbi, ma li siwahu");

		
		
		printer.bufferln("Hi jibreel.\nHow are you?");
		printer.bufferln("there is nothing going on");
		printer.print();
		
		printer.bufferln("abcdefghijklmnopqrstuvwxyz");
		printer.print();
//		printer.println("Allahi Allah");
//		
//		printer.println("I do love Mariah");
//		
//		printer.println("I love Aminah, Aneesah, Muneerah, and Mariah");
//				
//		printer.println("yusuf is a man");
//		
//		
//		printer.println("~");
	}
}
