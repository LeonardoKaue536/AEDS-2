import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Show{
    
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private Date date;
    private int year;
    private String rating;
    private String duration;
    private String[] listedin;

    //Construtor
    public Show(){

    }
    
    //get
    public String getShow_id() {
        return show_id;
    }
    public String getType() {
        return type;
    }
    public String getTitle(){
        return title;
    }
    public String getDirector() {
        return director;
    }
    public String[] getCast() {
        return cast;
    }
    public String getCountry(){
        return country;
    }
    public Date getDate() {
        return date;
    }
    public int getYear() {
        return year;
    }
    public String getRating(){
        return rating;
    }
    public String getDuration() {
        return duration;
    }
    public String[] getListedin() {
        return listedin;
    }
    

    //set
    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setCast(String[] cast) {
        this.cast = cast;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setListedin(String[] listedin) {
        this.listedin = listedin;
    }
    

    public static void imprimir(){

    }

    public static void ler(){
        
        String endereco = "disney.csv";
        
        try{

            BufferedReader file = new BufferedReader(new FileReader(endereco));
            String line;
            while((line = file.readLine())!= null){
                
            }

            file.close();
        }catch(IOException e){

            e.printStackTrace();

        }
        

        
    }
}