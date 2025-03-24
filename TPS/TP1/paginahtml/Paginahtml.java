package TP1.paginahtml;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Paginahtml {

    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }

    public static String getHtml(String endereco){
		StringBuffer resp = new StringBuffer();
		try {
			URL obj = new URL(endereco);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			
			con.setRequestMethod("GET");

			
			int responseCode = con.getResponseCode();

			
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;

				while ((inputLine = in.readLine()) != null) {
					resp.append(inputLine);
				}

				
				in.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}      

		return resp.toString();
	}

    public static int contarOcorrencias(String texto, String texto2) {
        int count = 0, index = 0;

        while ((index = texto.indexOf(texto2, index)) != -1) {
            count++;
            index += texto2.length();
        }

        return count;
    }

    public static void contagem(String Nome, String endereco) {
        String pag = getHtml(endereco);

        int a = 0 -1, e = 0 - 1, i = 0, o = 0, u = 0;
        int a2 = 0, e2 = 0, i2 = 0, o2 = 0, u2 = 0;
        int a3 = 0, e3 = 0, i3 = 0, o3 = 0, u3 = 0;
        int a4 = 0, e4 = 0;
        int a5 = 0, e5 = 0, i4 = 0, o4 = 0, u4 = 0;
        int consoantes = 0;

        int br = contarOcorrencias(pag, "<br>");
        int table = contarOcorrencias(pag, "<table>");

        for (int j = 0; j < pag.length(); j++) {
            char c = pag.charAt(j);

            switch (c) {
                case 'a': a++; break;
                case 'e': e++; break;
                case 'i': i++; break;
                case 'o': o++; break;
                case 'u': u++; break;
                
                case '\u00E1' :a2++; break; // á
                case '\u00E9' :e2++; break; // é
                case '\u00ED' :i2++; break;// í
                case '\u00F3' :o2++; break;// ó
                case '\u00FA' :u2++; break;// ú
                case '\u00E0' :a3++; break;// à
                case '\u00E8' :a3++; break;// è
                case '\u00EC' :a3++; break;// ì
                case '\u00F2' :a3++; break;// ò
                case '\u00F9' :a3++; break;// ù
                case '\u00E3' :a4++; break;// ã
                case '\u00F5' :o4++; break;// õ
                case '\u00E2' :a5++; break;// â
                case '\u00EA' :e5++; break;// ê
                case '\u00EE' :i4++; break;// î
                case '\u00F4' :o4++; break;// ô
                case '\u00FB' :u4++; break;// û
                
                default : 
                    if ((c >= 'b' && c <= 'd') || (c >= 'f' && c <= 'h') || 
                        (c >= 'j' && c <= 'n') || (c >= 'p' && c <= 't') || 
                        (c >= 'v' && c <= 'z') || (c >= 'B' && c <= 'D') || 
                        (c >= 'F' && c <= 'H') || (c >= 'J' && c <= 'N') || 
                        (c >= 'P' && c <= 'T') || (c >= 'V' && c <= 'Z')) {
                        consoantes++;
                    }
                break;
                
            }
        }

        // Exibir resultados na mesma linha
        System.out.print("a(" + a + ") e(" + e + ") i(" + i + ") o(" + o + ") u(" + u + ") ");
        System.out.print("\u00E1(" + a2 + ") \u00E9(" + e2 + ") \u00ED(" + i2 + ") \u00F3(" + o2 + ") \u00FA(" + u2 + ") ");
        System.out.print("\u00E0(" + a3 + ") \u00E8(" + e3 + ") \u00EC(" + i3 + ") \u00F2(" + o3 + ") \u00F9(" + u3 + ") ");
        System.out.print("\u00E3(" + a4 + ") \u00F5(" + o4 + ") \u00E2(" + a5 + ") \u00EA(" + e5 + ") \u00EE(" + i4 + ") \u00F4(" + o4 + ") \u00FB(" + u4 + ") ");
        System.out.print("consoante(" + consoantes + ") ");
        System.out.print("<br>(" + br + ") <table>(" + table + ") ");
        System.out.println(Nome);
    }


    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String Nome,endereco;


        Nome = ler.nextLine();
        endereco = ler.nextLine();

        while(verifica(Nome)){
            
            contagem(Nome, endereco);


            Nome = ler.nextLine();
            if(verifica(Nome)){
                endereco = ler.nextLine();
            }
        }
        
        ler.close();
    }
}
