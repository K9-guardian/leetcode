use std::collections::HashMap;

pub struct Solution;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let (mut longest_length, mut start) = (0, 0);
        let mut map = HashMap::new();

        for (i, val) in s.char_indices() {
            if let Some(&j) = map.get(&val) {
                if j >= start {
                    longest_length = longest_length.max(i - start);
                    start = j + 1;
                }
            }
            map.insert(val, i);
        }

        longest_length.max(s.len() - start) as i32
    }
}
