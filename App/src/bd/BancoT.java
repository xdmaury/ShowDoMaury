package bd;

public class BancoT extends Banco {

    public static String getvarchar(int num) {

        return " varchar(" + num + ")";

    }

    public BancoT(boolean exe) {
        super(exe);
    }

    public BancoT() {
        super(true);
    }

    public static String blob = "blob";
    public static String varchar = "varchar(250)";
    public static String integer = "integer";
    public static String numero = "float";
    public static String real = "float ";
    public static String auto_increment = "INTEGER PRIMARY KEY AUTO_INCREMENT";
    public static String date = "date";
    public static String datetime = "datetime";
    public static String text = "text";

    public static String usuario = "usuario";
    public static colunaT usuario_nome = new colunaT("usuario_nome",
            usuario, varchar, true, "Nome ");
    public static colunaT usuario_senha = new colunaT("usuario_senha",
            usuario, getvarchar(50), true, "Senha ");

    public static String perguntas = "perguntas";
    public static colunaT perguntas_IdPergunta = new colunaT("perguntas_IdPergunta",
            perguntas, auto_increment, true, "IdPergunta ");
    public static colunaT perguntas_pergunta = new colunaT("perguntas_pergunta",
            perguntas, getvarchar(100), true, "pergunta ");




    public static String alternativas = "alternativas";
    public static colunaT alternativas_IdPergunta = new colunaT("alternativas_IdPergunta",
            alternativas, integer, true, "IdPergunta ");
    public static colunaT alternativas_IdAlternativa = new colunaT("alternativas_IdAlternativa",
            alternativas, auto_increment, true, "IdAlternativa ");
    public static colunaT alternativas_resposta1 = new colunaT("alternativas_resposta1",
            alternativas, getvarchar(100), true, "resposta1 ");
    public static colunaT alternativas_resposta2 = new colunaT("alternativas_resposta2",
            alternativas, getvarchar(100), true, "resposta2 ");
    public static colunaT alternativas_resposta3 = new colunaT("alternativas_resposta3",
            alternativas, getvarchar(100), true, "resposta3 ");
    public static colunaT alternativas_resposta4 = new colunaT("alternativas_resposta4",
            alternativas, getvarchar(100), true, "resposta4 ");
    public static colunaT alternativas_resposta_correta = new colunaT("alternativas_resposta_correta",
            alternativas, integer, true, "resposta_correta ");
    
}
