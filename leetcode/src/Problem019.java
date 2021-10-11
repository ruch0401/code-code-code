import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class Problem019 {
    public static void main(String[] args) {
        int[] employeeId = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        String[] names = {"Alayna Pearson", "Reese Hunt", "Julissa Coffey", "Sophia Horne", "Thomas Horton", "Hamza Kane", "Frederick Pratt", "Makayla Nixon", "Joaquin Barajas", "Laura Adams", "Rolando Bridges", "Carmen Rasmussen", "Juliet Franco", "Ivy Compton", "Santino Brown", "Bianca Stanton", "Clinton Wyatt", "Armando Gilmore", "Misael Gaines", "Mara Fitzgerald"};
        String[] phoneNumbers = {"213-200-6560", "213-201-4288", "213-202-8777", "213-203-5805", "213-204-5953", "213-206-8302", "213-207-9426", "213-209-1358", "213-210-9283", "213-213-5623", "213-215-4919", "213-216-8243", "213-217-1970", "213-219-2722", "213-220-2484", "213-221-7427", "213-222-6001", "213-223-7351", "213-224-2710", "213-225-9541"};
        int[] floorNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] officeNumbers = {1, 5, 1, 6, 8, 10, 6, 6, 1, 6, 2, 5, 8, 1, 8, 8, 1, 10, 8, 5};
        String[] emails = {"alayna.pearson@gmail.com", "reese.hunt@gmail.com", "julissa.coffey@gmail.com", "sophia.horne@gmail.com", "thomas.horton@gmail.com", "hamza.kane@gmail.com", "frederick.pratt@gmail.com", "makayla.nixon@gmail.com", "joaquin.barajas@gmail.com", "laura.adams@gmail.com", "rolando.bridges@gmail.com", "carmen.rasmussen@gmail.com", "juliet.franco@gmail.com", "ivy.compton@gmail.com", "santino.brown@gmail.com", "bianca.stanton@gmail.com", "clinton.wyatt@gmail.com", "armando.gilmore@gmail.com", "misael.gaines@gmail.com", "mara.fitzgerald@gmail.com"};
        int[] roomNumbers = {848, 561, 882, 812, 986, 728, 102, 736, 687, 514, 437, 294, 449, 130, 322, 763, 616, 101, 789, 456, 168, 879, 829, 975, 770};
        int[] meetingTime = {9, 14, 17, 9, 8, 14, 8, 8, 14, 16, 11, 12, 11, 14, 9, 15, 15, 17, 9, 15, 12, 14, 8, 10, 8};
        String[] notificationType = {"MANDATORY", "OPTIONAL"};
        int[] symptomId = {1, 2, 3, 4, 5};
        Timestamp[] timestamps = getTimestamps();
        int[] times = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] temperatures = {102, 97, 104, 96, 99, 96, 104, 99, 104, 100, 104, 96, 101, 106, 98, 96, 99, 104, 104, 104, 106, 104, 104, 106, 96};
        String[] testResult = {"POSITIVE", "NEGATIVE"};
        String[] testLocation = {"COMPANY", "HOSPITAL", "CLINIC"};
        String[] resolutions = {"BACK TO WORK", "LEFT THE COMPANY", "DECEASED"};
        String[] status = {"SICK", "HOSPITALIZED", "WELL"};

        int[] randomizedEmployeeId = randomizeArray(employeeId);
        int[] randomizesFloorNumber = randomizeArray(floorNumbers);
        String[] randomizedNotificationType = randomizeArray(notificationType);
        Timestamp[] randomizedTimestamp = randomizeArray(timestamps);
        int[] randomizedSymptomId = randomizeArray(symptomId);
        int[] randomizedTime = randomizeArray(times);

        for (int i = 0; i < 20; i++) {
            String format = "INSERT INTO employee VALUES (%s, '%s', %s, %s, '%s', '%s');";
            System.out.printf((format) + "%n", i + 1, names[i], officeNumbers[i], floorNumbers[i % 10], phoneNumbers[i], emails[i]);
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            // meetingId, employeeId, roomNumber, floorNumber, meetingStartTime (between 8-18 to depict 8AM-6PM
            String format = "INSERT INTO meeting VALUES (%s, %s, %s, %s, %s);";
            System.out.printf((format) + "%n", i + 1, randomizedEmployeeId[i], roomNumbers[i], randomizesFloorNumber[i % 10], meetingTime[i]);
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            // notificationID, employeeId, notificationDate, notificationType
            String format = "INSERT INTO notification VALUES (%s, %s, '%s', '%s');";
            System.out.printf((format) + "%n", i + 1, randomizedEmployeeId[i], randomizedTimestamp[i], randomizedNotificationType[i % 2]);
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            // rowID, employeeId, dateReported, symptomId
            String format = "INSERT INTO symptom VALUES (%s, %s, '%s', '%s');";
            System.out.printf((format) + "%n", i + 1, randomizedEmployeeId[i], randomizedTimestamp[i], randomizedSymptomId[i % 5]);
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            // scanID, employeeId, scan_date, scan_time, temperature
            String format = "INSERT INTO scan VALUES (%s, %s, '%s', %s, %s);";
            System.out.printf((format) + "%n", i + 1, randomizedEmployeeId[i], randomizedTimestamp[i], randomizedTime[i], temperatures[i]);
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            // testID, employeeID, location, test_date, test_time, result
            String format = "INSERT INTO test VALUES (%s, %s, '%s', '%s', %s, '%s');";
            System.out.printf((format) + "%n", i + 1, randomizedEmployeeId[i], testLocation[i % 3], randomizedTimestamp[i], randomizedTime[i], testResult[i % 2]);
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            // caseID, employeeId, date, resolution
            String format = "INSERT INTO covid_case VALUES (%s, %s, '%s', '%s');";
            System.out.printf((format) + "%n", i + 1, randomizedEmployeeId[i], randomizedTimestamp[i], resolutions[i % 3]);
        }

        System.out.println();

        for (int i = 0; i < 20; i++) {
            // row ID, employee ID, date, status
            String format = "INSERT INTO health_status VALUES (%s, %s, '%s', '%s');";
            System.out.printf((format) + "%n", i + 1, randomizedEmployeeId[i], randomizedTimestamp[i], status[i % 3]);
        }
    }

    private static Timestamp[] getTimestamps() {
        Timestamp[] ans = new Timestamp[20];
        for (int i = 0; i < 20; i++) {
            ans[i] = generateRandomTimestamp();
        }
        return ans;
    }

    public static void generateEmailsFromGivenNames(String[] names) {
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(names[i].split(" ")[0].toLowerCase(Locale.ROOT)).append(".")
                    .append(names[i].split(" ")[1].toLowerCase(Locale.ROOT))
                    .append("@gmail.com");
            emails.add(sb.toString());
        }
        System.out.println(emails);
    }

    public static int[] randomizeArray(int[] arr) {
        Random random = new Random();
        int newRandomIndex = random.nextInt(arr.length);
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[newRandomIndex];
            arr[newRandomIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static String[] randomizeArray(String[] arr) {
        Random random = new Random();
        int newRandomIndex = random.nextInt(arr.length);
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[newRandomIndex];
            arr[newRandomIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static Timestamp[] randomizeArray(Timestamp[] arr) {
        Random random = new Random();
        int newRandomIndex = random.nextInt(arr.length);
        for (int i = 0; i < arr.length; i++) {
            Timestamp temp = arr[newRandomIndex];
            arr[newRandomIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static Timestamp generateRandomTimestamp() {
        long offset = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
        long diff = end - offset + 1;
        return new Timestamp(offset + (long) (Math.random() * diff));
    }
}
