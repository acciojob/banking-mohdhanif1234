package com.driver;

import java.util.ArrayList;
import java.util.List;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public boolean isValid(String str){
        int n = str.length();
        for(int i=0; i<n-1; i++){
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            if(c1 == c2){
                return false;
            }
        }
        return true;
    }
    public void solve(String s,String t, List<String> list){
        if(s.length() == 0){
            if(!list.contains(t))
                list.add(t);
            return;
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            String l = s.substring(0,i);
            String r = s.substring(i+1);
            String a = l+r;
            solve(a,t+c, list);
        }
    }
    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(isValid(tradeLicenseId)){
            return;
        }
        else{
            List<String> list = new ArrayList<>();
            solve(tradeLicenseId, "", list);
            for(String s : list){
                if(isValid(s)){
                    this.tradeLicenseId = s;
                    return;
                }
            }
            throw new Exception("Valid License can not be generated");
        }
    }
}
