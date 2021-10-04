import java.util.HashMap;

public class Problem016 {
    public static void main(String[] args) {
        String[] arr = {"20th Oct 2052", "6th Jun 1933", "26th Oct 2052", "2nd Jan 2019"};
        System.out.println(solve(arr));
    }

    private static String solve(String[] arr) {
        HashMap<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");


        StringBuilder sb = new StringBuilder();
        for (String date: arr) {
            StringBuilder temp = new StringBuilder();
            String[] comps = date.split(" ");
            String dd = comps[0].substring(0, comps[0].length() - 2);
            if (dd.length() == 1) {
                dd = "0" + dd;
            }
            String mm = comps[1];
            String yy = comps[2];
            temp.append(yy).append("-").append(months.get(mm)).append("-").append(dd);
            sb.append(temp).append("\n");
        }
        return sb.toString();
    }
}
