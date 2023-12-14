package WitcherFinder;

public class WitcherFinder {

    public static void main(String[] str){
        findingWitcher(str[0]);
    }
        public static boolean findingWitcher(String str){
        String lowerCaseStr = str.toLowerCase();
        int num = 0;
        if(lowerCaseStr.contains("!geralt!")){
            for(int i = 0; i<lowerCaseStr.length();i++){
                if(Character.isDigit(lowerCaseStr.charAt(i))){
                    int numValue = Character.getNumericValue(lowerCaseStr.charAt(i));
                    num += numValue;
                }
            }
            System.out.println(num);
            if(num == 10){
                System.out.println("very true");
                return true;
            }

        }
        System.out.println("very wrong");
        return false;
    }
}