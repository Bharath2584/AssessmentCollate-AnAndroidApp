package com.project.assessmentcollate_anandroidapp;

 class SymbolTable {

         static String enc(String a) {


      /* if(Character.isAlphabetic(a))
       {
           return "alpha";
       }

       else if(Character.isDigit(a)){
           return "no";
        }

        else {
           return "spl";
       }
*/
            char[] c = a.toCharArray();

            String r = "";
            // char ch='a';
            for (char ch : c) {

            //    if(Character.isAlphabetic(ch)) {
                    switch (ch) {


                        case 'a':
                            r = r + "1234!man";
                            break;
                        case 'b':
                            r = r + "124!manj";
                            break;
                        case 'c':
                            r = r + "134!madh";
                            break;
                        case 'd':
                            r = r + "234!pint";
                            break;
                        case 'e':
                            r = r + "124!pint";
                            break;
                        case 'f':
                            r = r + "134!pint";
                            break;
                        case 'g':
                            r = r + "2345!pin";
                            break;
                        case 'h':
                            r = r + "123!pint";
                            break;
                        case 'i':
                            r = r + "1234!rav";
                            break;
                        case 'j':
                            r = r + "124!ravi";
                            break;
                        case 'k':
                            r = r + "134@madh";
                            break;
                        case 'l':
                            r = r + "234@pint";
                            break;
                        case 'm':
                            r = r + "124@pint";
                            break;
                        case 'n':
                            r = r + "134@pint";
                            break;
                        case 'o':
                            r = r + "237@pint";
                            break;
                        case 'p':
                            r = r + "123@pint";
                            break;
                        case 'q':
                            r = r + "1234@man";
                            break;
                        case 'r':
                            r = r + "12345!ma";
                            break;
                        case 's':
                            r = r + "135@madh";
                            break;
                        case 't':
                            r = r + "235@pint";
                            break;
                        case 'u':
                            r = r + "124#pint";
                            break;
                        case 'v':
                            r = r + "134#pint";
                            break;
                        case 'w':
                            r = r + "234#pint";
                            break;
                        case 'x':
                            r = r + "123#pint";
                            break;
                        case 'y':
                            r = r + "1234#man";
                            break;
                        case 'z':
                            r = r + "124#manj";
                            break;

                        case 'A':
                            r = r + "134#madh";
                            break;
                        case 'B':
                            r = r + "235#pint";
                            break;
                        case 'C':
                            r = r + "126#pint";
                            break;
                        case 'D':
                            r = r + "136#pint";
                            break;
                        case 'E':
                            r = r + "12345$pi";
                            break;
                        case 'F':
                            r = r + "1234$pin";
                            break;
                        case 'G':
                            r = r + "123$pint";
                            break;
                        case 'H':
                            r = r + "12$pinto";
                            break;
                        case 'I':
                            r = r + "1$pinton";
                            break;
                        case 'J':
                            r = r + "234$pint";
                            break;
                        case 'K':
                            r = r + "98450$pi";
                            break;
                        case 'L':
                            r = r + "9845$pin";
                            break;
                        case 'M':
                            r = r + "984$pint";
                            break;
                        case 'N':
                            r = r + "12345%pi";
                            break;
                        case 'O':
                            r = r + "1234%pin";
                            break;
                        case 'P':
                            r = r + "123%pint";
                            break;
                        case 'Q':
                            r = r + "12%pinto";
                            break;
                        case 'R':
                            r = r + "1%pinton";
                            break;
                        case 'S':
                            r = r + "234%pint";
                            break;
                        case 'T':
                            r = r + "524%hy12";
                            break;
                        case 'U':
                            r = r + "98450%pi";
                            break;
                        case 'V':
                            r = r + "9845%pin";
                            break;
                        case 'W':
                            r = r + "984%pint";
                            break;
                        case 'X':
                            r = r + "4561^pin";
                            break;
                        case 'Y':
                            r = r + "456^pint";
                            break;
                        case 'Z':
                            r = r + "45^pinto";
                            break;
              //      }
            //    }

              //  else if(Character.isDigit(ch)) {

              //      switch (ch) {

                        case '1':
                            r = r + "design12";
                            break;
                        case '2':
                            r = r + "plan9754";
                            break;
                        case '3':
                            r = r + "doc12345";
                            break;
                        case '4':
                            r = r + "1234data";
                            break;
                        case '5':
                            r = r + "more9845";
                            break;
                        case '6':
                            r = r + "mo1234st";
                            break;
                        case '7':
                            r = r + "sy1002st";
                            break;
                        case '8':
                            r = r + "gain8542";
                            break;
                        case '9':
                            r = r + "singam12";
                            break;
                        case '0':
                            r = r + "3idiot58";
                            break;

                 //   }
               // }

              //  else {

               //     switch (ch) {


                        case '!':
                            r = r + "abcd1234";
                            break;
                        case '@':
                            r = r + "abcde987";
                            break;
                        case '#':
                            r = r + "abcd12qw";
                            break;
                        case '$':
                            r = r + "abcd134e";
                            break;
                        case '%':
                            r = r + "abcd18gy";
                            break;
                        case '^':
                            r = r + "abcd1235";
                            break;
                        case '&':
                            r = r + "karana12";
                            break;
                        case '*':
                            r = r + "kara123n";
                            break;
                        case '(':
                            r = r + "billa123";
                            break;
                        case ')':
                            r = r + "rebel987";
                            break;
                        case '_':
                            r = r + "mirchi12";
                            break;
                        case '+':
                            r = r + "bahuba12";
                            break;

                        case '-':
                            r = r + "rmd12345";
                            break;
                        case '=':
                            r = r + "rajani12";
                            break;
                        case '`':
                            r = r + "123vimal";
                            break;
                        case '~':
                            r = r + "foster55";
                            break;
                        case '{':
                            r = r + "hucchi03";
                            break;
                        case '}':
                            r = r + "tiger456";
                            break;
                        case '[':
                            r = r + "sachya58";
                            break;
                        case ']':
                            r = r + "chidya55";
                            break;
                        case '\\':
                            r = r + "shailu59";
                            break;
                        case '|':
                            r = r + "madan012";
                            break;
                        case ';':
                            r = r + "bmw98450";
                            break;
                        case ':':
                            r = r + "12spider";
                            break;
                        case '"':
                            r = r + "hero1234";
                            break;
                        case '\'':
                            r = r + "honda984";
                            break;
                        case '<':
                            r = r + "dell4561";
                            break;
                        case ',':
                            r = r + "asus9845";
                            break;

                        case '>':
                            r = r + "lenovo12";
                            break;

                        case '.':
                            r = r + "wipro456";
                            break;

                        case '?':
                            r = r + "shift123";
                            break;
                        case '/':
                            r = r + "ctrl4562";
                            break;
                        case ' ':
                            r = r + "noahpint";
                            break;

                    }
                }

           // }
            return r;


        }

         static String decpt(String a) {

            String val = "";


            char[] p = a.toCharArray();
            for (int i=0;i<p.length;) {
                String abc = "";

                for (int j = 0; j < 8; j++) {

                    abc = abc + p[i+j];


                }
                val = val + dec(abc);
                i=i+8;

            }


            return val;
        }

        private static String dec(String a) {


            String r = "";

            switch (a) {

                case "1234!man":
                    r = r + "a";
                    break;
                case "124!manj":
                    r = r + "b";
                    break;
                case "134!madh":
                    r = r + "c";
                    break;
                case "234!pint":
                    r = r + "d";
                    break;
                case "124!pint":
                    r = r + "e";
                    break;
                case "134!pint":
                    r = r + "f";
                    break;
                case "2345!pin" :
                    r=r+"g";
                    break;
                case "123!pint":
                    r = r + "h";
                    break;
                case "1234!rav":
                    r = r + "i";
                    break;
                case "124!ravi":
                    r = r + "j";
                    break;

                case "134@madh":
                    r = r + "k";
                    break;
                case "234@pint":
                    r = r + "l";
                    break;
                case "124@pint":
                    r = r + "m";
                    break;
                case "134@pint":
                    r = r + "n";
                    break;
                case "237@pint" :
                    r=r+"o";
                    break;
                case "123@pint":
                    r = r + "p";
                    break;
                case "1234@man":
                    r = r + "q";
                    break;
                case "12345!ma":
                    r = r + "r";
                    break;
                case "135@madh" :
                    r=r+"s";
                    break;
                case "235@pint" :
                    r=r+"t";
                    break;
                case "124#pint":
                    r = r + "u";
                    break;
                case "134#pint":
                    r = r + "v";
                    break;
                case "234#pint":
                    r = r + "w";
                    break;
                case "123#pint":
                    r = r + "x";
                    break;
                case "1234#man":
                    r = r + "y";
                    break;
                case "124#manj":
                    r = r + "z";
                    break;
                case "134#madh":
                    r = r + "A";
                    break;
                case "235#pint" :
                    r=r+"B";
                    break;
                case "126#pint" :
                    r=r+"C";
                    break;
                case "136#pint" :
                    r=r+"D";
                    break;
                case "12345$pi":
                    r = r + "E";
                    break;
                case "1234$pin":
                    r = r + "F";
                    break;
                case "123$pint":
                    r = r + "G";
                    break;
                case "12$pinto":
                    r = r + "H";
                    break;
                case "1$pinton":
                    r = r + "I";
                    break;
                case "234$pint":
                    r = r + "J";
                    break;
                case "98450$pi":
                    r = r + "K";
                    break;
                case "9845$pin":
                    r = r + "L";
                    break;
                case "984$pint":
                    r = r + "M";
                    break;
                case "12345%pi":
                    r = r + "N";
                    break;
                case "1234%pin":
                    r = r + "O";
                    break;
                case "123%pint":
                    r = r + "P";
                    break;
                case "12%pinto":
                    r = r + "Q";
                    break;
                case "1%pinton":
                    r = r + "R";
                    break;
                case "234%pint":
                    r = r + "S";
                    break;
                case "524%hy12":
                    r = r + "T";
                    break;
                case "98450%pi":
                    r = r + "U";
                    break;
                case "9845%pin":
                    r = r + "V";
                    break;
                case "984%pint":
                    r = r + "W";
                    break;

                case "4561^pin":
                    r = r + "X";
                    break;
                case "456^pint":
                    r = r + "Y";
                    break;
                case "45^pinto":
                    r = r + "Z";
                    break;

                case "abcd1234":
                    r = r + "!";
                    break;
                case "abcde987":
                    r = r + "@";
                    break;
                case "abcd12qw":
                    r = r + "#";
                    break;
                case "abcd134e":
                    r = r + "$";
                    break;
                case "abcd18gy":
                    r = r + "%";
                    break;
                case "abcd1235" : r = r + "^";
                    break;
                case "karana12":
                    r = r + "&";
                    break;
                case "kara123n":
                    r = r + "*";
                    break;
                case "billa123":
                    r = r + "(";
                    break;
                case "rebel987":
                    r = r + ")";
                    break;
                case "mirchi12":
                    r = r + "_";
                    break;
                case "bahuba12":
                    r = r + "+";
                    break;

                case "design12":
                    r = r + "1";
                    break;
                case "plan9754":
                    r = r + "2";
                    break;

                case "doc12345":
                    r = r + "3";
                    break;
                case "1234data":
                    r = r + "4";
                    break;
                case "more9845":
                    r = r + "5";
                    break;
                case "mo1234st":
                    r = r + "6";
                    break;
                case "sy1002st":
                    r = r + "7";
                    break;
                case "gain8542":
                    r = r + "8";
                    break;
                case "singam12":
                    r = r + "9";
                    break;
                case "3idiot58":
                    r = r + "0";
                    break;
                case "rmd12345":
                    r = r + "-";
                    break;
                case "rajani12":
                    r = r + "=";
                    break;

                case "123vimal":
                    r = r + "`";
                    break;
                case "foster55":
                    r = r + "~";
                    break;
                case "hucchi03":
                    r = r + "{";
                    break;
                case "tiger456":
                    r = r + "}";
                    break;
                case "sachya58":
                    r = r + "[";
                    break;
                case "chidya55":
                    r = r + "]";
                    break;
                case "shailu59":
                    r = r + "\\";
                    break;
                case "madan012":
                    r = r + "|";
                    break;
                case "bmw98450":
                    r = r + ";";
                    break;
                case "12spider":
                    r = r + ":";
                    break;
                case "hero1234":
                    r = r + "\"";
                    break;
                case "honda984":
                    r = r + "’";
                    break;
                case "dell4561":
                    r = r + "<";
                    break;
                case "asus9845":
                    r = r + ",";
                    break;
                case "lenovo12":
                    r = r + ">";
                    break;
                case "wipro456":
                    r = r + ".";
                    break;
                case "shift123":
                    r = r + "?";
                    break;

                case "ctrl4562":
                    r = r + "/";
                    break;
                case "noahpint":
                    r = r + " ";
                    break;


            }

            return r;


        }
    }

