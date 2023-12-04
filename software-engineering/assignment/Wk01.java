public class Wk01 {
    public static void main(String[] args){
        int length = Integer.parseInt(args[0]);
        String line = "";
        for(int i = 0; i < 2*length-1; i++){
                for (int j = 0; j<2*length -1; j++){
                if(i<length){
                    if(j<i || j>=2*length-1-i){
                        line += " ";
                    }else{
                        line += "*";
                    }
                }
                else{
                    if(j+i<2*length-2||j>i){
                        line += " ";
                    }else{
                        line += "*";
                    }
                }

           
            }
             System.out.println(line);
            line = "";
        }

        Wk01.witcherFinder(args[1]);
    }

    public static boolean witcherFinder(String str){
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