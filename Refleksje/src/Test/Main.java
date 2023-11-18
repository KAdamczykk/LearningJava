package Test;

import Ciezarowka.*;
import Ladunek.*;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // task 1
        System.out.println("--------------------1--------------------");
        Class<?> class1 = Class.forName("Ladunek.Barrel");
        Arrays.stream(class1.getDeclaredConstructors()).toList().forEach(System.out::println);
        // task 2
        System.out.println("--------------------2--------------------");
        Class<?> class2 = Class.forName("Ladunek.Chest");
        Class<?>[] parameterTypes = {String.class, boolean.class};
        try {
            System.out.println("Jest: " + class2.getDeclaredConstructor(parameterTypes));
        } catch (NoSuchMethodException e) {
            System.out.println("Brak");
        }
        // task 3
        System.out.println("--------------------3--------------------");
        Class<?> class3 = Class.forName("Ladunek.Cargo");
        System.out.println(class3.getPackage());
        // task 4
        System.out.println("--------------------4--------------------");
        Class<?> class4 = Class.forName("Ladunek.BagOfPotatoes");
        Arrays.stream(class4.getDeclaredMethods()).filter(s -> Modifier.isPrivate(s.getModifiers())).toList().forEach(System.out::println);
        // task 5
        System.out.println("--------------------5--------------------");
        Class<?> class5 = Class.forName("Ciezarowka.KoloOdCiezarowki");
        try {
            Field field = class5.getDeclaredField("sticker");
            field.setAccessible(true);
            KoloOdCiezarowki kolo = (KoloOdCiezarowki) class5.getDeclaredConstructor().newInstance();
            field.set(kolo, "Nalypka");
            System.out.println(field.get(kolo));

        } catch (NoSuchFieldException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }
        // task 6
        System.out.println("--------------------6--------------------");
        Class<?> class6 = Class.forName("Ladunek.Barrel");
        System.out.println(class6.getSuperclass());
        // task 7
        System.out.println("--------------------7--------------------");
        Class<?> class7 = Class.forName("Ladunek.Cargo");
        Arrays.stream(class7.getInterfaces()).forEach(s -> {
            if (s.getPackage() == class7.getPackage()){
                System.out.println(s + ", " + true);
            } else{
                System.out.println(s + ", " + false);
            }
        });
        // task 8
        System.out.println("--------------------8--------------------");
        Class<?> class8 = Class.forName("Ciezarowka.KoloOdCiezarowki");
        try {
            KoloOdCiezarowki koloo = (KoloOdCiezarowki) class5.getDeclaredConstructor().newInstance();
            Field field = class8.getDeclaredField("tiresize");
            field.setAccessible(true);
            field.set(koloo, 15);
            System.out.println(field.get(koloo));
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 NoSuchFieldException e) {
            e.printStackTrace();
        }
        // task 9
        System.out.println("--------------------9--------------------");

        List<Class<?>> subclasses = List.of(Barrel.class, Chest.class, BagOfPotatoes.class);

        List<Object> cargos = subclasses.stream().flatMap(class9 -> Arrays.stream(class9.getConstructors()))
                .map(Main::createObject)
                .toList();
        cargos.forEach(System.out::println);
        // task 10
        System.out.println("--------------------10--------------------");
        Class<?> class10 = Class.forName("Ciezarowka.Truck");
        Truck truck = null;
        try {
            truck = (Truck) class10.getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(truck);
        // task 11
        System.out.println("--------------------11--------------------");
        Class<?> class11 = Class.forName("Ciezarowka.Truck");
        try {
            Field field = class11.getDeclaredField("loadingBody");
            field.setAccessible(true);
            Method method = class11.getDeclaredMethod("addCargos", List.class);
            method.invoke(truck, cargos);
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        cargos.forEach(System.out::println);
        // task 12
        System.out.println("--------------------12--------------------");
        Class<?> class12 = Class.forName("Ciezarowka.SpareWheel");
        Class<?> class12a = Class.forName("Ciezarowka.FuelTank");
        try {
            SpareWheel spareWheel = (SpareWheel) class12.getConstructor().newInstance();
            FuelTank fueltank = (FuelTank) class12a.getConstructor().newInstance();
            spareWheel.setTiresize(25);
            fueltank.setNapelniony(true);
            Field fuel = class10.getDeclaredField("fueltank");
            Field spare = class10.getDeclaredField("spareWheel");
            fuel.setAccessible(true);
            spare.setAccessible(true);
            fuel.set(truck, fueltank);
            spare.set(truck, spareWheel);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(truck);
        // task 13
        System.out.println("--------------------13--------------------");
        try {
            Field field = class10.getDeclaredField("driverCabin");
            field.setAccessible(true);
            Class<?> driver = Class.forName("Ciezarowka.Driver");
            Class<?> cbradio = Class.forName("Ciezarowka.CBRadio");
            Field driverfield =driver.getDeclaredField("trzezwy");
            Field cbradioField = cbradio.getDeclaredField("dziala");
            driverfield.setAccessible(true);
            cbradioField.setAccessible(true);
            Driver dr = (Driver) driver.getConstructor().newInstance();
            driverfield.set(dr, false);
            CBRadio cb = (CBRadio) cbradio.getConstructor().newInstance();
            cbradioField.set(cb, false);
            if (field.get(truck) == null){
                Class<?> drivercabin = Class.forName("Ciezarowka.DriverCabin");
                DriverCabin driverCabin = (DriverCabin) drivercabin.getConstructor().newInstance();
                Field driverr = drivercabin.getDeclaredField("driver");
                Field cbb = drivercabin.getDeclaredField("cbRadio");
                driverr.setAccessible(true);
                cbb.setAccessible(true);
                driverr.set(driverCabin, dr);
                cbb.set(driverCabin, cb);
                Field cabin = class10.getDeclaredField("driverCabin");
                cabin.setAccessible(true);
                cabin.set(truck,driverCabin);
            }

        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InstantiationException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(truck);
        // task 14
        System.out.println("--------------------14--------------------");
        try {
            Field field = class10.getDeclaredField("driverCabin");
            field.setAccessible(true);
            DriverCabin cabin = (DriverCabin) field.get(truck);
            Class<?> cl = cabin.getClass();
            Field field1 = cl.getDeclaredField("driver");
            field1.setAccessible(true);
            Driver driver = (Driver) field1.get(cabin);
            driver.drive();
        } catch (NoSuchFieldException | IllegalAccessException | NullPointerException e) {
            e.printStackTrace();
        }
        // task 15
        System.out.println("--------------------15--------------------");
        Field infoField = null;
        try {
            infoField = SpareWheel.class.getDeclaredField("info");
            TireCompany tireCompanyAnnotation = infoField.getAnnotation(TireCompany.class);
            String manufacturer = tireCompanyAnnotation.manufacturer();
            String tireSize = tireCompanyAnnotation.tireSize();
            System.out.println(manufacturer);
            System.out.println(tireSize);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }



    }
    private static Object createObject(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            int parameterCount = constructor.getParameterCount();
            Object[] arguments = new Object[parameterCount];

            for (int i = 0; i < parameterCount; i++) {

                arguments[i] = new Random().nextInt(15) + 1;
            }
            return constructor.newInstance(arguments);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

    }

}
