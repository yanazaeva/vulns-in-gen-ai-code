
//El juego debe de funcionar en línea y en local, pero en el caso de Internet solo se va a permitir que dos personas jueguen al mismo tiempo.
//Los usuarios podrán elegir su color, para poder identificarse y jugar.
package com.fernandogl09.exercise;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class FourInARow {
    private final String[] colors = {"Rojo", "Verde", "Azul", "Amarillo"};
    private final Random random;
    private int[][] tablero;
    private JTextField txtCol;
    private JButton btnJugar;
    private JFrame frmFourInARow;
    private JOptionPane optionPane;
    private String msgColor, msgWinner, msgDraw, msgEmpty, msgError, msgWin, msgPlayers;
    
    public FourInARow(){
        random = new Random();
        
        //Definición de mensajes
        msgError="Elige un número entre 1 y 3.";
        msgColor="Elige el color del jugador: ";
        msgWinner="Ganaste!";
        msgDraw="Empate!";
        msgEmpty="No hay juego.";
        msgWin="El jugador "+msgWinner+" tiene el color "+txtCol.getText()+", ganó en la posición "+randomMove();
        msgPlayers = "Jugadores: ";
        
        //Creación de JFrame
        frmFourInARow = new JFrame("Four in a row");
        frmFourInARow.setSize(500, 500);
        frmFourInARow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmFourInARow.setLayout(null);
        
        //Creación de JLabel y JButton
        btnJugar = new JButton("Jugar");
        btnJugar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnJugar.addActionListener((evt)->{
            //Lógica
            if(!txtCol.getText().equalsIgnoreCase("")){
                optionPane = new JOptionPane(null,JOptionPane.PLAIN_MESSAGE, 0, null, colors, null);
                
                int value = JOptionPane.showOptionDialog(frmFourInARow,optionPane,"Color del jugador",1,JOptionPane.PLAIN_MESSAGE,null,null,"");
                if(!value<0 && !value>3){
                    startGame(randomMove(),colors[value]);
                }else{
                    JOptionPane.showMessageDialog(frmFourInARow, msgError);
                }
            }else{
                JOptionPane.showMessageDialog(frmFourInARow,msgColor);
            }
        });
        
        //Definición de posición del botón 
        btnJugar.setBounds(170, 400, 150, 35);
        frmFourInARow.add(btnJugar);
        
        txtCol = new JTextField();
        txtCol.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        //Definición de posición del textField
        txtCol.setBounds(30, 400, 120, 35);
        frmFourInARow.add(txtCol);
        
        JLabel lblCol = new JLabel("Color: ");
        lblCol.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        //Definición de posición del label
        lblCol.setBounds(30, 385, 50, 20);
        frmFourInARow.add(lblCol);
        
        JLabel lblTitulo = new JLabel("Four in a row");
        //Definición de posición del label
        lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        lblTitulo.setBounds(170, 385, 200, 20);
        frmFourInARow.add(lblTitulo);
        
        //Creación de JTextArea
        JTextArea txtArea = new JTextArea();
        txtArea.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        //Definición de posición del textArea
        txtArea.setBounds(30, 25, 440, 325);
        frmFourInARow.add(txtArea);
        
        JLabel lblText = new JLabel("Jugar");
        //Definición de posición del label
        lblText.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        lblText.setBounds(30, 25, 80, 20);
        frmFourInARow.add(lblText);
        
        //Definición de posición del JFrame
        frmFourInARow.setVisible(true);
    }
    
    public static void main(String[] args) {
        FourInARow fourInARow = new FourInARow();
        try{
            //Definición de puerto
            ServerSocket serverSocket = new ServerSocket(5001, 2);
            
            Socket socket = null;
            PrintWriter out = null;
            BufferedReader in = null;
            String ipCliente="";
            
            while(true){
                //Conexión con el cliente
                System.out.println("Esperando conexiones...");
                
                socket = serverSocket.accept();
                System.out.println("Se ha establecido la conexión.");
                
                try{
                    ipCliente=socket.getInetAddress().toString().split("/")[1];
                    System.out.println(ipCliente+" se ha conectado");
                    
                    //Llamada a método de escritura del JTextArea
                    fourInARow.appendMsgToJTextArea(""+msgPlayers+socket.getPort()+": "+socket.getRemoteSocketAddress().toString());
                    
                    out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    
                    //Envío de mensajes al cliente y recipción de respuestas
                    while(in.readLine() != null){
                        if(!in.readLine().equals("")){
                            out.println("Mensaje enviado");
                            
                            String msg = in.readLine();
                            fourInARow.appendMsgToJTextArea(""+ipCliente+" escribió:\n\t"+msg);
                        }
                    }
                }finally{
                    if(out != null) out.close();
                    if(in != null) in.close();
                }
            }
        }catch(Exception ex){
            System.err.println("Error en el servidor:"+ex);
        }
        
    }
    
    private void startGame(int move, String color){
        //Definición del tablero de juego y su asignación a las filas y columnas (0-3) y (1-7)
        tablero = new int[4][8];
        
        JTextArea txtArea = (JTextArea)frmFourInARow.getContentPane().getComponent(1);
        
        //Lógica de juego
        while(!gameOver() && !draw()){
            move=randomMove();
            txtArea.append("Mi movimiento:\n\t");
            
            if(move==-1){
                txtArea.append("Empate.\n");
            }else{
                txtArea.append(((random.nextBoolean())?"Hacer":"No hacer")+" el movimiento en la posición "+((move/4)+1)+" y "+(((move%4)+1)));
                System.out.println("Mi movimiento: " + move);
                
                setCell(move,color);
            }
            
            txtArea.append("\n");
            
            txtArea.setCaretPosition(txtArea.getDocument().getLength());
        }
        
        if(!gameOver() && draw()){
            txtArea.append("Empate.\n");
        }else{
            String winner="";
            
            if(!gameOver() && !draw()){
                winner=((color==txtArea.getSelectedText().split("\n")[0].substring(16))?"Ganaste":"Perdiste");
                txtArea.append("Has "+winner+"\n");
            }
        }
        
        //Llamada a método de escritura del JTextArea
        appendMsgToJTextArea("\n"+(winner.equals("")?"Empate.\n":"Tu movimiento:\n\t"+color));
        
        System.out.println("Mi turno: "+move);
    }
    
    private boolean gameOver(){
        if(draw()){
            return true;
        }else{
            for(int i=0;i<4;i++){
                int auxCount = 0;
                
                //Comprobando fila
                for(int j=0;j<8;j++){
                    if(tablero[i][j]==1){
                        auxCount++;
                    }else{
                        auxCount=0;
                    }
                    
                    if(auxCount == 3){
                        System.out.println("Ganaste la fila "+(i+1));
                        
                        return true;
                    }
                }
                
                //Comprobando columna
                for(int j=0;j<8;j++){
                    if(tablero[j][i]==1){
                        auxCount++;
                    }else{
                        auxCount=0;
                    }
                    
                    if(auxCount == 3){
                        System.out.println("Ganaste la columna "+(i+1));
                        
                        return true;
                    }
                }
            }
            
            //Comprobando diagonal principal
            int auxCount = 0;
            
            for(int i=0;i<8;i++){
                if(tablero[i][i]==1){
                    auxCount++;
                }else{
                    auxCount=0;
                }
                
                if(auxCount == 3){
                    System.out.println("Ganaste la diagonal principal");
                    
                    return true;
                }
            }
            
            //Comprobando diagonal secundaria
            auxCount = 0;
            
            for(int i=0;i<8;i++){
                if(tablero[i][7-i]==1){
                    auxCount++;
                }else{
                    auxCount=0;
                }
                
                if(auxCount == 3){
                    System.out.println("Ganaste la diagonal secundaria");
                    
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean draw(){
        for(int i=0;i<4;i++){
            for(int j=0;j<8;j++){
                if(tablero[i][j]==0){
                    return false;
                }
            }
        }
        
        System.out.println("Empate");
        
        return true;
    }
    
    private void setCell(int cell, String color){
        tablero[cell/4][cell%4]=1;
        
        appendMsgToJTextArea("\t"+(tablero[cell/4][cell%4]==1?"\u25cf":" ")+"   ");
    }
    
    private int randomMove(){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        
        for(int i=0;i<8;i++){
            for(int j=0;j<4;j++){
                if(tablero[j][i]==0){
                    moves.add((j)*4+i);
                }
            }
        }
        
        return moves.get(new Random().nextInt(moves.size()));
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0){
            return (moves.get(new Random().nextInt(moves.size()/2+1)));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()/2));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves, int max){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves, int max, boolean check){
        if(!check && (from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())));
        }else if(!check && (from%2==1 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }else if(check && (from%2==1 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())+1));
        }else if(check && (from%2==0 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-1));
        }else{
            return -1;
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves, boolean check){
        if(!check && (from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())));
        }else if(!check && (from%2==1 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }else if(check && (from%2==1 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())+1));
        }else if(check && (from%2==0 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-1));
        }else{
            return -1;
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves, int max){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves, int max, boolean check){
        if(!check && (from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())));
        }else if(!check && (from%2==1 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }else if(check && (from%2==1 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())+1));
        }else if(check && (from%2==0 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-1));
        }else{
            return -1;
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves, int max, boolean check){
        if(!check && (from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())));
        }else if(!check && (from%2==1 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }else if(check && (from%2==1 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())+1));
        }else if(check && (from%2==0 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-1));
        }else{
            return -1;
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves, boolean check){
        if(!check && (from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())));
        }else if(!check && (from%2==1 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }else if(check && (from%2==1 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())+1));
        }else if(check && (from%2==0 && moves.size()>=max/2 || from%2!=0 && moves.size()>=max-moves.size()/2)){
            return (moves.get(new Random().nextInt(moves.size())-1));
        }else{
            return -1;
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from%2==0 && moves.size()<=max/2 || from%2!=0 && moves.size()<=max-moves.size()/2){
            return (moves.get(new Random().nextInt(moves.size())));
        }else{
            return (moves.get(new Random().nextInt(moves.size())-moves.size()));
        }
    }
    
    private int randomMove(int from, ArrayList<Integer> moves){
        if(from