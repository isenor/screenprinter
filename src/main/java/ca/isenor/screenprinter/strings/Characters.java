package ca.isenor.screenprinter.strings;

import java.util.Map;

import com.google.common.collect.Maps;

import ca.isenor.screenprinter.core.graphic.Graphic;
import ca.isenor.screenprinter.core.graphic.structures.Degrees;
import ca.isenor.screenprinter.core.graphic.structures.Orientation;
import ca.isenor.screenprinter.core.graphic.structures.Position;

public class Characters {
	private static final Map<Character, Graphic> characters = Maps.newHashMap();
	
	public static boolean has(Character character) {
		return characters.containsKey(character);
	}
	
	public static Graphic get(Character character) {
		return characters.get(character);
	}
	
	static {
		Graphic lowerI = new Graphic( " \n"
				                    + " XXX\n"
				                    + " XXX\n"
                                    + " \n"
                                    + "XXXX\n"
                                    + " XXX\n"
                                    + " XXX\n"
                                    + " XXX\n"
                                    + " XXX\n"
                                    + " XXX\n"
                                    + " XXX\n"
                                    + " XXXX");
		
		Graphic lowerJ = new Graphic( 
				  " \n"
                + "          XXX \n"
                + "          XXX \n"
                + "          \n"
                + "         XXXX \n"
                + "          XXX \n"
                + "          XXX \n"
                + "          XXX \n"
                + "          XXX \n"
                + "          XXX \n"
                + "          XXX \n"
                + "          XXX \n"
                + " XXX      XXX \n"
                + " XXXX    XXXX \n"
                + "  XXXXXXXXXX  \n"
                + "   XXXXXXX");
		
        Graphic upperA = new Graphic(  "      XX     \n" +
                                       "     XXXX    \n" +
                                       "    XXXXXX   \n" +
                                       "   XXX  XXX  \n" +
                                       "   XXX  XXX  \n" +
                                       "  XXXXXXXXXX \n" +
                                       "  XXXXXXXXXX \n" +
                                       " XXXX    XXXX \n" +
                                       " XXXX    XXXX \n" +
                                       "XXXX      XXXX");
        Graphic upperAv2 = new Graphic(           "           X\n"
        		                                + "          XXX\n" +
		                                          "         XXXXX\n" +
		                                          "        XXX XXX\n" +
		                                          "       XXX   XXX\n" +
		                                          "      XXX     XXX\n" +
		                                          "     XXXXXXXXXXXXX \n" +
		                                          "    XXXXXXXXXXXXXXX \n" +
		                                          "   XXXX         XXXX \n" +
		                                          "  XXXX           XXXX \n" +
		                                          " XXXX             XXXX \n"
		                                        + "XXXX               XXXX");
        Graphic lowerL = new Graphic(  "XXXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXX \n" +
                                       " XXXX\n");
        
        Graphic upperI = new Graphic(  "XXXXXXX\n" +
                                       "XXXXXXX\n" +
                                       "  XXX \n" +
                                       "  XXX \n" +
                                       "  XXX \n" +
                                       "  XXX \n" +
                                       "  XXX \n" +
                                       "  XXX \n" +
                                       "  XXX \n" +
                                       "  XXX \n" +
                                       "XXXXXXX\n" +
                                       "XXXXXXX\n");
        
        Position lowercaseOffset = new Position(0,4);
		Graphic lowerA = new Graphic( lowercaseOffset,
                                          "   XXXXX\n"
                                        + " XXXXXXXXX \n"
                                        + "XXXX   XXXX\n"
                                        + "        XXX\n"
                                        + " XXXXXXXXXX\n"
                                        + "XXXX   XXXX\n"
                                        + " XXXXXXXXXX\n"
                                        + "   XXXXXX XX" );
        
        Graphic lowerH = new Graphic(     "XXXX\n"
                                        + " XXX \n"
                                        + " XXX \n"
                                        + " XXX \n"
                                        + " XXX  XXX\n"
                                        + " XXXXXXXXXX \n"
                                        + " XXXXXXXXXXX\n"
                                        + " XXXX    XXX\n"
                                        + " XXX     XXX\n"
                                        + " XXX     XXX\n"
                                        + " XXX     XXX\n"
                                        + "XXXX    XXXXX\n");
        
        Graphic lowerK = new Graphic(     "XXXX\n"
                                        + " XXX \n"
                                        + " XXX \n"
                                        + " XXX \n"
                                        + " XXX    XXXXX\n"
                                        + " XXX   XXXX \n"
                                        + " XXX  XXXX\n"
                                        + " XXXXXXXX \n"
                                        + " XXXXXXXXX\n"
                                        + " XXXXX XXX\n"
                                        + " XXXX   XXX\n"
                                        + "XXXX    XXXXX");

        Graphic upperM = new Graphic(   "XXX             XXX\n"
        		                      + " XXX           XXX \n"
        		                      + " XXXX         XXXX \n"
        		                      + " XXXXX       XXXXX \n"
        		                      + " XXXXXX     XXXXXX \n"
        		                      + " XXX XXXX XXXX XXX \n"
        		                      + " XXX  XXXXXXX  XXX \n"
        		                      + " XXX   XXXXX   XXX \n"
        		                      + " XXX    XXX    XXX \n"
        		                      + " XXX     X     XXX \n"
        		                      + " XXX           XXX \n"
        		                      + "XXXX           XXXX\n");
        
        Graphic upperH = new Graphic(   "XXXXX       XXXXX\n"
                                      + " XXX         XXX \n"
                                      + " XXX         XXX \n"
                                      + " XXX         XXX \n"
                                      + " XXXXXXXXXXXXXXX \n"
                                      + " XXXXXXXXXXXXXXX \n"
                                      + " XXX         XXX \n"
                                      + " XXX         XXX \n"
                                      + " XXX         XXX \n"
                                      + " XXX         XXX \n"
                                      + " XXX         XXX \n"
                                      + "XXXXX       XXXXX\n");
        
        Graphic lowerS = new Graphic( lowercaseOffset,
        		                      "   XXXXX   \n"
        		                    + " XXXXXXXXX \n"
        		                    + "XXX     XXX\n"
        		                    + " XXXXXX    \n"
        		                    + "    XXXXXX \n"
        		                    + "XXX     XXX\n"
        		                    + " XXXXXXXXX \n"
        		                    + "   XXXXX ");
        Graphic comma = new Graphic(new Position(1,10), "XXX\n"
        		                                      + "XXX\n"
        		                                      + " XX\n"
        		                                      + "XX");
        
        Graphic period = new Graphic(new Position(1,10),   "XXX\n"
										                 + "XXX");
        
        
        
        Graphic qMark = new Graphic(                      "     XXXXXX\n"
										                + "   XXXXXXXXXX\n"
										                + "  XXX      XXX\n"
										                + "  XXX      XXX\n"
										                + "         XXXX\n"
										                + "       XXXX\n"
										                + "      XXX\n"
										                + "      XXX\n"
										                + "      XXX\n"
										                + "\n"
										                + "      XXX\n"
										                + "      XXX");
        
        
        Graphic lowerE = new Graphic( lowercaseOffset,
        		                      "   XXXXX    \n"
        		                    + " XXXXXXXXX  \n"
        		                    + "XXXX   XXXX \n"
        		                    + "XXXXXXXXXXX\n"
        		                    + "XXX        \n"
        		                    + "XXXX   XXXX\n"
        		                    + " XXXXXXXXX \n"
        		                    + "   XXXXX");
        Graphic lowerO = new Graphic(lowercaseOffset,
        		                      "   XXXXX \n"
        		                    + " XXXXXXXXX \n"
        		                    + "XXXX   XXXX \n"
        		                    + "XXX     XXX \n"
        		                    + "XXX     XXX \n"
        		                    + "XXXX   XXXX \n"
        		                    + " XXXXXXXXX  \n"
        		                    + "   XXXXX");
        Graphic lowerM = new Graphic ( lowercaseOffset,
        		                       "XXXX  XXX   XXX\n"
        		                     + " XXXXXXXXXXXXXXXX\n"
        		                     + " XXXXXXXXXXXXXXXXX\n"
        		                     + " XXXX    XXX    XXX\n"
        		                     + " XXX     XXX    XXX\n"
        		                     + " XXX     XXX    XXX\n"
        		                     + " XXX     XXX    XXX\n"
        		                     + "XXXXX   XXXXX  XXXXX");
        Graphic lowerN = new Graphic (lowercaseOffset,
        		                       "XXXX  XXX \n"
                                     + " XXXXXXXXXX\n"
                                     + " XXXXXXXXXXX\n"
                                     + " XXXX    XXX\n"
                                     + " XXX     XXX\n"
                                     + " XXX     XXX\n"
                                     + " XXX     XXX\n"
                                     + "XXXXX   XXXXX");
        Graphic lowerR = new Graphic( lowercaseOffset,
        		                      "XXXX  XXXXX  \n"
        		                    + " XXX XXXXXXX \n"
        		                    + " XXXXXX   XXX\n"
        		                    + " XXXXX\n"
        		                    + " XXXX \n"
        		                    + " XXX \n"
        		                    + " XXX \n"
        		                    + "XXXXX ");
        
        Graphic lowerV = new Graphic( lowercaseOffset,
                                      "XXXX       XXXX\n"
                                    + " XXXX     XXXX \n"
                                    + "  XXXX   XXXX  \n"
                                    + "   XXXX XXXX  \n"
                                    + "    XXXXXXX  \n"
                                    + "     XXXXX   \n"
                                    + "      XXX   \n"
                                    + "       X");
        
        Graphic lowerX = new Graphic( lowercaseOffset,
                "XXXXX     XXXXX\n"
              + "  XXXX   XXXX \n"
              + "   XXXX XXXX  \n"
              + "     XXXXX  \n"
              + "     XXXXX  \n"
              + "   XXXX XXXX   \n"
              + "  XXXX   XXXX   \n"
              + "XXXXX     XXXXX");
        
        
        Graphic lowerZ = new Graphic( lowercaseOffset,
                "XXXXXXXXXXXXXXX\n"
              + "XXXXXXXXXXXXX \n"
              + "X       XXXX  \n"
              + "      XXXX  \n"
              + "     XXXXX  \n"
              + "   XXXX      X\n"
              + "  XXXXXXXXXXXX\n"
              + "XXXXXXXXXXXXXX");
        
        Graphic lowerC = new Graphic(lowercaseOffset,
                "   XXXXX \n"
              + " XXXXXXXXX \n"
              + "XXXX   XXXX \n"
              + "XXX      \n"
              + "XXX      \n"
              + "XXXX   XXXX \n"
              + " XXXXXXXXX  \n"
              + "   XXXXX");
		Graphic lowerD = 
    		   new Graphic(
                                      "        XXXXX\n"
                                    + "         XXX \n"
                                    + "         XXX \n"
                                    + "         XXX \n"
                                    + "   XXXXX XXX\n"
                                    + " XXXXXXXXXXX \n"
                                    + "XXXX   XXXXX \n"
                                    + "XXX      XXX\n"
                                    + "XXX      XXX\n"
                                    + "XXXX   XXXXX \n"
                                    + " XXXXXXXXXXX \n"
                                    + "   XXXXX XXXX");
		Graphic lowerT = new Graphic( "    X\n"
				                    + "   XX\n"
				                    + "  XXX\n"
				                    + "  XXX\n"
				                    + "XXXXXXX\n"
				                    + "XXXXXXX\n"
				                    + "  XXX \n"
				                    + "  XXX \n"
				                    + "  XXX \n"
				                    + "  XXX \n"
				                    + "  XXXXX\n"
				                    + "   XXX");
		
		Graphic lowerF = new Graphic( "     XXXXX\n"
                                    + "   XXXXXXXXX\n"
                                    + "  XXXX   XXX\n"
                                    + "  XXXX   XXXX\n"
                                    + "XXXXXXX\n"
                                    + "XXXXXXX\n"
                                    + "  XXX \n"
                                    + "  XXX \n"
                                    + "  XXX \n"
                                    + "  XXX \n"
                                    + "  XXX\n"
                                    + " XXXXX");
		
		Graphic lowerY = new Graphic(lowercaseOffset  , "XXXXXX     XXXXXX\n"
				                                      + "  XXXX     XXXX\n"
				                                      + "   XXXX   XXXX\n"
				                                      + "    XXXX XXXX\n"
				                                      + "     XXXXXXX\n"
				                                      + "      XXXXX\n"
				                                      + "      XXXX\n"
				                                      + "     XXXX\n"
				                                      + "    XXXX\n"
				                                      + "   XXXX\n"
				                                      + "  XXXX\n"
				                                      + "XXXXXX");
		Graphic lowerG = new Graphic(lowercaseOffset, 
        		                      "   XXXXX XXXX \n"
        		                    + " XXXXXXXXXXX\n"
        		                    + "XXXX   XXXXX \n"
        		                    + "XXX     XXXX \n"
        		                    + "XXX     XXXX \n"
        		                    + "XXXX   XXXXX \n"
        		                    + " XXXXXXXXXXX \n"
        		                    + "   XXXXX XXX\n"
        		                    + "         XXX\n"
        		                    + "XXXX     XXX\n"
        		                    + " XXXXXXXXXX\n"
        		                    + "   XXXXXX");
		
		Graphic lowerQ = new Graphic(lowercaseOffset, 
                "   XXXXX XXXX \n"
              + " XXXXXXXXXXX\n"
              + "XXXX   XXXXX \n"
              + "XXX     XXXX \n"
              + "XXX     XXXX \n"
              + "XXXX   XXXXX \n"
              + " XXXXXXXXXXX \n"
              + "   XXXXX XXX\n"
              + "         XXX\n"
              + "         XXX    XXX\n"
              + "         XXXXXXXXXX\n"
              + "          XXXXXXX");
		
		Graphic underscore = new Graphic(new Position(0,12), "XXXXXXXXXXXXXX");

		Graphic lowerP = lowerD.rotate(new Position(6, 7), Degrees.DEGREE_180).offset(0,1);

		Graphic lowerB = lowerD.reflect(6, Orientation.VERTICAL);

		
		Graphic lowerWv2 = new Graphic( lowercaseOffset,
                "XXXXX             XXXXX\n"
              + " XXXX     XXX     XXXX\n"
              + "  XXXX   XXXXX   XXXX\n"
              + "   XXXX XXXXXXX XXXX\n"
              + "    XXXXXXX XXXXXXX\n"
              + "     XXXXX   XXXXX\n"
              + "      XXX     XXX\n"
              + "       X       X");
		
		Graphic lowerW = lowerM.reflect(6, Orientation.HORIZONTAL).reflect(9, Orientation.VERTICAL)
 			.offset(new Position(0, 3));

		Graphic lowerU = lowerN.rotate(new Position(6,4), Degrees.DEGREE_180).offset(0,7);
		
		Graphic newLine = new Graphic("\n");
		
		Graphic dash = new Graphic(new Position(0,7), "XXXXXXX\nXXXXXXX");
		Graphic plus = new Graphic(new Position(0,5), 
				                                      "   XX  \n"
				                                    + "   XX  \n"
				                                    + "XXXXXXXX\n"
				                                    + "XXXXXXXX\n"
				                                    + "   XX  \n"
				                                    + "   XX  ");
		Graphic bar = new Graphic(new Position(3,0), 
                "XX\n"
			  + "XX\n"
			  + "XX\n"
			  + "XX\n"
			  + "XX\n"
			  + "XX\n"
			  + "XX\n"
			  + "XX\n"
			  + "XX\n"
			  + "XX\n"
			  + "XX\n"
				);
		
        Graphic space = new Graphic("        ");
        characters.put('a', lowerA);
		characters.put('A', upperAv2);
		characters.put('b', lowerB);
		characters.put('c', lowerC);
		characters.put('d', lowerD);
		characters.put('e', lowerE);
		characters.put('f', lowerF);
		characters.put('g', lowerG);
		characters.put('h', lowerH);
		characters.put('H', upperH);
		characters.put('i', lowerI);
		characters.put('I', upperI);
		characters.put('j', lowerJ);
		characters.put('k', lowerK);
		characters.put('l', lowerL);
		characters.put('m', lowerM);
		characters.put('M', upperM);
		characters.put('n', lowerN);
		characters.put('o', lowerO);
		characters.put('p', lowerP);
		characters.put('q', lowerQ);
		characters.put('r', lowerR);
		characters.put('s', lowerS);
		characters.put('t', lowerT);
		characters.put('u', lowerU);
		characters.put('v', lowerV);
		characters.put('w', lowerWv2);
		characters.put('x', lowerX);
		characters.put('y', lowerY);
		characters.put('z', lowerZ);
		characters.put(' ', space);
		characters.put(',', comma);
		characters.put('_', underscore);
		characters.put('\n', newLine);
		characters.put('-', dash);
		characters.put('+', plus);
		characters.put('|', bar);
		characters.put('.', period);
		characters.put('?', qMark);
	}
}
