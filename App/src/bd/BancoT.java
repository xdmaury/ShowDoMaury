    package bd;

 
 
public class BancoT extends Banco {
	public static String getvarchar(int num){
		
		return " varchar("+num+")";
		
	}
	  public BancoT(boolean exe) {
        super(exe);
    }
 		
  public BancoT() {
        super(true);
    }
 		
	public static String blob="blob";
	public static String varchar="varchar(250)";
	public static String integer="integer";
	public static String numero="float";
	public static String real="float ";
	public static String auto_increment="INTEGER PRIMARY KEY AUTO_INCREMENT";
	public static String date="date";
        public static String datetime="datetime";
	public static String text="text";
	 	
	 
        
	 
	public static String usuario="usuario";
	public static colunaT usuario_nome=new colunaT("usuario_nome", 
			usuario,varchar,true,"Nome ");
        public static colunaT usuario_senha=new colunaT("usuario_senha", 
			usuario,getvarchar(50),true,"Senha ");
	
        
        public static String perguntas="perguntas";
        public static colunaT perguntas_IdPergunta=new colunaT("perguntas_IdPergunta", 
			perguntas,integer,true,"IdPergunta ");
        public static colunaT perguntas_pergunta=new colunaT("perguntas_pergunta", 
			perguntas,getvarchar(100),true,"pergunta ");
        public static colunaT perguntas_Idcategoria=new colunaT("perguntas_Idcategoria", 
			perguntas,integer,true,"categoria ");
        
        public static String categoria="categoria";
        public static colunaT categoria_Idcategoria=new colunaT("categoria_Idcategoria", 
			categoria,integer,true,"IdCategoria ");
        public static colunaT categoria_nome=new colunaT("categoria_nome", 
			categoria,getvarchar(100),true,"nome ");
        
        public static String alternativas="alternativas";
        public static colunaT alternativas_Idcategoria=new colunaT("alternativas_Idcategoria", 
			alternativas,integer,true,"IdCategoria ");
         public static colunaT alternativas_IdPergunta=new colunaT("alternativas_IdPergunta", 
			alternativas,integer,true,"IdPergunta ");
          public static colunaT alternativas_IdResposta=new colunaT("alternativas_IdResposta", 
			alternativas,integer,true,"IdResposta ");
        public static colunaT alternativas_resposta=new colunaT("alternativas_resposta", 
			alternativas,getvarchar(100),true,"resposta ");
	
}