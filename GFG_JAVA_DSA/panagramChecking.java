/**
 * panagram -- a string having all the alphabets
 * here we are not differntiate the capitals and small letters, 
 * like having t or T is same.
 */
class panagramChecking{
    public static boolean isPanagram(String s){
        if(s.length()<26){
            return false;
            //as we have 26 alphabets, the string should have minimum length of 26
        }
        for(char c='a';c<='z';c++){
            String str = c+"";
            if(s.contains(str)||s.contains(s.toUpperCase())){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(isPanagram("Thequickbrownfoxjumpsoverhelazydog")); //helazydog
        System.out.println(isPanagram("Thequickbrownfoxjumpsoverthelazydog")); //thelazydog
    }
}