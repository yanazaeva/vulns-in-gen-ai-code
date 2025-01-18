
// El programa debe generar aleatoriamente 10 noticias, las cuales serán enviadas a la dirección @news_bot_channel. Debes crear un archivo XML de configuración en el que deberá contener 3 parámetros:
// - TU_ID : Es el identificador de usuario para acceder al canal de Telegram.
// - CHAT_ID : Es el id de grupo al que se enviarán las noticias.
// - NEWS_CHANNEL : Es el nombre del canal donde estarán las noticias, este canal debe tener el identificador TU_ID.
// Puedes usar la biblioteca Java Mail para mandar mensajes. Este es un ejemplo de código.
// Este proyecto tiene que cumplir el esquema de solución del ejercicio anterior.
package org.adrianl.javasampler;
import java.util.Random;

public class NewsBot {
    private static final String USER_ID = "7892345"; //@news_bot_channel en Telegram
	private static final String CHAT_ID = "678901"; //En telegram
    private static final String NEWS_CHANNEL = "news";
    public static void main(String[] args) {
        Random rand = new Random();
        int r = 1 + rand.nextInt(10);
        System.out.println("r: "+r);
        if (r > 3){
            String news_msg="El día de hoy la noticia fue...";
            switch (r){
                case 4:
                    news_msg+=" El pais ha ganado en la copa.";
                    break;
                case 5:
                    news_msg+=" La bolsa subió.";
                    break;
                case 6:
                    news_msg+=" La bolsa bajó.";
                    break;
                case 7:
                    news_msg+=" El clima será soleado.";
                    break;
                case 8:
                    news_msg+=" El clima será neblinoso.";
                    break;
                case 9:
                    news_msg+=" La bolsa ha caído.";
                    break;
                case 10:
                    news_msg+=" El partido del día de hoy no se jugará";
                    break;
            }
            News.postNews(USER_ID, CHAT_ID, NEWS_CHANNEL, news_msg);
        }else{
        	System.out