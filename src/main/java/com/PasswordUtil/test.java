package com.PasswordUtil;

import java.util.Scanner;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class test {
    private static final Argon2 argon2 = Argon2Factory.create();
    public static void main() {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        String password= sc.nextLine();
        System.out.println(hashPassword(password));
        sc.close();
	}

    public static String hashPassword(String password) {
        int iterations = 3;
        int memory = 65536; // 64 MB
        int parallelism = 1; // Single-threaded

        return argon2.hash(iterations, memory, parallelism, password);
    }

    public static boolean verifyPassword(String hash, String password) {
        return argon2.verify(hash, password);
    }
}