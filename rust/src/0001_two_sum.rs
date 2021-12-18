use std::collections::HashMap;

pub struct Solution;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::new();

        for (i, val) in nums.iter().enumerate() {
            let complement = target - val;

            if let Some(&j) = map.get(&complement) {
                return vec![i as i32, j as i32];
            } else {
                map.insert(val, i);
            }
        }

        unreachable!()
    }
}
