class Solution {
    private int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder b=new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                b.append(symbols[i]);
                num -= values[i];
            }
        }

        return b.toString();
    }
}