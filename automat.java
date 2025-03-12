
public class automat{

	int apProb;
	
	static String[] zeichen = {"a","e","s","l","i","th","t","n","'"};
	static String[] vokal = {"a","e","i"};
	//static String[] vokalAp = {"a","e","i","'"};
	static String[] konsonant = {"s","l","th","t","n"};
	//static String[] konsonantAp = {"s","l","th","t","n","'"};
	
	public automat(){
		
		apProb = 1;
		
		System.out.println("initalisation of static String arrays...");
		
		System.out.println(zeichen);
		System.out.println(vokal);
		//System.out.println(vokalAp);
		System.out.println(konsonant);
		//System.out.println(konsonantAp);
		
		System.out.println("...done \n");
		
		System.out.println("test of selectChar method...");
		
		System.out.println(selectChar());	// 1
		System.out.println(selectChar());	// 2
		System.out.println(selectChar());
		System.out.println(selectChar());
		System.out.println(selectChar());
		System.out.println(selectChar());	// 5
		System.out.println(selectChar());
		System.out.println(selectChar());
		System.out.println(selectChar());
		System.out.println(selectChar());
		System.out.println(selectChar());	// 10
		System.out.println(selectChar());
		System.out.println(selectChar());	// 12
		
		System.out.println("...done \n");
		
		System.out.println("test of selectVokal method...");
		
		System.out.println(selectVokal());
		System.out.println(selectVokal());
		System.out.println(selectVokal());
		System.out.println(selectVokal());
		System.out.println(selectVokal());
		
		System.out.println("...done \n");
		
		System.out.println("test of selectVokalAp method...");
		
		System.out.println(selectVokalAp());
		System.out.println(selectVokalAp());
		System.out.println(selectVokalAp());
		System.out.println(selectVokalAp());
		System.out.println(selectVokalAp());
		System.out.println(selectVokalAp());
		System.out.println(selectVokalAp());
		
		System.out.println("...done \n");
		
		System.out.println("test of silben methods...");
		
		System.out.println("\n |A-V|")
		for(int i = 0, i++, i<5){
		    System.out.println(silbeAV());
	    }
	    System.out.println("\n |K-V|")
		for(int i = 0, i++, i<5){
		    System.out.println(silbeKV());
	    }
	    System.out.println("\n |K-A|")
		for(int i = 0, i++, i<5){
		    System.out.println(silbeKA());
	    }
	}
	
	public String erzeugeWort(int wortLen){
		String wort = silbe1();
		Sring tempSilbe = "";
		int status = 0;
		int silbenNummer = 1;
		while(silbenNummer < wortLen){
		    switch(status){
		        case 0:
		            wort = wort + silbeKA();
		    }
		}
		return wort;
	}
	
	//TODO Pre u Suf silben verbieten
	
	public String silbeAV(){
		String sAV = selectKonsoAp() + selectVokal();
		return sAV;
	}
	
	public String silbeKV(){
		String sKV = selectKonso() + selectVokal();
		return sKV;
	}
	
	public String silbeKA(){
	    String sKA = selectKonso() + selectVokalAp();
	    return sKA;
	}
	
	public String silbe1(){
	    String s1 = silbeKA();
	}
	
	public String silbeVerbEnd(){
	    String sVE = silbeKV();
	}
	
	public String silbeEnd(){
	    String sE = silbeKA();
	}
	
	public String selectChar(){
		
		String pChar = "";
		int i = randomNumber(1,80 + apProb);
		
		if(i<=10){
			pChar = zeichen[0];
		}else if(i<=20 && i>=11){
			pChar = zeichen[1];
		}else if(i<=30 && i>=21){
			pChar = zeichen[2];
		}else if(i<=40 && i>=31){
			pChar = zeichen[3];
		} else if(i<=50 && i>=41){
			pChar = zeichen[4];
		}else if(i<=60 && i>=51){
			pChar = zeichen[5];
		}else if(i<=70 && i>=61){
			pChar = zeichen[6];
		}else if(i<=80 && i>=71){
			pChar = zeichen[7];
		}else if(i==81){
			pChar = zeichen[8];
		}
		
		return pChar;
	}
	
	public String selectVokal(){
		
		String pVokal = "";
		int i = randomNumber(1,30);
		
		if(i<=10){
			pVokal = vokal[0];
		}else if(i<=20 && i>=11){
			pVokal = vokal[1];
		}else if(i<=30 && i>=21){
			pVokal = vokal[2];
		}
		
		return pVokal;
	}
	
	public String selectVokalAp(){
		
		String pVokalAp = "";
		int i = randomNumber(1,30 + apProb);
		
		if(i<=10){
			pVokalAp = vokal[0];
		}else if(i<=20 && i>=11){
			pVokalAp = vokal[1];
		}else if(i<=30 && i>=21){
			pVokalAp = vokal[2];
		}else if(i>=31){
			pVokalAp = "'";
		}
		
		return pVokalAp;
	}

	public String selectKonso(){
		
		String pKonso = "";
		int i = randomNumber(1,50);
		
		if(i<=10){
			pKonso = konsonant[0];
		}else if(i<=20 && i>=11){
			pKonso = konsonant[1];
		}else if(i<=30 && i>=21){
			pKonso = konsonant[2];
		}else if(i<=40 && i>=31){
			pKonso = konsonant[3];
		} else if(i<=50 && i>=41){
			pKonso = konsonant[4];
		}
		
		return pKonso;
	}
	
	public String selectKonsoAp(){
		
		String pKonsoAp = "";
		int i = randomNumber(1,50 + apProb);
		
		if(i<=10){
			pKonsoAp = konsonant[0];
		}else if(i<=20 && i>=11){
			pKonsoAp = konsonant[1];
		}else if(i<=30 && i>=21){
			pKonsoAp = konsonant[2];
		}else if(i<=40 && i>=31){
			pKonsoAp = konsonant[3];
		}else if(i<=50 && i>=41){
			pKonsoAp = konsonant[4];
		}else if(i>=51){
			pKonsoAp = "'";
		}
		
		return pKonsoAp;
	}
	
	public static int randomNumber(int von, int bis) {
	    int randomNr = von + (int)(Math.random() * (double)(bis - von + 1));
	    return randomNr;
	}
	
	// / / / / /
   
	public static void main(String args[]){

        automat pAuto = new automat();
    }
}