import java.io.File;
import java.io.FileReader;
import java.io.IOException;



import java.io.FileWriter;
public class Lexical{
    public static void main(String[] args) {
        File file = new File(args[0]);
        FileWriter myWriter;
        String forKontrol="";
        String intKontrol="";
        String charKontrol="";
        String returnKontrol="";
        String intsayi="";
        String equalskontrol="";

        try
        {
            FileReader fr = new FileReader(file);
            myWriter = new FileWriter(args[1]);
            
            int content;
            while ((content = fr.read()) != -1){
                if(content>=65 && content<=90|| content>=97 && content<=122){//harf gelirse buyuk veya kucuk.
                    if(intsayi.length()!=0){//eger integer bir degerden sonra harf gelirse unknown identifier diye hata mesaji intsayi degerin tutulup kontrol edildigi string.
                        intsayi=intsayi+""+(char)content;
                        myWriter.write("ERROR TYPE :Unknown identifier:"+intsayi+"\n");
                        myWriter.flush();
                        System.exit(0);
                    }else if(forKontrol.equals("for")){//fordan sonra baska harf geldi mi diye kontrol ediyor(forkontrol bu degeri kontrol eden string).
                        forKontrol=forKontrol+""+(char)content;
                        myWriter.write("ERROR TYPE :Unknown identifier:"+forKontrol+"\n");
                        myWriter.flush();
                        System.exit(0);
                    }else if(intKontrol.equals("int")){//intden sonra baska harf geldi mi diye kontrol ediyor.
                        intKontrol=intKontrol+""+(char)content;
                        myWriter.write("ERROR TYPE :Unknown identifier:"+intKontrol+"\n");
                        myWriter.flush();
                        System.exit(0);
                    }else if(charKontrol.equals("char")){//charden sonra baska harf geldi mi diye kontrol ediyor.
                        charKontrol=charKontrol+""+(char)content;
                        myWriter.write("ERROR TYPE :Unknown identifier:"+charKontrol+"\n");
                        myWriter.flush();
                        System.exit(0);
                    }else if(returnKontrol.equals("return")){//returnden sonra baska harf geldi mi diye kontrol ediyor.
                        returnKontrol=returnKontrol+""+(char)content;
                        myWriter.write("ERROR TYPE :Unknown identifier:"+returnKontrol+"\n");
                        myWriter.flush();
                        System.exit(0);
                    }else if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\t\tNext lexeme is "+equalskontrol+"\n");
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\t\tNext lexeme is "+equalskontrol+"\n");
                        }
                        equalskontrol="";
                    }
                    int content1;
                    content1 = fr.read();//content1 harf geldikten sonra kontrol yapmami saglayan deger.  
                    if(content1==13||(char)content1==' '||content1==-1){//Eger harften sonra new line(13)-file sonu-bosluk gelmisse(contente identifier diyebiliriz.)
                        myWriter.write("Next token is identifier\t\tNext lexeme is "+(char)content+"\n");
                        myWriter.flush();    
                    }else if((char)content=='r'&&(char)content1=='e'){//return kelimesi kontrolu.
                        int contentreturn;
                        contentreturn = fr.read();
                        if((char)contentreturn=='t'){//dogru bir sekilde devam ediyor.   
                            int contentreturn1;
                            contentreturn1 = fr.read();
                            if((char)contentreturn1=='u'){//dogru bir sekilde devam ediyor.
                                 int contentreturn2;
                                contentreturn2 = fr.read();
                                if((char)contentreturn2=='r'){
                                    int contentreturn3;
                                    contentreturn3 = fr.read();
                                    if((char)contentreturn3=='n'){
                                        myWriter.write("Next token is RETURN_STMT\t\tNext lexeme is return\n");
                                        myWriter.flush();
                                        returnKontrol="return";//burada return kontrole return degerini ekliyorum.Bir sonraki eger harf gelirse unknown
                                    }else if(contentreturn3>=65 && contentreturn3<=90||contentreturn3>=97 && contentreturn3<=122){//n harici bir harf ise
                                        String s1=(char)content+""+(char)content1+""+(char)contentreturn+""+(char)contentreturn1+""+(char)contentreturn2+""+(char)contentreturn3;
                                        myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                                        myWriter.flush(); 
                                        System.exit(0);
                                    }else if((char)contentreturn3=='\n'||(char)contentreturn3==' '||(contentreturn3 >=48 && contentreturn3<=57)){
                                        String s1=(char)content+""+(char)content1+""+(char)contentreturn+""+(char)contentreturn1+""+(char)contentreturn2+""+(char)contentreturn3;
                                        myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                                        myWriter.flush();
                                        System.exit(0);
                                    }
                                    else if(!( (char)contentreturn3=='('|| (char)contentreturn3==')'||(char)contentreturn3=='='||(char)contentreturn3==';'||(char)contentreturn3=='/'
                                    ||(char)contentreturn3=='<'||(char)contentreturn3=='>'||(char)contentreturn3=='{'||(char)contentreturn3=='}'||(char)contentreturn3=='-' ||(char)contentreturn3=='*' ||(char)contentreturn3=='+') ){
                                         myWriter.write("ERROR TYPE :Unknown operator:"+(char)contentreturn3+"\n");
                                         myWriter.flush();
                                        System.exit(0);
                                    }
                                }else if(contentreturn2>=65 && contentreturn2<=90||contentreturn2>=97 && contentreturn2<=122){//r harici bir harf ise
                                    String s1=(char)content+""+(char)content1+""+(char)contentreturn+""+(char)contentreturn1+""+(char)contentreturn2;
                                    myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                                    myWriter.flush(); 
                                    System.exit(0);
                                }else if((char)contentreturn2=='\n'||(char)contentreturn2==' '||(contentreturn2 >=48 && contentreturn2<=57)){
                                    String s1=(char)content+""+(char)content1+""+(char)contentreturn+""+(char)contentreturn1+""+(char)contentreturn2;
                                    myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                                    myWriter.flush();
                                    System.exit(0);
                                }
                                else if(!( (char)contentreturn2=='('|| (char)contentreturn2==')'||(char)contentreturn2=='='||(char)contentreturn2==';'||(char)contentreturn2=='/'
                                ||(char)contentreturn2=='<'||(char)contentreturn2=='>'||(char)contentreturn2=='{'||(char)contentreturn2=='}'||(char)contentreturn2=='-' ||(char)contentreturn2=='*' ||(char)contentreturn2=='+') ){
                                    myWriter.write("ERROR TYPE :Unknown operator:"+(char)contentreturn2+"\n");
                                    myWriter.flush();
                                    System.exit(0);
                                }
                                    
                            }else if(contentreturn1>=65 && contentreturn1<=90||contentreturn1>=97 && contentreturn1<=122){//r harici bir harf ise
                                String s1=(char)content+""+(char)content1+""+(char)contentreturn+""+(char)contentreturn1;
                                myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                                myWriter.flush(); 
                                System.exit(0);
                            }else if((char)contentreturn1=='\n'||(char)contentreturn1==' '||(contentreturn1 >=48 && contentreturn1<=57)){
                                String s1=(char)content+""+(char)content1+""+(char)contentreturn+""+(char)contentreturn1;
                                myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                                myWriter.flush();
                                System.exit(0);
                            }
                            else if(!( (char)contentreturn1=='('|| (char)contentreturn1==')'||(char)contentreturn1=='='||(char)contentreturn1==';'||(char)contentreturn1=='/'
                            ||(char)contentreturn1=='<'||(char)contentreturn1=='>'||(char)contentreturn1=='{'||(char)contentreturn1=='}'||(char)contentreturn1=='-' ||(char)contentreturn1=='*' ||(char)contentreturn1=='+') ){
                                myWriter.write("ERROR TYPE :Unknown operator:"+(char)contentreturn1+"\n");
                                myWriter.flush();
                                System.exit(0);
                            }
                               
                            
                        }else if(contentreturn>=65 && contentreturn<=90||contentreturn>=97 && contentreturn<=122){//r harici bir harf ise
                            String s1=(char)content+""+(char)content1+""+(char)contentreturn;
                            myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                            myWriter.flush(); 
                            System.exit(0);
                        }else if((char)contentreturn=='\n'||(char)contentreturn==' '||(contentreturn >=48 && contentreturn<=57)){
                            String s1=(char)content+""+(char)content1+""+(char)contentreturn;
                            myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                            myWriter.flush();
                            System.exit(0);
                        }
                        else if(!( (char)contentreturn=='('|| (char)contentreturn==')'||(char)contentreturn=='='||(char)contentreturn==';'||(char)contentreturn=='/'
                        ||(char)contentreturn=='<'||(char)contentreturn=='>'||(char)contentreturn=='{'||(char)contentreturn=='}'||(char)contentreturn=='-' ||(char)contentreturn=='*' ||(char)contentreturn=='+') ){
                            myWriter.write("ERROR TYPE :Unknown operator:"+(char)contentreturn+"\n");
                            myWriter.flush();
                            System.exit(0);
                        }   
                            
                    }
                    else if((char)content=='c'&&(char)content1=='h'){//char kelimesi kontrolu.
                        int contentchar;
                        contentchar = fr.read();
                        if((char)contentchar=='a'){   
                            int contentchar1;
                            contentchar1 = fr.read();
                            if((char)contentchar1=='r'){
                                myWriter.write("Next token is CHAR_TYPE\t\tNext lexeme is char\n");
                                myWriter.flush();
                                charKontrol="char";
                            }else if(contentchar1>=65 && contentchar1<=90||contentchar1>=97 && contentchar1<=122){//r harici bir harf ise
                                String s1=(char)content+""+(char)content1+""+(char)contentchar+""+(char)contentchar1;
                                myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n"); 
                                myWriter.flush();
                                System.exit(0);
                            }else if((char)contentchar1=='\n'||(char)contentchar1==' '||(contentchar1 >=48 && contentchar1<=57)){
                                String s1=(char)content+""+(char)content1+""+(char)contentchar+""+(char)contentchar1;
                                myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                                myWriter.flush();
                                System.exit(0);
                            }
                            else if(!( (char)contentchar1=='('|| (char)contentchar1==')'||(char)contentchar1=='='||(char)contentchar1==';'||(char)contentchar1=='/'
                            ||(char)contentchar1=='<'||(char)contentchar1=='>'||(char)contentchar1=='{'||(char)contentchar1=='}'||(char)contentchar1=='-' ||(char)contentchar1=='*' ||(char)contentchar1=='+') ){
                                myWriter.write("ERROR TYPE :Unknown operator:"+(char)contentchar1+"\n");
                                myWriter.flush();
                                System.exit(0);
                            }
                                
                        }else if(contentchar>=65 && contentchar<=90||contentchar>=97 && contentchar<=122){//r harici bir harf ise
                            String s1=(char)content+""+(char)content1+""+(char)contentchar;
                            myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n"); 
                            myWriter.flush();
                            System.exit(0);
                        }else if((char)contentchar=='\n'||(char)contentchar==' '||(contentchar >=48 && contentchar<=57)){
                            String s1=(char)content+""+(char)content1+""+(char)contentchar;
                            myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                            myWriter.flush();
                            System.exit(0);
                        }
                        else if(!( (char)contentchar=='('|| (char)contentchar==')'||(char)contentchar=='='||(char)contentchar==';'||(char)contentchar=='/'
                        ||(char)contentchar=='<'||(char)contentchar=='>'||(char)contentchar=='{'||(char)contentchar=='}'||(char)contentchar=='-' ||(char)contentchar=='*' ||(char)contentchar=='+') ){
                            myWriter.write("ERROR TYPE :Unknown operator:"+(char)contentchar+"\n");
                            myWriter.flush();
                            System.exit(0);
                        }
                            
                    }else if((char)content=='f'&&(char)content1=='o'){
                        int contentFor2;
                        contentFor2 = fr.read();
                        if((char)contentFor2=='r'){   
                            myWriter.write("Next token is FOR_STATEMENT\t\tNext lexeme is for\n");
                            myWriter.flush();
                            forKontrol="for";
                            //System.out.println("sda");
                           
                        }else if(contentFor2>=65 && contentFor2<=90||contentFor2>=97 && contentFor2<=122){//r harici bir harf ise
                            String s1=(char)content+""+(char)content1+""+(char)contentFor2;
                            myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n"); 
                            myWriter.flush();
                            System.exit(0);
                        }else if((char)contentFor2=='\n'||(char)contentFor2==' '||(contentFor2 >=48 && contentFor2<=57)){
                            String s1=(char)content+""+(char)content1+""+(char)contentFor2;
                            myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                            myWriter.flush();
                            System.exit(0);
                        }
                        else if(!( (char)contentFor2=='('|| (char)contentFor2==')'||(char)contentFor2=='='||(char)contentFor2==';'||(char)contentFor2=='/'
                        ||(char)contentFor2=='<'||(char)contentFor2=='>'||(char)contentFor2=='{'||(char)contentFor2=='}'||(char)contentFor2=='-' ||(char)contentFor2=='*' ||(char)contentFor2=='+') ){
                            myWriter.write("ERROR TYPE :Unknown operator:"+(char)contentFor2+"\n");
                            myWriter.flush();
                            System.exit(0);
                        }    
                    }else if((char)content=='i'&&(char)content1=='n'){
                       
                        int contentint;
                        contentint = fr.read();
                        if((char)contentint=='t'){   
                            myWriter.write("Next token is INT_TYPE\t\t\tNext lexeme is int\n");
                            myWriter.flush();
                            intKontrol="int";
                        }else if(contentint>=65 && contentint<=90||contentint>=97 && contentint<=122){//r harici bir harf ise
                            String s1=(char)content+""+(char)content1+""+(char)contentint;
                            myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n"); 
                            myWriter.flush();
                            System.exit(0);
                        }else if((char)contentint=='\n'||(char)contentint==' '||(contentint >=48 && contentint<=57)){
                            String s1=(char)content+""+(char)content1+""+(char)contentint;
                            myWriter.write("ERROR TYPE :Unknown identifier:"+s1+"\n");
                            myWriter.flush();
                            System.exit(0);
                        }
                        else if(!( (char)contentint=='('|| (char)contentint==')'||(char)contentint=='='||(char)contentint==';'||(char)contentint=='/'
                        ||(char)contentint=='<'||(char)contentint=='>'||(char)contentint=='{'||(char)contentint=='}'||(char)contentint=='-' ||(char)contentint=='*' ||(char)contentint=='+') ){
                            myWriter.write("ERROR TYPE :Unknown operator:"+(char)contentint+"\n");
                            myWriter.flush();
                            System.exit(0);
                        }    
                    //bunlar tek harften sonra gelen tokenlerin kontrolu
                    }else if(content1 >=48 && content1<=57){//harften sonra sayi
                        myWriter.write("ERROR TYPE :Unknown identifier:"+(char)content+""+(char)content1+"\n");
                        myWriter.flush();
                        System.exit(0);
                    }else if(!(content1==13||content1==10||(char)content1==' ') && !(content1>=65 && content1<=90|| content1>=97 && content1<=122)){
                        
                        if((char)content1==';'){
                            myWriter.write("Next token is  identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is SEMICOLON\t\t\tNext lexeme is ;\n");
                            myWriter.flush();
                                          
                        }else if((char)content1=='+'){
                            myWriter.write("Next token is  identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is ADD\t\t\t\tNext lexeme is +\n");              
                            myWriter.flush();
                        }else if((char)content1=='-'){
                            myWriter.write("Next token is  identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is SUBT\t\t\tNext lexeme is -\n");              
                            myWriter.flush();
                        }else if((char)content1=='*'){
                            myWriter.write("Next token is  identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is MULT\t\t\tNext lexeme is *\n");
                            myWriter.flush();
                        }else if((char)content1=='/'){
                            myWriter.write("Next token is identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is DIV\t\t\tNext lexeme is /\n");
                            myWriter.flush();
                        }else if((char)content1=='{'){
                            myWriter.write("Next token is identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is LCURLYB\t\t\tNext lexeme is {\n");
                            myWriter.flush();
                        }else if((char)content1=='}'){
                            myWriter.write("Next token is identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is RCURLYB\t\t\tNext lexeme is }\n");
                            myWriter.flush();
                        }else if((char)content1=='('){
                            myWriter.write("Next token is identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is LPARANT\t\t\tNext lexeme is (\n");
                            myWriter.flush();
                        }else if((char)content1==')'){
                            myWriter.write("Next token is identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is RPARANT\t\t\tNext lexeme is )\n");
                            myWriter.flush();
                        }else if((char)content1=='='){
                            myWriter.write("Next token is identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            myWriter.write("Next token is ASSIGNM\t\t\tNext lexeme is =\n");
                            myWriter.flush();
                        }else if((char)content1=='<'||(char)content1=='>'){
                            
                            myWriter.write("Next token is identifier\t\tNext lexeme is "+(char)content+"\n");
                            myWriter.flush();
                            equalskontrol=(char)content1+"";
                            //System.out.println((equalskontrol));
                        }else{
                           //ss
                            myWriter.write("ERROR TYPE :Unknown operator:"+(char)content1);
                            myWriter.flush();
                            System.exit(0);

                        }

                    }else{
                        myWriter.write("ERROR TYPE :Unknown identifier:"+(char)content+(char)content1+"\n");
                        myWriter.flush();
                        System.exit(0);
                    }                    
                }else if((char)content=='<'||(char)content=='>'){
                    equalskontrol=(char)content+"";
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                }else if((char)content==';'){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    
                    myWriter.write("Next token is SEMICOLON\t\t\tNext lexeme is ;\n");
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                                 
                }else if((char)content=='+'){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    myWriter.write("Next token is ADD\t\t\t\tNext lexeme is +\n");              
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                    
                }else if((char)content=='-'){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    myWriter.write("Next token is SUBT\t\t\tNext lexeme is -\n");              
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                }else if((char)content=='*'){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    myWriter.write("Next token is MULT\t\t\tNext lexeme is *\n");
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                }else if((char)content=='/'){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    
                    
                    myWriter.write("Next token is DIV\t\t\tNext lexeme is /\n");
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                }else if((char)content=='{'){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    myWriter.write("Next token is LCURLYB\t\t\tNext lexeme is {\n");
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                }else if((char)content=='}'){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    myWriter.write("Next token is RCURLYB\t\t\tNext lexeme is }\n");
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                }else if((char)content=='('){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    myWriter.write("Next token is LPARANT\t\t\tNext lexeme is (\n");
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                }else if((char)content==')'){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    myWriter.write("Next token is RPARANT\t\t\tNext lexeme is )\n");
                    myWriter.flush();
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                }else if((char)content=='='){
                    equalskontrol+=""+(char)(content);
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<=")){
                            myWriter.write("Next token is LESS_EQ\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">=")){
                            myWriter.write("Next token is GRE_EQ\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals("=")){
                            myWriter.write("Next token is ASSIGNM\t\t\tNext lexeme is =\n");
                            myWriter.flush();
                            equalskontrol="";
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                    
                }else if((char)content==' '||(char)content==13 ||(char)content==10){
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    if(intsayi.length()!=0){
                        myWriter.write("Next token is INT_LIT\t\t\tNext lexeme is "+intsayi+"\n");
                        myWriter.flush();
                        intsayi="";

                    }
                    forKontrol="";
                    intKontrol="";
                    charKontrol="";
                    returnKontrol="";
                    
                }else if(content >=48 && content<=57){//integerlar icin kontrol.
                    if(equalskontrol.length()!=0){
                        if(equalskontrol.equals("<")){
                            myWriter.write("Next token is LESS\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }else if(equalskontrol.equals(">")){
                            myWriter.write("Next token is GREATER\t\t\tNext lexeme is "+equalskontrol+"\n");
                            myWriter.flush();
                        }
                        equalskontrol="";
                    }
                    intsayi+= (char)content+"";
                   
                }else{
                    myWriter.write("ERROR TYPE :Unknown operator:"+(char)content);
                    //System.out.println("sdasd");
                    myWriter.flush();
                    System.exit(0);
                }


            }
            myWriter.flush();
            myWriter.close();
        
            
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }





}
