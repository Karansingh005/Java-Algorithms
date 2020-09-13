public class subString {
    public static void main(String[] args){
        String word = "abc";
        System.out.println(getSubSequence(word));
    }
    private static String getSubSequence(String word){
        if (word.isEmpty()){
            return "";
        }
        char first = word.charAt(0);
        String rest = getSubSequence(word.substring(1));
        //Dividing all the subsequences by ','
        String result = "";
        for (String subseq: rest.split(",",-1)) {
            result += "," + first + subseq;
            result += "," + subseq;
        }
        return result.substring(1);
    }
}
