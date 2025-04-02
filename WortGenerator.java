//import sas.Tools;
public class WortGenerator{
	int maxGenerationTries = 5;
	int apProb;
	static String[] zeichen = {"a","e","s","l","i","th","t","n","'"};
	static String[] vokal = {"a","e","i"};
	static String[] konsonant = {"s","l","th","t","n"};
	BinarySearchTree<TaubischString> alleTauben = new BinarySearchTree<TaubischString>();
	BinarySearchTree<Uebersetzung> translationTreeDE = new BinarySearchTree<Uebersetzung>();
	List<Uebersetzung> translationList = new List<Uebersetzung>();

	public WortGenerator(boolean pConOut){
		DatabaseConnector sprachDatabaseConnector = new DatabaseConnector("0",0,"sprachDB.db","user","pass");
		apProb = 3;
		constructorOutput(pConOut);
		// for(int menge = 0; menge < 100; menge++){
		// System.out.println(erzeugeWort(7));
		// }
		sprachDatabaseConnector.executeStatement("select * from lexikon where ID == 0");
		System.out.println(sprachDatabaseConnector.getCurrentQueryResult());
		System.out.println(sprachDatabaseConnector.getErrorMessage());
		uebersetze("Test", 0, 4);
	}
	

	public String uebersetze(String pDeutsch, int pWortArt,int pLen){
		if(translationTreeDE.search(new Uebersetzung(pDeutsch)) == null){
			switch (pWortArt){
				case 0:
					Uebersetzung tempS = new Uebersetzung(pDeutsch,erzeugeSubstantiv(pLen,0));
					translationTreeDE.insert(tempS);
					translationList.append(tempS);
					break;
				case 1:
					Uebersetzung tempV = new Uebersetzung(pDeutsch,erzeugeVerb(pLen,0));
					translationTreeDE.insert(tempV);
					translationList.append(tempV);
					break;
				case 2:
				    Uebersetzung tempA = new Uebersetzung(pDeutsch,erzeugeAdjektiv(pLen,0));
				    translationTreeDE.insert(tempA);
					translationList.append(tempA);
					break;
				default:
					Uebersetzung temp = new Uebersetzung(pDeutsch,erzeugeSubstantiv(pLen,0));
					translationTreeDE.insert(temp);
					translationList.append(temp);
					break;
			}
		}
			return translationTreeDE.search(new Uebersetzung(pDeutsch)).getTaubischString();
	}

	public TaubischString erzeugeSubstantiv(int wortLen,int alreadyGeneratedExeptions){
		if(alreadyGeneratedExeptions > maxGenerationTries){
			throw new IllegalArgumentException(
				"Generation des Wortes fehlgeschlagen:\n"
				+ "{maxGenerationTries} mal in Folge konnte kein neues Wort erzeugt werden.\n"
				+ "Möglicherweise andere Silbenanzahl wählen."
			);
		}else{
			String tempSilbe = "";
			int status = 1;
			String wort = silbe1();
			int silbenNummer = 1;
			while(silbenNummer < wortLen-1){
				switch(status){
					case 0:
						wort = wort + silbeKV();
						status = randomNumber(1, 2);
						break;
					case 1:
						wort = wort + silbeKA();
						if(wort.endsWith("'")){
							status = 0;
						}else{
							status = randomNumber(1, 2);
						}
						break;
					case 2:
						tempSilbe = silbeAV();
						wort.concat(tempSilbe);
						if(tempSilbe.startsWith("'")){
							status = 0;
						}else{
							status = randomNumber(1, 2);
						}					
				}
				silbenNummer++;
			}
			wort = wort + silbeEnd();
			TaubischString temp = new TaubischString(wort);
			if(alleTauben.search(temp) != null){
				return erzeugeSubstantiv(wortLen, alreadyGeneratedExeptions+1);
			}else{
				alleTauben.insert(temp);
				return temp;
			}
		}
	}
	
	public TaubischString erzeugeAdjektiv(int wortLen,int alreadyGeneratedExeptions){
		if(alreadyGeneratedExeptions > maxGenerationTries){
			throw new IllegalArgumentException(
				"Generation des Wortes fehlgeschlagen:\n"
				+ "{maxGenerationTries} mal in Folge konnte kein neues Wort erzeugt werden.\n"
				+ "Möglicherweise andere Silbenanzahl wählen."
			);
		}else{
			String tempSilbe = "";
			int status = 1;
			String wort = silbe1Adj();
			int silbenNummer = 1;
			while(silbenNummer < wortLen-1){
				switch(status){
					case 0:
						wort = wort + silbeKV();
						status = randomNumber(1, 2);
						break;
					case 1:
						wort = wort + silbeKA();
						if(wort.endsWith("'")){
							status = 0;
						}else{
							status = randomNumber(1, 2);
						}
						break;
					case 2:
						tempSilbe = silbeAV();
						wort.concat(tempSilbe);
						if(tempSilbe.startsWith("'")){
							status = 0;
						}else{
							status = randomNumber(1, 2);
						}					
				}
				silbenNummer++;
			}
			wort = wort + silbeEnd();
			TaubischString temp = new TaubischString(wort);
			if(alleTauben.search(temp) != null){
				return erzeugeSubstantiv(wortLen, alreadyGeneratedExeptions+1);
			}else{
				alleTauben.insert(temp);
				return temp;
			}
		}
	}

	public TaubischString erzeugeVerb(int wortLen,int alreadyGeneratedExeptions){
		if(alreadyGeneratedExeptions > maxGenerationTries){
			throw new IllegalArgumentException(
				"Generation des Wortes fehlgeschlagen:\n"
				+ "{maxGenerationTries} mal in Folge konnte kein neues Wort erzeugt werden.\n"
				+ "Möglicherweise andere Silbenanzahl wählen."
			);
		}else{
			String tempSilbe = "";
			int status = 1;
			String wort = silbe1();
			int silbenNummer = 1;
			while(silbenNummer < wortLen-1){
				switch(status){
					case 0:
						wort = wort + silbeKV();
						status = randomNumber(1, 2);
						break;
					case 1:
						wort = wort + silbeKA();
						if(wort.endsWith("'")){
							status = 0;
						}else{
							status = randomNumber(1, 2);
						}
						break;
					case 2:
						tempSilbe = silbeAV();
						wort.concat(tempSilbe);
						if(tempSilbe.startsWith("'")){
							status = 0;
						}else{
							status = randomNumber(1, 2);
						}					
				}
				silbenNummer++;
			}
			wort = wort + silbeVerbEnd();
			TaubischString temp = new TaubischString(wort);
			if(alleTauben.search(temp) != null){
				return erzeugeVerb(wortLen, alreadyGeneratedExeptions+1);
			}else{
				alleTauben.insert(temp);
				return temp;
			}
		}
	}

	public void printTranslationList(){
		translationList.toFirst();
		while(translationList.hasAccess()){
			System.out.println(translationList.getContent().getDeutsch() + ": " + translationList.getContent().getTaubischString());
            translationList.next();
		}
	}
	
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
		return s1;
	}
	
	public String silbeVerbEnd(){
	    String sVE = silbeKV();
		return sVE;
	}
	
	public String silbeEnd(){
	    String sE = silbeKA();
		return sE;
	}

	public String silbe1Adj(){
        return "sa"; //(scha)
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
	
	
	public void constructorOutput(boolean pBoo){
		if(pBoo){

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
		
		System.out.println("\n|A-V|");
		for(int i = 0; i<5; i++){
		    System.out.println(silbeAV());
	    }
	    System.out.println("\n|K-V|");
		for(int i = 0; i<5; i++){
		    System.out.println(silbeKV());
	    }
	    System.out.println("\n|K-A|");
		for(int i = 0; i<5; i++){
		    System.out.println(silbeKA());
	    }
		System.out.println("\n...done \n");
		}
	}
	// / / / / /
}