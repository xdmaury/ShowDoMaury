package  bd;

import javax.swing.JTextField;

 
 
public 
class colunaT implements Cloneable {
    
    
    public String avulso="";
	boolean autoincrement=false;
	public String nomePref="";
	public String pselect="";
	public String pcreate="";
 String coluna="";
 String tabela="";
	 Object dados="";
public String tipo="";
boolean estado=true;
public static int like=0;
public static int and=1;
public static int or=2;
public static int igual=3;
public static  int like1=4;
public static  int maiorigual=5;
public static  int menorigual=6;
public boolean sinc=true; 
public String total="";
public  int mtipo=-1;
int ct=-1;
boolean soma=false;
public boolean natabela=true;
public boolean natabelausuario=true;

public String proximowhere="and";
public String condicao="=";

    public colunaT setAvulso(String avulso) {
                this.avulso = avulso;

        return this;
    }

    public String getAvulso() {
        return avulso;
    }





    public String getProximowhere() {
        return proximowhere;
    }

    public colunaT setProximowhere(String proximowhere) {
        this.proximowhere = proximowhere;
        return this;
    }

    public String getCondicao() {
        return condicao;
    }

    public colunaT setCondicao(String condicao) {
        this.condicao = condicao;
        return this;
    }

    
    

public colunaT(String coluna,String tabela,String tipo,boolean estado,String nomePref,boolean natabela){
	this.coluna=coluna;
	this.tabela=tabela;
	 this.tipo=tipo;
	 this.natabela=natabela;
	 if(tipo.contentEquals( BancoT.auto_increment))autoincrement=true;
	 this.estado=estado;
	 coluna=tabela+"."+coluna;
	 this.nomePref=nomePref;
	 if (estado)
     {
         boolean b = true;
         for (int cont = 0; cont < Banco.tabelas.size(); cont++)
         {

             if (Banco.tabelas.get(cont).C().contentEquals(C())&&
            		 Banco.tabelas.get(cont).T().contentEquals(T()
                 ))
             {

                 b = false;
             }

         }
         if (b)
             Banco.tabelas.add(this);
     }
	 
	
	 

}





public colunaT(String coluna,String tabela,String tipo,boolean estado,String nomePref){
	this.coluna=coluna;
	this.tabela=tabela;
	 this.tipo=tipo;
	 if(tipo.contentEquals( BancoT.auto_increment))autoincrement=true;
	 this.estado=estado;
	 coluna=tabela+"."+coluna;
	 this.nomePref=nomePref;
	 if (estado)
     {
         boolean b = true;
         for (int cont = 0; cont < Banco.tabelas.size(); cont++)
         {

             if (Banco.tabelas.get(cont).C().contentEquals(C())&&
            		 Banco.tabelas.get(cont).T().contentEquals(T()
                 ))
             {

                 b = false;
             }

         }
         if (b)
             Banco.tabelas.add(this);
     }
	 
	
	 

}
	public colunaT(String coluna,String tabela,String tipo,boolean estado){
		this.coluna=coluna;
		this.tabela=tabela;
		 this.tipo=tipo;
		 if(tipo.contentEquals( BancoT.auto_increment))autoincrement=true;
		 this.estado=estado;
		 coluna=tabela+"."+coluna;
		 this.nomePref=coluna;
		 if (estado)
	     {
	         boolean b = true;
	         for (int cont = 0; cont < Banco.tabelas.size(); cont++)
	         {

	             if (Banco.tabelas.get(cont).C().contentEquals(C())&&
	            		 Banco.tabelas.get(cont).T().contentEquals(T()
	                 ))
	             {

	                 b = false;
	             }

	         }
	         if (b)
	             Banco.tabelas.add(this);
	     }	 
	}
	
	
	
	public colunaT(String coluna,String tabela,String tipo,boolean estado,boolean sinc){
		this.coluna=coluna;
		this.tabela=tabela;
		 this.tipo=tipo;
		 this.sinc=sinc;
		 if(tipo.contentEquals( BancoT.auto_increment))autoincrement=true;
		 this.estado=estado;
		 coluna=tabela+"."+coluna;
		 this.nomePref=coluna;
		 if (estado)
	     {
	         boolean b = true;
	         for (int cont = 0; cont < Banco.tabelas.size(); cont++)
	         {

	             if (Banco.tabelas.get(cont).C().contentEquals(C())&&
	            		 Banco.tabelas.get(cont).T().contentEquals(T()
	                 ))
	             {

	                 b = false;
	             }

	         }
	         if (b)
	             Banco.tabelas.add(this);
	     } 
	}
	
	
	
	
	
	public void setSoma(boolean soma){
		
		this.soma=soma;
		
	}
	
	public boolean getSoma(){return soma;}
	public colunaT CS(String coluna){
		this.coluna=coluna;
		return this;
	}
	
	
	
	public void setTotal(String total){
		
		this.total=total;
		
		
	}
	
	
	public String getTotal(){
		
		return this.total;
		
	}
	
	public String S(){
		return D()+"";
		
	}
	
	public String DD(){
		 
		if(((String)dados).length()==0)return "-1";
		return ((String)dados).replaceAll(",", ".");
		
	}
	
	public Object D(){
		if(tipo.contentEquals(BancoT.date)){
			 
			String cv[]=(dados+"").split("/");
			
			if(cv.length==3){
				
			if(cv[0].length()!=4){
				
				dados=cv[2]+"/"+((cv[1].length()!=2)?"0"+cv[1]:cv[1])+"/"+((cv[0].length()!=2)?"0"+cv[0]:cv[0]);
			}	
				
				
			}else dados="2001/1/1";
			
		}
		
		return dados;
		
	}
	public void add(Object ob){
		dados=ob+"";
		
	}
	
	
	public colunaT SD(String dados,int mtipo,int ct){
		this.dados=dados;
		this.mtipo=mtipo;
		this.ct=ct;
		
		return this;
		
	}
	public colunaT Dado(String dados){
		this.dados=dados;
		return this.clone();
		
	}
        
         public colunaT Dado(JTextField dados){
		this.dados=dados.getText();
		return this.clone();
		
	}
        public colunaT Dado(Object dados){
		this.dados=dados;
		return this.clone();
		
	}
	public String T(){
		
		return tabela;
		
	}
public String CT(){
		
		return tabela+"."+coluna;
		
	}

public String C(){
	
	return  coluna;
	
}
 

public String CPref(){
	
	return nomePref;
	
}
public String P(){
	
	return tipo;
	
}
	
public boolean E(){
	
	return estado;
	
}

public String pSelect(){
	
	return pselect;
	
}
public String pCreate(){
	
	return pcreate;
	
}

public colunaT clone()  {
    try {
    	
		return (colunaT) super.clone();
		
	} catch (CloneNotSupportedException e) {
		 
		e.printStackTrace();
		return null;
	}
}




}
