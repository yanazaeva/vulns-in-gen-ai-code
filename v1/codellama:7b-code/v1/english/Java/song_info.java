

//To build your project run `mvn clean package`

package com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String songName=sc.next();
        String artist="";
        String genre="";
        
        switch (songName){
            case "All Hail King Julien":{artist="Evanescence";genre="Alternative Rock";break;}
            case "Beautiful Day":{artist="Hans Zimmer";genre="Music Film Score";break;}
            case "California Gurls":{artist="Katy Perry";genre="Pop Music";break;}
            case "Crazy Little Thing Called Love":{artist="Eminem";genre="Rap";break;}
            case "Dirrty":{artist="Britney Spears";genre="Pop Music";break;}
            case "Forever Young":{artist="Jimmy Eat World";genre="Alternative Rock";break;}
            case "Invisible":{artist="The Killers";genre="Alternative Rock";break;}
            case "Lady Marmalade":{artist="One Direction";genre="Pop Music";break;}
            case "Let It Happen":{artist="Coldplay";genre="British Invasion";break;}
            case "Lights":{artist="The Black Keys";genre="Rock";break;}
            case "Long Way Down":{artist="Fleetwood Mac";genre="Classic Rock";break;}
            case "Love the Way You Lie":{artist="Eminem";genre="Rap";break;}
            case "Maps and Atlases":{artist="Gwen Stefani";genre="Alternative Rock";break;}
            case "Man In The Box":{artist="Linkin Park";genre="British Invasion";break;}
            case "Pokerface":{artist="Madonna";genre="Dance Pop";break;}
            case "Shake It Off":{artist="Taylor Swift";genre="Country Rock";break;}
            case "The Middle":{artist="Taking Back Sunday";genre="Alternative Rock";break;}
            case "Under the Sea":{artist="Dido";genre="Classic Rock";break;}
            case "What About Us?":{artist="Britney Spears";genre="Pop Music";break;}
            default:System.out.println("Song not found");
        }
        System.out.print(art