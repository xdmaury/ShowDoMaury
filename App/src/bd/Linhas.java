package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Linhas implements Cloneable{
	 public Statement statement=null;
	  public ResultSet  cursor=null;
	int ncoluna=0;
	int nlinhas=0;
	int vez=0;
	int colunarealT=0;
	public int cont=-1;
	public String table="";
	public colunaT colunas[]=null;
	public colunaT colunasrealT[]=null;
	public String consulta="";
	public String ordena="desc";
	public String novaconsulta="";
 public String consultaI="";
  
	public void add( Statement statement,Banco banco,String tabs,colunaT colunas[],String consultaI,String consulta){
		this.consultaI=consultaI;
             try {
                 this.statement=statement;
                 
 		this.cursor=statement.executeQuery(consultaI);
		           
		this.table=tabs;
           
                ncoluna=cursor.getMetaData().getColumnCount();
           
                cursor.last();
		nlinhas=cursor.getRow();
                cursor.beforeFirst();
		this.colunas=colunas;
		this.consulta=consulta;
		montacolunaR();
		
		
		 } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	public void add(Statement statement,String consulta,String tabs ){
 		try {
                    this.consulta=consulta;
                 this.statement=statement;
 		this.cursor=statement.executeQuery(consulta);
                
		this.table=tabs;
		   ncoluna=cursor.getMetaData().getColumnCount();
           
                cursor.last();
		nlinhas=cursor.getRow();
                cursor.beforeFirst();
		this.colunas=colunas;
                 } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
		montacolunaR();
	}
	
	
	public void reOrdena(String ordena,colunaT ...colunas){
		StringBuffer ordem=new StringBuffer("order by ");
		
		for(int cont=0;cont<colunas.length;cont++){
			
			if(cont+1==colunas.length){
				ordem.append(colunas[cont].C()+" "+ordena+" ");

				
			}else
			ordem.append(colunas[cont].C()+" "+ordena+", ");
			
			
		} 
		
		
		novaconsulta=consulta.replaceAll(BancoT.div, ordem.toString());
		
             try {
                 cursor=statement.executeQuery(novaconsulta);
                  cursor.beforeFirst();
             } catch (SQLException ex) {
                 Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
             }

vez=0;
cont=-1;

	}
	
	
	private void montacolunaR(){
	 
	 
		
		 ArrayList<colunaT> co=new ArrayList<colunaT>();
		int cs=0;
		for(int cont=0;cont<numcoluna();cont++){
			if(!getNaTabela(cont)){
				
				continue;
				
			}
			 
			co.add(colunas[cont]);
		 
		}
		
		colunasrealT= co.toArray(new colunaT[co.size()]);
            try {
                cursor.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
		vez=0;
		cont=-1;
		
	}
	
	public int numcolunaRT(){
		
		return colunasrealT.length;
		
	}
	
	public int numcoluna(){
		
		return ncoluna;
	}
	public int numlinha(){
		return size();
		
	}
	
	public int size(){
		 
		return nlinhas;
		
	}
	
public boolean real(int cont){
	
            try {
                if(cursor.getMetaData().getColumnType(cont)==6||
                        cursor.getMetaData().getColumnType(cont)==7){
                    
                    return true;
                }   } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
	
	return false;
}
	public boolean next(){
		if(size()>0&&vez==0){
			vez=1;
			cont++;
                    try {
                        return cursor.next();
                    } catch (SQLException ex) {
                        Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
 		boolean bol=false;
            try {
                bol = cursor.next();
           
		if(!bol){
			vez=0;
			cont=-1;
		cursor.beforeFirst();
		}else		cont++;
                
                
		 } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
	return bol;
		
	}
	
	public boolean getNaTabela(int ncoluna){

		 if(colunas!=null){
			 
			 return (colunas[ncoluna].natabela&&colunas[ncoluna].natabelausuario)?true:false;
			 
		 }
		 return false;	
		 
	
	
	}
	
	public String getC(int ncoluna){

		 if(colunas!=null){
			 
			 return colunas[ncoluna].coluna;
			 
		 }
            try {
                return cursor.getMetaData().getColumnName(ncoluna);
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return null;
	}

	public String getT(int ncoluna){

		 if(colunas!=null){
			 
			 return colunas[ncoluna].tipo;
			 
		 }
		return "";
	}
	
	
	
	public String getPF(int ncoluna){

		 if(colunas!=null){
			 
			 return colunas[ncoluna].nomePref;
			 
		 }
		   try {
                return cursor.getMetaData().getColumnName(ncoluna);
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return null;
	}
	
	public String getSN(colunaT c,String tx){

		String dC=(c.getSoma())?c.T()+c.C():c.C();

		
	if(( get(dC)+"").contentEquals("null")){
			
			return tx;
		}
		
		return get(c.C())+"";
		}

	public String getSN(int coluna,String tx){
		if( (get(coluna)+"").contentEquals("null")){
			
			return tx;
		}
		
		 return get(coluna)+"";

				
			}
public String getS(int coluna){
		
		
 return get(coluna)+"";

		
	}
	
public String getSDF(colunaT c){

	 String dt[]=(get(c.C())+"").split("/");
	 if(dt.length<3)return (get(c.C())+"");
return dt[2]+"/"+dt[1]+"/"+dt[0] ;
}
public String getSDF(int c){

	 
	 String dt[]=(get(c)+"").split("/");
	 if(dt.length<3)return (get(c)+"");

	 return dt[2]+"/"+dt[1]+"/"+dt[0] ;
}
public int getI(int ncoluna){

String cv=get(ncoluna)+"";
	if(cv.contains("null"))cv="0";
	
	if(cv.length()==0)return 0;;
	
	return Integer.parseInt(cv);
}
public double getD(int ncoluna){

String cv=get(ncoluna)+"";
	if(cv.contains("null"))cv="0";
	
	if(cv.length()==0)return 0;;
	
	return Double.parseDouble(cv);
}
public double getD(String ncoluna){

String cv=get(ncoluna)+"";
	if(cv.contains("null"))cv="0";
	
	return Double.parseDouble(cv);
}

public Boolean getB(int ncoluna){

	 
	if(getS(ncoluna).contains("true")||getS(ncoluna).contains("True"))
		return true;


		 
	return false;
}
public Boolean getB(String ncoluna){
if(getS(ncoluna).contains("true")||getS(ncoluna).contains("True"))
	return true;


	 
return false;

}
public String getS(String ncoluna){

	 
	return get(ncoluna)+"";
}


public Object get(String ncoluna){

	if(size()==0)return null;
	if(cont==-1)next();
	
	try{
	return cursor.getString( (ncoluna));
	}catch(Exception e){
		e.printStackTrace(); 
		
	}
	try{
		return cursor.getDouble( (ncoluna));
		}catch(Exception e){
			e.printStackTrace();  
			
		}
	return null;
}


 
public int getSI(int c){
if(getS(c).contentEquals("null"))return 0;
	 
return Integer.parseInt(get(c)+"");
}
public double getSD(colunaT c){

	 
return Double.parseDouble(get(c.C())+"");
}

public double getD(colunaT c){
	
String dC=(c.getSoma())?c.T()+c.C():c.C();
 
String cv=getS(dC);
if(cv.contains("null"))cv="0";

return Double.parseDouble(cv.replaceAll(",", "."));
}
public int getTI(colunaT c){
	String dC=(c.getSoma())?c.T()+c.C():c.C();

 
return Integer.parseInt(get(dC)+"");
}



public String getS(colunaT c){
	String dC=(c.getSoma())?c.T()+c.C():c.C();

 
return get(dC)+"";
}

 public Object get(colunaT c){
	String dC=(c.getSoma())?c.T()+c.C():c.C();

	
if(size()==0)return null;
if(cont==-1)next();
if(c.tipo.contentEquals(BancoT.date)||c.tipo.contentEquals(BancoT.datetime))
{try{
return cursor.getDate((dC));
}catch(Exception e){
	e.printStackTrace();  
	
}
}
try{
return cursor.getString( (dC));
}catch(Exception e){
	e.printStackTrace();  
	
}
try{
	return cursor.getDouble( (dC));
	}catch(Exception e){
		e.printStackTrace();  
		
	}
return null;
}

	public Object get(int coluna){
	 
		if(size()==0)return null;
		if(cont==-1)next();
 
		if(colunas[coluna].tipo.contentEquals(BancoT.real)||
                        colunas[coluna].tipo.contentEquals(BancoT.numero)){
		//	Log.d("Entrou Aqui X","Entrou Aqui X "+cursor.getFloat(coluna));
	
		try{
                    
			return cursor.getFloat(coluna+1);
			}catch(SQLException e){
				
				System.out.println("EROOO "+coluna);
			
                        e.printStackTrace(); 
                        }

		
		}
		try{
		return cursor.getString(coluna+1);
		}catch(Exception e){
                    System.out.println("EROOO 1 "+coluna);
			e.printStackTrace();  
			 
		}
		
		return null;
	}
	
	public String getS(int linha,int coluna){
            try {
                cursor.absolute(linha);
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
		
			 return get(coluna)+"";
		
	}
	
	
	public Object linha(int linha,int coluna){
		 try {
                cursor.absolute(linha);
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }

		return get(coluna);
		
	}
	public String linhaS(int linha,int coluna){
 		 try {
                cursor.absolute(linha);
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
		try{
			return cursor.getString(coluna);
			}catch(Exception e){
				e.printStackTrace();  
				
			}
			 return null;
		
	}
	
	public ArrayList ar(colunaT ...c){
             try {
                 cursor.beforeFirst();
             } catch (SQLException ex) {
                 Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
             }
		ArrayList l=new ArrayList();
	while(next()){
		String acum="";
		for(int cont=0;cont<c.length;cont++){
			
			acum+=get(c[cont].C())+"\n";
			
			
		}
		
		l.add(acum);
		
	}
            try {
                cursor.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
	return l;
		
	}
	
	
	public String[] av( ){
		vez=0;
             try {
                 cursor.beforeFirst();
             } catch (SQLException ex) {
                 Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
             }
		StringBuffer acum=new StringBuffer();
	while(next()){
		 
		for(int cont=0;cont<numcoluna();cont++){
			
			acum.append(get(cont)+BancoT.div);
			
			
		}
		
 		
	}
	vez=0;
            try {
                cursor.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
	return acum.toString().split(BancoT.div);
		
	}
	
	public ArrayList ar( ){
		vez=0;
            try {
                cursor.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
		ArrayList l=new ArrayList();
	while(next()){
		StringBuffer acum=new StringBuffer();
		for(int cont=0;cont<numcoluna();cont++){
			
			acum.append(get(cont)+", ");
			
			
		}
		
		l.add(acum.toString());
		
	}
            try {
                cursor.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
	vez=0;
	return l;
		
	}
	
	public ArrayList arC( ){
		vez=0;
            try {
                cursor.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
		ArrayList l=new ArrayList();
	while(next()){
		StringBuffer acum=new StringBuffer();
		
		for(int cont=0;cont<numcoluna();cont++){
			 
			acum.append(getC(cont)+" "+get(cont)+", ");
			
			
		}
		
		l.add(acum.toString());
		
	}
	vez=0;
            try {
                cursor.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
	return l;
		
	}
        
        public void vaiInicio(){
            	vez=0;
            try {
                cursor.beforeFirst();
            } catch (SQLException ex) {
                Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	public void dA(){
		if(size()==0)return;
		String del="delete from "+table+" where ";
		String acum="";
		
		for(int cont=0;cont<numcoluna();cont++){
                    try {	
                        acum+=" "+cursor.getMetaData().getColumnName(cont)+"='"+cursor.getString(cont)+"' and";
                    } catch (SQLException ex) {
                        Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
		acum=acum.substring(0, acum.length()-3);
             try {
                 statement.executeUpdate(del+acum);
             } catch (SQLException ex) {
                 Logger.getLogger(Linhas.class.getName()).log(Level.SEVERE, null, ex);
             }
	}
 
	
	
    
    
	public Linhas clone()  {
	    try {
	    	
			return (Linhas) super.clone();
			
		} catch (CloneNotSupportedException e) {
			 
			e.printStackTrace();
			return null;
		}
	}
 
	public Date getDate(colunaT c){
 

 
return  (Date) get(c);
}
}
