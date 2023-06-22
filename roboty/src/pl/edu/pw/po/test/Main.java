package pl.edu.pw.po.test;

import pl.edu.pw.po.roboty.*;

public class Main {

    public static void main(String[] args) {

        RobotProdukcja robotProdukcja1 = new RobotProdukcja(Robot.lancuch.Ala2, SztucznaInteligencja.reprezentacja_danych.binarna);
        RobotProdukcja robotProdukcja2 = new RobotProdukcja(Robot.lancuch.Aleks900, SztucznaInteligencja.reprezentacja_danych.przyblizona);
        RobotProdukcja robotProdukcja3 = new RobotProdukcja(Robot.lancuch.Adam1000, SztucznaInteligencja.reprezentacja_danych.rozmyta);
        RobotSkladanie robotSkladanie1 = new RobotSkladanie(Robot.lancuch.Zosia_Samosia, SztucznaInteligencja.reprezentacja_danych.binarna);
        RobotSkladanie robotSkladanie2 = new RobotSkladanie(Robot.lancuch.Roman2,SztucznaInteligencja.reprezentacja_danych.przyblizona);
        RobotSkladanie robotSkladanie3 = new RobotSkladanie(Robot.lancuch.Ula,SztucznaInteligencja.reprezentacja_danych.rozmyta);
        RobotDomowy robotDomowy1 = new RobotDomowy(Robot.lancuch.Robert01,SztucznaInteligencja.reprezentacja_danych.binarna);
        RobotDomowy robotDomowy2 = new RobotDomowy(Robot.lancuch.Robert01,SztucznaInteligencja.reprezentacja_danych.przyblizona);
        RobotDomowy robotDomowy3 = new RobotDomowy(Robot.lancuch.Aleks900,SztucznaInteligencja.reprezentacja_danych.rozmyta);
        Robot[] roboty = {robotProdukcja1,robotProdukcja2,robotProdukcja3,robotSkladanie1,robotSkladanie2,robotSkladanie3,robotDomowy1,robotDomowy2,robotDomowy3};

        for (int i = 0; i<roboty.length; i++){
            System.out.println(roboty[i]);
        }
        /**
         * jr
         * To też w pętli (-0.5)*/
        System.out.println();
        System.out.println(robotProdukcja1.meldunek());
        robotDomowy1.powitanie();
        robotSkladanie2.zadanieWykonaj();
        robotSkladanie1.zadanieWykonaj();
        System.out.println();

        for (int i = 0; i<roboty.length; i++){
            System.out.println(roboty[i]);
        }
        for (int i = 1; i < roboty.length; i++){
            Robot.Equal(roboty[i-1], roboty[i]);
        }




    }
}
