public class towerOfHanoi {
    public static void main(String[] args){
        towerofHanoi(4, 'X','Y','Z');
    }
    static void towerofHanoi(int n, char from, char to, char aux){
        if (n==1){
            System.out.println("Moving the disk 1 from " + from + " to the " + to + " rod.");
        }
        else
        {
            towerofHanoi(n-1, from, aux,to);
            System.out.println("Moving the disk " + n + " from " + from + " to the " + to + " rod.");
            towerofHanoi(n-1,aux,to,from);
        }
    }
}
