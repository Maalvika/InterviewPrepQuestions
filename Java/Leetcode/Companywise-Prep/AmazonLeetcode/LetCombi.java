////////////////////// 17. Letter Combinations of a Phone Number

class LetCombi {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> nums = new HashMap<>();
        nums.put('2', new char[]{'a','b','c'});
        nums.put('3', new char[]{'d','e','f'});
        nums.put('4', new char[]{'g','h','i'});
        nums.put('5', new char[]{'j','k','l'});
        nums.put('6', new char[]{'m','n','o'});
        nums.put('7', new char[]{'p','q','r','s'});
        nums.put('8', new char[]{'t','u','v'});
        nums.put('9', new char[]{'w','x','y','z'});
        char[] digit = digits.toCharArray();
        List<String> res = new LinkedList<>();
        for(char d:digit) {
            if(res.size() == 0) {
                for(char c:nums.get(d)) {
                    //System.out.println(c);
                    res.add(String.valueOf(c));
                }
            } else {
                List<String> new_res = new LinkedList<>();
                for(String i: res) {
                    for(char c:nums.get(d)) {
                        new_res.add(+String.valueOf(c));
                    }
                }
                res = new_res;
            }
        }
        return res;
    }
}