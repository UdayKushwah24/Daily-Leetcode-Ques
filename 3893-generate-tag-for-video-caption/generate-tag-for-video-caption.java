class Solution {
    public String generateTag(String caption) {
        String[] words = caption.trim().split(" ");
        if (words.length == 0) {
            return "#";
        }
        StringBuilder sb = new StringBuilder("#");
        sb.append(words[0].toLowerCase());
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() == 0) {
                continue;
            }
            sb.append(words[i].substring(0, 1).toUpperCase()).append(words[i].substring(1).toLowerCase());
            if (sb.length() >= 100) {
                break;
            }
        }
        return sb.length() > 100 ? sb.toString().substring(0, 100) : sb.toString();
    }
}