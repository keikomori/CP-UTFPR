package analisador;

class Item {
    private String token;
    private String lexema;
    
    public Item(){        
    }
    public String getToken(){
        return token;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getLexema(){
        return lexema;
    }
    public void setLexema(String lexema){
        this.lexema = lexema;
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
//        else if (numero.(this.lexema)) {
//            return "NUM";
//        } 
        else if (identificador().equals("valido")) {
            return "ID";
        }
        return "erro";
    }
    public String identificador() {
        for (int i = 0; i < lexema.length(); i++) {
            char ch = lexema.charAt(i);
            if (i == 0) {
                if (lexema.matches(token)) {
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

    private boolean numero(String campo){           
        return campo.matches("^\\d+\\d?$");   
}
    
    @Override
    public String toString(){
        return "<"+token+","+lexema+">";
    }
}
