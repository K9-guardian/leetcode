pub struct Solution;

impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        if s == "" {
            return "".to_string();
        }

        let chars: Vec<char> = s.chars().collect();
        let mut longest = String::new();

        fn max_string(s1: String, s2: String) -> String {
            if s1.len() > s2.len() {
                s1
            } else {
                s2
            }
        }

        for i in 0..chars.len() {
            let (mut start, mut end) = (i as i32, i);

            while start > -1 && end < chars.len() && chars[start as usize] == chars[end] {
                start -= 1;
                end += 1;
            }

            longest = max_string(longest, s[(start + 1) as usize..end].to_string())
        }

        for i in 0..chars.len() - 1 {
            let (mut start, mut end) = (i as i32, i + 1);

            while start > -1 && end < chars.len() && chars[start as usize] == chars[end] {
                start -= 1;
                end += 1;
            }

            longest = max_string(longest, s[(start + 1) as usize..end].to_string())
        }

        longest
    }
}

fn main() {
    println!("{}", Solution::longest_palindrome("".to_string()));
}
