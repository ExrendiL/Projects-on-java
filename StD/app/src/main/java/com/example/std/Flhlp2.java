package com.example.std;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Flhlp2 {
    public static final String FILENANE = "Tu.dat";

    public static void wrtdat (ArrayList<String> itms, Context context){
        try {
            FileOutputStream flp= context.openFileOutput(FILENANE,Context.MODE_PRIVATE);
            ObjectOutputStream oos= new ObjectOutputStream(flp);
            oos.writeObject(itms);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> readD(Context context){
        ArrayList<String> itmlst = null;
        try {

            FileInputStream fis = context.openFileInput(FILENANE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            itmlst= (ArrayList<String>) ois.readObject();

        } catch (FileNotFoundException e) {
            itmlst=new ArrayList<>();
            e.printStackTrace();

        }
        catch (IOException e) {
            e.printStackTrace(); } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return itmlst;
    }
}
