class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() <= 1) return "";
        StringBuilder sb = new StringBuilder(palindrome);
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != 'a') {
                sb.setCharAt(i, 'a');
                break;
            }
            continue;
        }
        if (palindrome.equals(sb.toString())) {
            sb.setCharAt(sb.length() - 1, 'b');
        }
        return sb.toString();
    }
}
