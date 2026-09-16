package com.ga.bank;

import java.io.*;

public class FileManager {



    public static void createFile(String userType, String userName, int id)
    {
        try{
            File myObj = new File(userType + "-" + userName +"-" + String.format("%05d", id)+".txt");
            if (myObj.createNewFile()){
                System.out.println("File created: " + myObj.getName());
            }
            else{
                System.out.println("File already exits.");
            }
            if(userType.equals("C")){
                File myObj2 = new File(userType + "-" + userName +"-" + String.format("%05d", id)+ "-" + "transactions"+ ".txt");
                if (myObj2.createNewFile()){
                    System.out.println("File created: " + myObj.getName());
                }
                else{
                    System.out.println("File already exits.");
                }
            }

        }catch(IOException e){
            System.out.println("An error occured.");
            e.printStackTrace(); //print the error details
        }
    }


    public static void addingData(Object account) throws IOException {
        FileWriter fw = new FileWriter("data.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(account.toString());
        bw.newLine();

        bw.close();
        //System.out.println(account.getUser().toString());

    }

    public static void saveAccount(Customer customer, Account account) throws IOException {
        String fileName = customer.userType + "-" + customer.userName + "-" +String.format("%05d", customer.getId()) + ".txt";
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(account.toString());
        bw.newLine();
        bw.close();
    }

    public static void loadAccounts(Customer customer) throws IOException {
        File file = new File(customer.getUserType() + "-" + customer.getUserName() +"-" + String.format("%05d", customer.getId())+".txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while(line!=null){
            String[] parts = line.split(",");
            if(parts[0].equals("ACCOUNT")){
                Account account = new Account(parts[1]);
                account.setBalance(Double.parseDouble(parts[2]));
                customer.accounts.add(account);
            }
            line = br.readLine();
        }
        br.close();
    }

}
