class Solution {
    public String convertDateToBinary(String date) {
        String[] list = date.split("-");
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < list.length; i++) {
            str.append(convertToBinary(list[i]));
            if (i != list.length - 1) {
                str.append("-");
            }
        }
        return str.toString();
    }

    String convertToBinary(String str) {
        Integer num = Integer.parseInt(str);
        StringBuilder strBuilder = new StringBuilder();
        while(num > 0) {
            strBuilder.append(num % 2);
            num /= 2;
        }
        return strBuilder.reverse().toString();
    }
}