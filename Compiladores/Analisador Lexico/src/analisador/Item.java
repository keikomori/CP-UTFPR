package analisador;

public class Item {
    private String token;
    private String lexema = "";
    private Integer linha;
    private String id;
   
    public String getToken(){
        return token;
    }
    
    public void setToken(String token){
        this.token = token;
    }
    
    public void setToken(Item token){
        this.linha = token.getLinha();
        this.id = token.getId();
        this.lexema = token.lexemaToken();
    }
    
    public String getLexema(){
        //return lexema;
        return lexema;
    }
    
    public void setLexema(String lexema){
        this.lexema = lexema;
        
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public Integer getLinha(){
        return linha;
    }
    
    public void setLinha(){
        this.linha = linha;
    }
    
    public String lexemaToken() {
        if (lexema.equals("if")) {
            return "IF";
        } else if (lexema.equals("then")) {
            return "THEN";
        } else if (lexema.equals("else")) {
            return "ELSE";
        } else if (lexema.equals("end")) {
            return "END";
        } else if (lexema.equals("repeat")) {
            return "REPEAT";
        } else if (lexema.equals("until")) {
            return "UNTIL";
        } else if (lexema.equals("read")) {
            return "READ";
        } else if (lexema.equals("write")) {
            return "WRITE";
        } else if (lexema.equals("+")) {
            return "PLUS";
        } else if (lexema.equals("-")) {
            return "MINUS";
        } else if (lexema.equals("*")) {
            return "TIMES";
        } else if (lexema.equals("/")) {
            return "DIV";
        } else if (lexema.equals("=")) {
            return "EQUAL";
        } else if (lexema.equals("<")) {
            return "LESS";
        } else if (lexema.equals("(")) {
            return "LBRACKET";
        } else if (lexema.equals(")")) {
            return "RBRACKET";
        } else if (lexema.equals(";")) {
            return "DOTCOMA";
        } else if (lexema.equals(":=")) {
            return "ATRIB";
        } 
        else if (campoNumerico(this.lexema)) {
            return "NUM";
        } 
        else if (identificador().equals("valido")) {
            return "ID";
        }
        return "erro";
    }
    private boolean campoNumerico(String campo){           
        return campo.matches("[0-9]+");   
}
    public boolean numerico(String campo){           
            return campo.matches("[0-9]*");   
    }
    public String numeral() {
        for (int i = 0; i < lexema.length(); i++) {
            char ch = lexema.charAt(i);
            if (ch < 48 || ch > 57) {

                return "NUMERO";
            }
        }
        return "valido";
    }

    public String identificador() {
        for (int i = 0; i < lexema.length(); i++) {
            char ch = lexema.charAt(i);
            if (i == 0) {
                if (ch < 97 || ch > 122) {
                    if (ch < 48 || ch > 57) {
                        return "NUMERO";
                    }
                    return "IDENTIFICADOR";
                }
            } else if (i > 0) {
                if (ch < 48 || ch > 122) {

                    return "IDENTIFICADOR";
                } else if (ch != 95) {
                    if (ch > 57 && ch < 97) {

                        return "IDENTIFICADOR";
                    }
                }
            }
        }
        return "valido";
    }
    public String imprimir() {
        String text;
        text = "<" + this.getId() + ", " + this.getLinha() + ">";
        return text;
    }
    @Override
    public String toString(){
//        if (lexema.isEmpty())
//            return "<" + token + ">";
//        else
//            return "<" + token + ">";
        if (lexema.isEmpty())
            return "<" + lexemaToken() + ">";
        else
            return "<" + lexemaToken() + ">";
    }
}
